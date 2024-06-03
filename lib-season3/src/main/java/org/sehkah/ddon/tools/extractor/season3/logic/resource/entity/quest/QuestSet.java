package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.SetInfo;

public record QuestSet(
        long OmID,
        long UnitNo,
        String Comment,
        long Kind,
        SetInfo setInfo
) {
}
