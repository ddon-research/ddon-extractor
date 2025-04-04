package org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.FileParsingIncompleteException;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ClientResourceFileDeserializer<T extends Resource> implements ClientResourceDeserializer<T> {
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

    /**
     * @param filePath
     * @param clientResourceFile
     * @param bufferReader
     * @param lookupUtil         a cache-backed lookup util, may be null, otherwise an infinite loop of lookups would be performed
     * @return
     */
    @Override
    public T deserialize(Path filePath, ClientResourceFile<T> clientResourceFile, BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        FileHeader fileHeader = FileHeaderDeserializer.parseClientResourceFileUnsafe(bufferReader, clientResourceFile.getFileHeader());
        T result;
        try {
            result = parseClientResourceFile(filePath, bufferReader, fileHeader, lookupUtil);
        } catch (Exception e) {
            throw new TechnicalException("Failed to parse resource file '%s'".formatted(filePath), e);
        }
        if (bufferReader.hasRemaining()) {
            throw new FileParsingIncompleteException(filePath, fileHeader, bufferReader.getRemainingCount(), bufferReader.getLimit());
        }
        result.setFileSize(bufferReader.getLimit());
        result.setFileHeader(fileHeader);
        return result;
    }

    protected abstract T parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil);
}
