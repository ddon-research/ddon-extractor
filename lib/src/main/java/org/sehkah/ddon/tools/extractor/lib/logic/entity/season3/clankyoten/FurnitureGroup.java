package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.logic.MessageFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.MessageLookupUtil;
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
                gmdIdx, MessageLookupUtil.getMessage(MessageFileLookupType.FURNITURE_GROUP_NAME, gmdIdx),
                sortNo);
    }
}
