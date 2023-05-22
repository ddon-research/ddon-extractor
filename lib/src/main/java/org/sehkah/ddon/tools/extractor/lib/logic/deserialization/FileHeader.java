package org.sehkah.ddon.tools.extractor.lib.logic.deserialization;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Data
@RequiredArgsConstructor
public class FileHeader {
    private final String magicString;
    private final int magicBytesLength;
    private final long versionNumber;
    private final int versionBytesLength;

    public FileHeader(String magicString, int versionNumber, int versionBytesLength) {
        this(magicString, magicString == null ? 0 : magicString.length(), versionNumber, versionBytesLength);
    }

    public FileHeader(int versionNumber, int versionBytesLength) {
        this(null, 0, versionNumber, versionBytesLength);
    }

    public static long magicNumber(String magicString) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(magicString.getBytes(StandardCharsets.US_ASCII));
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return Integer.toUnsignedLong(byteBuffer.getInt());
    }

    public boolean isVersionValid(FileReader fileReader) {
        long encounteredVersionNumber = -1;
        if (versionBytesLength == 4) {
            encounteredVersionNumber = fileReader.readUnsignedInteger();
        } else if (versionBytesLength == 2) {
            encounteredVersionNumber = fileReader.readUnsignedShort();
        }
        if (encounteredVersionNumber != versionNumber) {
            log.error("Encountered version '{}' does not equal expected '{}'.", encounteredVersionNumber, versionNumber);
            return false;
        }
        log.debug("version: '{}'", encounteredVersionNumber);
        return true;
    }

    public boolean isMagicValid(FileReader fileReader) {
        String encounteredMagicString = fileReader.readString(magicBytesLength);
        if (!encounteredMagicString.equals(magicString)) {
            log.error("Encountered magic value '{}' does not equal expected '{}'.", encounteredMagicString, magicString);
            return false;
        }
        log.debug("magic: '{}'", encounteredMagicString);
        return true;
    }
}
