package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.stage;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record LocationDataList(
        List<LocationData> LocationDataList
) implements TopLevelClientResource {
}
