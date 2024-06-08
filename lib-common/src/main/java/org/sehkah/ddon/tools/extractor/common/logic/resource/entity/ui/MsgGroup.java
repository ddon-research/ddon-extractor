package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta.MsgGroupType;

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
    @MetaInformation
    private String NpcName;
    private long GroupNameSerial;
    private long GroupType;
    @MetaInformation
    private MsgGroupType GroupTypeName;
    private boolean NameDispOff;
    private List<MsgData> MsgData;
}
