package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.SetInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.meta.SetInfoCoordOmIdType;

public record QuestSet(
        long OmID,
        @MetaInformation
        SetInfoCoordOmIdType OmIDType,
        long UnitNo,
        String Comment,
        long Kind,
        SetInfo setInfo
) {
    public QuestSet(long omID, long unitNo, String comment, long kind, SetInfo setInfo) {
        this(omID, SetInfoCoordOmIdType.of((int) omID),
                unitNo, comment, kind, setInfo);
    }
}
