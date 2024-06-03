package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmDoor extends SetInfo {
    private final QuestSetInfoOm InfoOm;
    private final boolean PRT;
    private final Vector3f PRTPos;
    private final float PRTScale;
    private final long TextType;
    private final long TextQuestNo;
    private final long TextNo;
    private final long QuestID;
    private final long QuestFlag;
}
