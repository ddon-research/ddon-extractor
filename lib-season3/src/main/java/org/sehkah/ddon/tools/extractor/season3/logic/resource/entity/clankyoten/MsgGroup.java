package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MsgGroup {
    private long GroupSerial;
    private long NpcId;
    private long GroupNameSerial;
    private long GroupType;
    private boolean NameDispOff;
    private List<MsgData> MsgData;
}
