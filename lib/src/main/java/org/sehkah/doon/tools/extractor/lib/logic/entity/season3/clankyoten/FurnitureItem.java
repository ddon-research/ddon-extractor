package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record FurnitureItem(
        long ItemId,
        long LayoutId,
        long OmId
) implements DeserializableClientResource {
}
