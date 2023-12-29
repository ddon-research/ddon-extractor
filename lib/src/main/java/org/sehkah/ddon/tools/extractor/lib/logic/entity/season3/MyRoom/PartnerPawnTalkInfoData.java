package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom.meta.PartnerPawnTalkType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record PartnerPawnTalkInfoData(
        int Talk,
        int Type,
        @MetaInformation
        PartnerPawnTalkType TypeName
) {
    public PartnerPawnTalkInfoData(int talk, int type) {
        this(
                talk,
                type, PartnerPawnTalkType.of(type)
        );
    }
}
