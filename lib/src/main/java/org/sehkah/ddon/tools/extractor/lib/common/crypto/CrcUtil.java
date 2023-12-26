package org.sehkah.ddon.tools.extractor.lib.common.crypto;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

@Slf4j
public class CrcUtil {
    private CrcUtil() {

    }

    public static long crc32(byte[] data) {
        final Checksum crc32 = new CRC32();
        crc32.update(data);
        return crc32.getValue();
    }

    public static long crc32(String data, Charset charset) {
        return crc32(data.getBytes(charset));
    }

    public static long crc32(String data) {
        return crc32(data, StandardCharsets.US_ASCII);
    }

    public static long frameworkCrc32(byte[] data) {
        return ~crc32(data) & 0xFFFFFFFFL;
    }

    public static long frameworkCrc32(String data, Charset charset) {
        return frameworkCrc32(data.getBytes(charset));
    }

    public static long frameworkCrc32(String data) {
        return frameworkCrc32(data, StandardCharsets.US_ASCII);
    }

    public static long jamCrc32(byte[] data) {
        return ~crc32(data) & 0x7FFFFFFFL;
    }

    public static long jamCrc32(String data, Charset charset) {
        return jamCrc32(data.getBytes(charset));
    }

    public static long jamCrc32(String data) {
        return jamCrc32(data, StandardCharsets.US_ASCII);
    }
}
