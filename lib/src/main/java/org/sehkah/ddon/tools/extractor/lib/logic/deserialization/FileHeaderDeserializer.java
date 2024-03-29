package org.sehkah.ddon.tools.extractor.lib.logic.deserialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.error.MagicValidationFailedException;
import org.sehkah.ddon.tools.extractor.lib.common.error.VersionValidationFailedException;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;

@Slf4j
public class FileHeaderDeserializer {
    private final FileHeader expectedFileHeader;

    public FileHeaderDeserializer(FileHeader fileHeader) {
        this.expectedFileHeader = fileHeader;
    }

    private static long readVersion(FileReader fileReader, int versionBytesLength) {
        if (versionBytesLength == 4) {
            return fileReader.readUnsignedInteger();
        } else if (versionBytesLength == 2) {
            return fileReader.readUnsignedShort();
        }
        return -1;
    }

    private static String readMagicString(FileReader fileReader, int magicBytesLength) {
        return fileReader.readString(magicBytesLength);
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

    protected FileHeader parseClientResourceFile(FileReader fileReader) {
        long versionNumber = -1;
        String magicString = null;
        if (expectedFileHeader.magicBytesLength() > 0) {
            magicString = readMagicString(fileReader, expectedFileHeader.magicBytesLength());
        }
        if (expectedFileHeader.versionBytesLength() > 0) {
            versionNumber = readVersion(fileReader, expectedFileHeader.versionBytesLength());
        }
        FileHeader parsedFileHeader = new FileHeader(magicString, versionNumber, expectedFileHeader.versionBytesLength());
        if (parsedFileHeader.magicString() != null && !isMagicValid(parsedFileHeader, expectedFileHeader)) {
            throw new MagicValidationFailedException(parsedFileHeader);
        }
        if (parsedFileHeader.versionNumber() >= 0 && !isVersionValid(parsedFileHeader, expectedFileHeader)) {
            throw new VersionValidationFailedException(parsedFileHeader);
        }
        return parsedFileHeader;
    }
}
