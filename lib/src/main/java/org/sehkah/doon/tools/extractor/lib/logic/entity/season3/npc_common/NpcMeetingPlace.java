package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record NpcMeetingPlace(
        long NpcId,
        int StageNo,
        long StartPosNo
) implements DeserializableClientResource {
}
