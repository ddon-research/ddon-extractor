package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record FurnitureGroup(
        long ID,
        long CameraNo,
        long GmdIdx,
        @MetaInformation
        String FurnitureGroupName,
        int SortNo
) {
    public FurnitureGroup(long ID, long cameraNo, long gmdIdx, int sortNo) {
        this(ID,
                cameraNo,
                gmdIdx, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.FURNITURE_GROUP_NAME, gmdIdx),
                sortNo);
    }
}
