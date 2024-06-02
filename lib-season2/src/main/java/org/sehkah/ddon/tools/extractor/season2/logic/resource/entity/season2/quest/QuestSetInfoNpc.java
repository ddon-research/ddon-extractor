package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoNpc extends SetInfo {
    private final QuestSetInfoCoord InfoCharacter;
    private final int NpcId;
    private final FSMRelate FsmResource;
    private final boolean IsCommunicate;
    private final int ClothType;
    private final byte DefNPCMotCategory;
    private final byte DefNPCMotNo;
    private final int ThinkIndex;
    private final int JobLv;
    private final int Lantern;
    private final boolean DisableScrAdj;
    private final boolean DisableLedgerFinger;
    private final boolean IsForceListTalk;
    private final boolean IsAttand;
    private final boolean DisableTouchAction;
    private final boolean DispElseQuestTalk;
}
