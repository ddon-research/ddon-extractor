package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.equip;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record EquipPresetList(
        List<EquipPreset> EquipPresetList
) implements TopLevelClientResource {
}
