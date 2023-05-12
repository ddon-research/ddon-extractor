package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

public record PlPartsInfoHeader(
        long Magic,
        long Version,
        long PartsNum,
        long PartsOffset
) {
}
