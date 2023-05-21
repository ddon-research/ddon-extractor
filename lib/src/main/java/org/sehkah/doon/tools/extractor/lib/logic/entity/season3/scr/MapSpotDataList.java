package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.scr;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record MapSpotDataList(
        List<MapSpotData> MapSpotDataList
) implements TopLevelClientResource {
}
