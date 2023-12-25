package org.sehkah.ddon.tools.extractor.lib.common.crypto;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;

import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@Slf4j
public class ZipUtil {
    private ZipUtil() {

    }

    public static byte[] decompress(byte[] input, int expectedSize) {
        final Inflater decompresser = new Inflater();
        decompresser.setInput(input);
        byte[] buffer = new byte[expectedSize];
        try {
            int decompressedSize = decompresser.inflate(buffer);
            if (decompressedSize == buffer.length) {
                return buffer;
            } else {
                return Arrays.copyOfRange(buffer, 0, decompressedSize);
            }
        } catch (DataFormatException e) {
            throw new TechnicalException("Decompression has failed!", e);
        } finally {
            decompresser.end();
        }
    }
}
