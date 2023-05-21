package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;


import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record IncreaseParam(
        long Lv,
        long Atk,
        long Def,
        long MAtk,
        long MDef
) implements DeserializableClientResource {
}
