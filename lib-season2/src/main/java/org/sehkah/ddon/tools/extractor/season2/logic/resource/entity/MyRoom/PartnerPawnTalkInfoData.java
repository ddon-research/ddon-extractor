package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.meta.PartnerPawnTalkType;

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
