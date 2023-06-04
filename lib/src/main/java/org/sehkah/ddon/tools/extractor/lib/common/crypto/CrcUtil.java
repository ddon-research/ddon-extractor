package org.sehkah.ddon.tools.extractor.lib.common.crypto;

import lombok.extern.slf4j.Slf4j;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

@Slf4j
public class CrcUtil {
    public static long jamCrc32(byte[] data) {
        final Checksum crc32 = new CRC32();
        crc32.update(data);
        return ~crc32.getValue() & 0x7FFFFFFF;
    }
}
