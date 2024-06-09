package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoNpc extends SetInfo {
    private int NpcId;
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
    private boolean DisableTouchAction;
    private boolean DispElseQuestTalk;
    private SetInfoCoord InfoCharacter;
}
