package org.sehkah.ddon.tools.extractor.season3.resource.entity.quest;

import org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.SetInfo;

public record QuestSet(
        long OmID,
        long UnitNo,
        String Comment,
        long Kind,
        SetInfo setInfo
) {
}
