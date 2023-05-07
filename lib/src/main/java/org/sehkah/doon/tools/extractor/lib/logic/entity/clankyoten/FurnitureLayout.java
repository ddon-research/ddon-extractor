package org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten;

public record FurnitureLayout(
        long ID,
        long GroupId,
        boolean IsRemovable,
        int mSortNo,
        long mGmdIdx
) {
}
