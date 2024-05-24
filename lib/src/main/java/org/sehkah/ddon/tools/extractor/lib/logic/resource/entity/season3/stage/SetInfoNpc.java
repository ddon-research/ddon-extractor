package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoNpc extends SetInfo {
    private final int NpcId;
    private final String FilePath;
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
    private final short Unknown1;
    private final short Unknown2;
    private final short Unknown3;
    private final short Unknown4;
    private final short Unknown5;
    private final short Unknown6;
    private final SetInfoCoord InfoCharacter;
}
