package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmDoor extends SetInfo {
    private boolean PRT;
    private Vector3f PRTPos;
    private float PRTScale;
    private long TextType;
    private long TextQuestNo;
    private long TextNo;
    private long QuestID;
    @MetaInformation
    private Translation QuestName;
    private long QuestFlag;
    private SetInfoOm InfoOm;
}
