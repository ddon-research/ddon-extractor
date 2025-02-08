package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.meta.NpcSexType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.meta.NpcUnitType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.meta.NpcVoiceType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcLedgerListItem {
    private long NpcId;
    private int Sex;
    @MetaInformation
    private NpcSexType SexType;
    private long NameId;
    @MetaInformation
    private Translation NpcName;
    private long ClassNameId;
    @MetaInformation
    private Translation NpcClassName;
    private int JobId;
    @MetaInformation
    private Translation JobName;
    private int Finger;
    private int VoiceType;
    @MetaInformation
    private NpcVoiceType VoiceTypeName;
    private int UnitType;
    @MetaInformation
    private NpcUnitType UnitTypeName;
    private long UnitTypeParam;
    private List<NpcLedgerListItemInstitution> InstitutionList;
}
