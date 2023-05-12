package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

import java.util.List;

public record PlPartsInfoList(
        PlPartsInfoHeader Header,
        List<List<Short>> Parts
) {
}
