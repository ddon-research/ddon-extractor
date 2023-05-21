package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record AreaMasterSpotDataList(
        List<AreaMasterSpotData> AreaMasterSpotDataList
) implements TopLevelClientResource {
}
