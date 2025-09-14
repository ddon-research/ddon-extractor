package org.sehkah.ddon.tools.extractor.cli.logic.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.MurmurHash3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Utility responsible for deciding whether a target file should be written based on
 * size + content hash (MurmurHash3 128-bit).
 */
@Slf4j
public class FileChangeDetector {

    public static long[] computeHash(byte[] data) {
        return MurmurHash3.hash128x64(data, 0, data.length, 0);
    }

    /**
     * Returns true if file does not exist or differs in size/content; false if identical.
     */
    public boolean shouldWrite(Path target, byte[] newBytes) {
        try {
            if (!Files.exists(target)) {
                return true;
            }
            long existingSize = Files.size(target);
            if (existingSize != newBytes.length) {
                return true;
            }
            byte[] existingBytes = Files.readAllBytes(target);
            long[] existingHash = computeHash(existingBytes);
            long[] newHash = computeHash(newBytes);
            return !Arrays.equals(newHash, existingHash);
        } catch (IOException e) {
            log.warn("Failed to compare existing file '{}' with new content, proceeding to overwrite.", target);
            return true; // Fail-safe: prefer overwriting
        }
    }
}
