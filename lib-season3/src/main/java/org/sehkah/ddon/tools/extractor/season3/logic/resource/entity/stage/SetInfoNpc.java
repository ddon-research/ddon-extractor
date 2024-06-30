package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoNpc extends SetInfo {
    private int NpcId;
    @MetaInformation
    private Translation NpcName;
    private String FilePath;
    private boolean IsCommunicate;
    private int ClothType;
    private byte DefNPCMotCategory;
    private byte DefNPCMotNo;
    private int ThinkIndex;
    private int JobLv;
    private int Lantern;
    private boolean DisableScrAdj;
    private boolean DisableLedgerFinger;
    private boolean IsForceListTalk;
    private boolean IsAttand;
    private boolean UseAttendComponent;
    private boolean DisableTouchAction;
    private long TalkStateId;
    private boolean DispElseQuestTalk;
    private boolean ForceSwitchGreeting;
    private boolean UseLiteMotion;
    private boolean IsNoSetOnPS3;
    private boolean UseJobParamEx;
    private boolean DispOnWeapon;
    private short InitEffectType;
    private SetInfoCoord InfoCharacter;
}
