package org.sehkah.ddon.tools.extractor.api.entity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public record FileHeader(
        String magicString,
        int magicBytesLength,
        long versionNumber,
        int versionBytesLength
) {
    public FileHeader(String magicString, long versionNumber, int versionBytesLength) {
        this(
                magicString, magicString == null ? 0 : magicString.length(),
                versionNumber, versionBytesLength
        );
    }

    public FileHeader(long versionNumber, int versionBytesLength) {
        this(
                null, 0,
                versionNumber, versionBytesLength
        );
    }

    public static long magicNumber(String magicString) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(magicString.getBytes(StandardCharsets.US_ASCII));
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return Integer.toUnsignedLong(byteBuffer.getInt());
    }
}
