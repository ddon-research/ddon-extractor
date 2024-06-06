package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.ResourceMetadataLookupUtilSeason2;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.meta.NpcSexType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.meta.NpcUnitType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.meta.NpcVoiceType;

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
    private String NpcName;
    private long ClassNameId;
    @MetaInformation
    private String NpcClassName;
    private int JobId;
    private int Finger;
    private int VoiceType;
    @MetaInformation
    private NpcVoiceType VoiceTypeName;
    private int UnitType;
    @MetaInformation
    private NpcUnitType UnitTypeName;
    private long UnitTypeParam;
    private List<NpcLedgerListItemInstitution> InstitutionList;

    public NpcLedgerListItem(long npcId, int sex, long nameId, long classNameId, int jobId, int finger, int voiceType,
                             int unitType, long unitTypeParam, List<NpcLedgerListItemInstitution> institutionList) {
        this(npcId,
                sex, NpcSexType.of(sex),
                nameId, ResourceMetadataLookupUtilSeason2.getMessage(ResourceFileLookupType.NPC_NAME, nameId),
                classNameId, ResourceMetadataLookupUtilSeason2.getMessage(ResourceFileLookupType.NPC_CLASS_NAME, classNameId),
                jobId,
                finger,
                voiceType, NpcVoiceType.of(voiceType),
                unitType, NpcUnitType.of(unitType),
                unitTypeParam,
                institutionList);
    }
}
