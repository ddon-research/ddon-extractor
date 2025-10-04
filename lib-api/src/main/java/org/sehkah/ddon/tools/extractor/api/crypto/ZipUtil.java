package org.sehkah.ddon.tools.extractor.api.crypto;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;

import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@Slf4j
public class ZipUtil {
    private static final ThreadLocal<Inflater> INFLATER_CACHE = ThreadLocal.withInitial(Inflater::new);

    private ZipUtil() {
    }

    public static byte[] decompress(byte[] input, int expectedSize) {
        Inflater inflater = INFLATER_CACHE.get();
        inflater.reset();
        inflater.setInput(input);
        byte[] out = new byte[expectedSize];
        try {
            int len = inflater.inflate(out);
            if (len == out.length) return out;
            return Arrays.copyOf(out, len);
        } catch (DataFormatException e) {
            throw new TechnicalException("Decompression failed", e);
        }
    }
}
