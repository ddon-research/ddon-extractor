package org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.error.MagicValidationFailedException;
import org.sehkah.ddon.tools.extractor.api.error.VersionValidationFailedException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;

@Slf4j
public class FileHeaderDeserializer {
    private static long readVersion(BufferReader bufferReader, int versionBytesLength) {
        if (versionBytesLength == 4) {
            return bufferReader.readUnsignedInteger();
        } else if (versionBytesLength == 2) {
            return bufferReader.readUnsignedShort();
        }
        return -1;
    }

    private static String readMagicString(BufferReader bufferReader, int magicBytesLength) {
        return bufferReader.readString(magicBytesLength);
    }

    private static boolean isVersionValid(FileHeader encountered, FileHeader expected) {
        if (encountered.versionNumber() != expected.versionNumber()) {
            log.error("Encountered version '{}' does not equal expected '{}'.", encountered.versionNumber(), expected.versionNumber());
            return false;
        }
        log.debug("version: '{}'", encountered.versionNumber());
        return true;
    }

    private static boolean isMagicValid(FileHeader encountered, FileHeader expected) {
        if (!encountered.magicString().equals(expected.magicString())) {
            log.error("Encountered magic value '{}' does not equal expected '{}'.", encountered.magicString(), expected.magicString());
            return false;
        }
        log.debug("magic: '{}'", encountered.magicString());
        return true;
    }

    protected static FileHeader parseClientResourceFile(BufferReader bufferReader, FileHeader expectedFileHeader) {
        FileHeader parsedFileHeader = parseClientResourceFileUnsafe(bufferReader, expectedFileHeader);
        if (parsedFileHeader.magicString() != null && !isMagicValid(parsedFileHeader, expectedFileHeader)) {
            throw new MagicValidationFailedException(parsedFileHeader);
        }
        if (parsedFileHeader.versionNumber() >= 0 && !isVersionValid(parsedFileHeader, expectedFileHeader)) {
            throw new VersionValidationFailedException(parsedFileHeader);
        }
        return parsedFileHeader;
    }

    protected static FileHeader parseClientResourceFileUnsafe(BufferReader bufferReader, FileHeader expectedFileHeader) {
        long versionNumber = -1;
        String magicString = null;
        if (expectedFileHeader.magicBytesLength() > 0) {
            magicString = readMagicString(bufferReader, expectedFileHeader.magicBytesLength());
        }
        if (expectedFileHeader.versionBytesLength() > 0) {
            versionNumber = readVersion(bufferReader, expectedFileHeader.versionBytesLength());
        }
        return new FileHeader(magicString, versionNumber, expectedFileHeader.versionBytesLength());
    }
}
