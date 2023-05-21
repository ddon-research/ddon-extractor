package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.MyRoom;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record AnimalDataList(
        List<AnimalData> AnimalDataList
) implements TopLevelClientResource {
}
