package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;

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