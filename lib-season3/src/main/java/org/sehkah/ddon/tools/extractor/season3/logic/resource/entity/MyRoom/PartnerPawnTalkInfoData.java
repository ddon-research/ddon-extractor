package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.meta.PartnerPawnTalkType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class PartnerPawnTalkInfoData {
    private int Talk;
    private int Type;
    @MetaInformation
    private PartnerPawnTalkType TypeName;

    public PartnerPawnTalkInfoData(int talk, int type) {
        this(
                talk,
                type, PartnerPawnTalkType.of(type)
        );
    }
}
