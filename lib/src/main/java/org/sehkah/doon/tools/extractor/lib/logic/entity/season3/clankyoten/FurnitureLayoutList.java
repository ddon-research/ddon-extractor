package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record FurnitureLayoutList(
        List<FurnitureLayout> FurnitureLayoutList
) implements TopLevelClientResource {
}
