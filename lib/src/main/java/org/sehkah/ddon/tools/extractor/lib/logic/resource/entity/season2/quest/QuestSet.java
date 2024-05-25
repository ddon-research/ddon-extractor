package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.quest;

import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.SetInfo;

public record QuestSet(
        long OmID,
        long UnitNo,
        String Comment,
        long Kind,
        SetInfo setInfo
) {
}
