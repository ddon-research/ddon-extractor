package org.sehkah.ddon.tools.extractor.lib.logic.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.FileParsingIncompleteException;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;

import java.util.HashSet;
import java.util.Set;

public abstract class ClientResourceFileDeserializer implements ClientResourceDeserializer<TopLevelClientResource> {
    private final FileHeaderDeserializer fileHeaderDeserializer;

    protected ClientResourceFileDeserializer(ClientResourceFile clientResourceFile) {
        this.fileHeaderDeserializer = new FileHeaderDeserializer(clientResourceFile.getFileHeader());
    }

    public static Set<FileHeader> identifyFileHeaderCandidates(FileReader fileReader) {
        // case 1: 4 + 4
        String magicStringBeforeFourByteVersion = fileReader.readString(4);
        long fourByteVersionAfterMagicString = fileReader.readUnsignedInteger();
        fileReader.setPosition(fileReader.getPosition() - 8);
        // case 2: 0 + 4
        long fourByteVersionNoMagicString = fileReader.readUnsignedInteger();
        fileReader.setPosition(fileReader.getPosition() - 4);
        // case 3: 4 + 2
        String magicStringBeforeTwoByteVersion = fileReader.readString(4);
        long twoByteVersionAfterMagicString = fileReader.readUnsignedShort();
        fileReader.setPosition(fileReader.getPosition() - 6);
        // case 4: 0 + 2
        long twoByteVersionNoMagicString = fileReader.readUnsignedShort();
        fileReader.setPosition(fileReader.getPosition() - 2);

        FileHeader fileHeaderIntVersionWithMagicString = new FileHeader(magicStringBeforeFourByteVersion, 4, fourByteVersionAfterMagicString, 4);
        FileHeader fileHeaderIntVersionNoMagicString = new FileHeader((int) fourByteVersionNoMagicString, 4);
        FileHeader fileHeaderShortVersionWithMagicString = new FileHeader(magicStringBeforeTwoByteVersion, 4, twoByteVersionAfterMagicString, 2);
        FileHeader fileHeaderShortVersionNoMagicString = new FileHeader((int) twoByteVersionNoMagicString, 2);

        HashSet<FileHeader> fileHeaderCandidates = new HashSet<>(4);
        fileHeaderCandidates.add(fileHeaderIntVersionWithMagicString);
        fileHeaderCandidates.add(fileHeaderIntVersionNoMagicString);
        fileHeaderCandidates.add(fileHeaderShortVersionWithMagicString);
        fileHeaderCandidates.add(fileHeaderShortVersionNoMagicString);

        return fileHeaderCandidates;
    }

    @Override
    public TopLevelClientResource deserialize(FileReader fileReader) {
        FileHeader fileHeader = fileHeaderDeserializer.parseClientResourceFile(fileReader);
        TopLevelClientResource result = parseClientResourceFile(fileReader);
        if (fileReader.hasRemaining()) {
            throw new FileParsingIncompleteException(fileReader.getRemainingCount(), fileReader.getLimit());
        }
        result.setFileSize(fileReader.getLimit());
        result.setFileHeader(fileHeader);
        return result;
    }

    protected abstract TopLevelClientResource parseClientResourceFile(FileReader fileReader);
}
