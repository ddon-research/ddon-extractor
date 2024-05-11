package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.FileParsingIncompleteException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ClientResourceFileDeserializer implements ClientResourceDeserializer<TopLevelClientResource> {
    private final FileHeaderDeserializer fileHeaderDeserializer;

    protected ClientResourceFileDeserializer(ClientResourceFile clientResourceFile) {
        this.fileHeaderDeserializer = new FileHeaderDeserializer(clientResourceFile.getFileHeader());
    }

    public static Set<FileHeader> identifyFileHeaderCandidates(BufferReader bufferReader) {
        // case 1: 4 + 4
        String magicStringBeforeFourByteVersion = bufferReader.readString(4);
        long fourByteVersionAfterMagicString = bufferReader.readUnsignedInteger();
        bufferReader.setPosition(bufferReader.getPosition() - 8);
        // case 2: 0 + 4
        long fourByteVersionNoMagicString = bufferReader.readUnsignedInteger();
        bufferReader.setPosition(bufferReader.getPosition() - 4);
        // case 3: 4 + 2
        String magicStringBeforeTwoByteVersion = bufferReader.readString(4);
        long twoByteVersionAfterMagicString = bufferReader.readUnsignedShort();
        bufferReader.setPosition(bufferReader.getPosition() - 6);
        // case 4: 0 + 2
        long twoByteVersionNoMagicString = bufferReader.readUnsignedShort();
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        FileHeader fileHeaderIntVersionWithMagicString = new FileHeader(magicStringBeforeFourByteVersion, 4, fourByteVersionAfterMagicString, 4);
        FileHeader fileHeaderIntVersionNoMagicString = new FileHeader((int) fourByteVersionNoMagicString, 4);
        FileHeader fileHeaderShortVersionWithMagicString = new FileHeader(magicStringBeforeTwoByteVersion, 4, twoByteVersionAfterMagicString, 2);
        FileHeader fileHeaderShortVersionNoMagicString = new FileHeader((int) twoByteVersionNoMagicString, 2);

        HashSet<FileHeader> fileHeaderCandidates = LinkedHashSet.newLinkedHashSet(4);
        fileHeaderCandidates.add(fileHeaderShortVersionWithMagicString); // mostly for ARC files
        fileHeaderCandidates.add(fileHeaderIntVersionWithMagicString);
        fileHeaderCandidates.add(fileHeaderIntVersionNoMagicString);
        fileHeaderCandidates.add(fileHeaderShortVersionNoMagicString); // least likely variant

        return fileHeaderCandidates;
    }

    @Override
    public TopLevelClientResource deserialize(BufferReader bufferReader) {
        FileHeader fileHeader = fileHeaderDeserializer.parseClientResourceFile(bufferReader);
        TopLevelClientResource result = parseClientResourceFile(bufferReader);
        if (bufferReader.hasRemaining()) {
            throw new FileParsingIncompleteException(fileHeader, bufferReader.getRemainingCount(), bufferReader.getLimit());
        }
        result.setFileSize(bufferReader.getLimit());
        result.setFileHeader(fileHeader);
        return result;
    }

    protected abstract TopLevelClientResource parseClientResourceFile(BufferReader bufferReader);
}
