package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record CraftElementExpList(
        List<CraftElementExpData> CraftElementExpDataList
) implements TopLevelClientResource {
}
