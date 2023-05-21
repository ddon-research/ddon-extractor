package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record FurnitureLayout(
        long ID,
        long GroupId,
        boolean IsRemovable,
        int mSortNo,
        long mGmdIdx
) implements DeserializableClientResource {
}
