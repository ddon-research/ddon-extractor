package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.meta.PartnerPawnTalkType;

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
