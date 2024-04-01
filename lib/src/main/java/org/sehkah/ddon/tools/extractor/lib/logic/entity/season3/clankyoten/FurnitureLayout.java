package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.clankyoten;

public record FurnitureLayout(
        long ID,
        long GroupId,
        boolean IsRemovable,
        int SortNo,
        // TODO: GmdIdx does not seem to correspond to an actual GMD MessageIndex
        long GmdIdx
) {
}
