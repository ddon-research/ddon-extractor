package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

import java.util.List;

public record AbilityList(
        int UnknownByte1,
        int UnknownByte2,
        int UnknownShort,
        long DataListNum,
        List<AbilityData> DataList
) implements DeserializableClientResource {
    public AbilityList(int UnknownByte1, int UnknownByte2, int UnknownShort, List<AbilityData> DataList) {
        this(
                UnknownByte1,
                UnknownByte2,
                UnknownShort,
                DataList.size(),
                DataList);
    }
}
