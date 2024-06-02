package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.SetInfo;

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
    private final boolean UseAttendComponent;
    private final boolean DisableTouchAction;
    private final boolean DispElseQuestTalk;
    private final boolean ForceSwitchGreeting;
    private final long TalkStateId;
    private final boolean UseLiteMotion;
    private final boolean IsNoSetOnPS3;
    private final boolean UseJobParamEx;
    private final boolean DispOnWeapon;
    private final short InitEffectType;
}
