package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record NpcMeetingPlaceList(
        List<NpcMeetingPlace> NpcMeetingPlaceList
) implements TopLevelClientResource {
}
