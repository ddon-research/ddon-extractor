package org.sehkah.ddon.tools.extractor.lib.test.logic.resource;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.api.logic.resource.FrameworkResourcesUtil;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrameworkResourcesUtilTest {

    @Test
    void testResourceIdForCraftExpEqualsExpected() {
        String resourceFilePath = "craft\\craft_exp";
        String resourceDataTypeName = "rCraftElementExp";

        BigInteger resId = FrameworkResourcesUtil.convertToResourceId(resourceDataTypeName, resourceFilePath);

        assertEquals(BigInteger.valueOf(3066457904283614086L), resId);
    }

    @Test
    void testPathCrcForCraftExpEqualsExpected() {
        String resourceFilePath = "craft\\craft_exp";
        String resourceDataTypeName = "rCraftElementExp";
        BigInteger resId = FrameworkResourcesUtil.convertToResourceId(resourceDataTypeName, resourceFilePath);

        long pathCrc = FrameworkResourcesUtil.convertResourceIdToPathId(resId);


        assertEquals(2541976454L, pathCrc);
    }

    @Test
    void testTagIdForCraftExpEqualsExpected() {
        String resourceFilePath = "craft\\craft_exp";
        String resourceDataTypeName = "rCraftElementExp";
        BigInteger resId = FrameworkResourcesUtil.convertToResourceId(resourceDataTypeName, resourceFilePath);

        long tagId = FrameworkResourcesUtil.convertResourceIdToTagId(resId);

        assertEquals(713965367L, tagId);
    }

    @Test
    void testTagIdForResourceFileEqualsExpected() {
        String resourceFile = "craft_common";

        long tagId = FrameworkResourcesUtil.convertResourceStringToTagId(resourceFile);

        assertEquals(3311217916L, tagId);
    }

    @Test
    void testSearchIdForResourceEqualsExpected() {
        String resource = "RES_ID_CRAFT_EXP_CEE";

        long searchId = FrameworkResourcesUtil.convertResourceStringToSearchId(resource);

        assertEquals(4283603931L, searchId);
    }

    @Test
    void testTargetTagNumberForResourceFileEqualsExpected() {
        String resourceFile = "craft_common";

        long targetTagNumber = FrameworkResourcesUtil.convertTagIdToTargetTagNumber(FrameworkResourcesUtil.convertResourceStringToTagId(resourceFile));

        assertEquals(124L, targetTagNumber);
    }

    @Test
    void testFileExtensionForResourceFileEqualsExpected() {
        long resourceTypeId = 0x5362A636;

        String fileExtension = FrameworkResourcesUtil.getFileExtension(resourceTypeId);

        assertEquals(".ptc", fileExtension);
    }

    @Test
    void testFileClassNameForResourceFileEqualsExpected() {
        long resourceTypeId = 1379483132;

        String className = FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(resourceTypeId);

        assertEquals("cFSMOrderParamSetLocationName", className);
    }
}
