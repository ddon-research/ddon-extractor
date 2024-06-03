package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;

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
