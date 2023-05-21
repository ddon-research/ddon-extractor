package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record FurnitureGroup(
        long ID,
        long CameraNo,
        long GmdIdx,
        int SortNo
) implements DeserializableClientResource {
}
