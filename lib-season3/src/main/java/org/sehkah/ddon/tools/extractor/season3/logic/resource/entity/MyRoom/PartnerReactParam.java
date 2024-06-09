package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class PartnerReactParam {
    private boolean IsNmlAct;
    private long ActNo;
    private short NpcMotNo;
    private short NpcMotNo2;
    private short NpcMotNo3;
    private short NpcMotNo4;
}
