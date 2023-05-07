package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import java.util.List;

public record AbilityList(
        int UnknownByte1,
        int UnknownByte2,
        int UnknownShort,
        long DataListNum,
        List<AbilityData> DataList
) {
    public AbilityList(int UnknownByte1, int UnknownByte2, int UnknownShort, List<AbilityData> DataList) {
        this(UnknownByte1, UnknownByte2, UnknownShort, DataList.size(), DataList);
    }
}
