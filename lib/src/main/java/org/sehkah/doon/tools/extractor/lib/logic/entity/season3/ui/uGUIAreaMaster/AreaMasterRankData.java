package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record AreaMasterRankData(
        long MsgGroupSerial,
        long Point,
        int BonusType
) implements DeserializableClientResource {
}
