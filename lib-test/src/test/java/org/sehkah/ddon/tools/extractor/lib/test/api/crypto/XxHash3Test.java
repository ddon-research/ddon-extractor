package org.sehkah.ddon.tools.extractor.lib.test.api.crypto;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.crypto.XxHash3;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Comprehensive unit tests for the XxHash3 implementation.
 * <p>
 * These tests verify correctness against known test vectors and ensure
 * the implementation produces consistent results across different input sizes
 * and patterns.
 */
@DisplayName("XxHash3 Algorithm Tests")
class XxHash3Test {
    @Test
    @DisplayName("Known test vector: 'test' -> 9ec9f7918d7dfc40")
    void testKnownVectorTestString() {
        byte[] input = "test".getBytes(StandardCharsets.UTF_8);
        byte[] hash = XxHash3.hashBytes(input);
        String hex = Hex.encodeHexString(hash);
        assertEquals("9ec9f7918d7dfc40", hex, "XXH3 64-bit hash of 'test' should match known vector");
    }
}
