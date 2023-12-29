package org.sehkah.ddon.tools.extractor.lib.test.common.crypto;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.crypto.CrcUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrcUtilTest {

    @Test
    void testJamCrc32ForTextureResourceEqualsExpected() {
        String resourceClass = "rCraftElementExp";

        long crc = CrcUtil.jamCrc32(resourceClass);

        assertEquals(713965367L, crc);
    }

    @Test
    void testFrameworkCrc32ForSearchIdEqualsExpected() {
        String resourceFile = "craft_common";

        long crc = CrcUtil.frameworkCrc32(resourceFile.getBytes());

        assertEquals(3311217916L, crc);
    }

    @Test
    void testCrc32ForTargetTagNumberEqualsExpected() {
        String resourceFile = "craft_common";

        long crc = CrcUtil.frameworkCrc32(resourceFile.getBytes()) & 0x7FL;

        assertEquals(124L, crc);
    }
}
