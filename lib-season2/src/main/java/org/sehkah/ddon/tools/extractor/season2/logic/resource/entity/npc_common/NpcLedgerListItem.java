package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.meta.NpcSexType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.meta.NpcUnitType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.meta.NpcVoiceType;

import java.util.List;

public record NpcLedgerListItem(
        long NpcId,
        int Sex,
        @MetaInformation
        NpcSexType SexType,
        long NameId,
        @MetaInformation
        String NpcName,
        long ClassNameId,
        @MetaInformation
        String NpcClassName,
        int JobId,
        int Finger,
        int VoiceType,
        @MetaInformation
        NpcVoiceType VoiceTypeName,
        int UnitType,
        @MetaInformation
        NpcUnitType UnitTypeName,
        long UnitTypeParam,
        List<NpcLedgerListItemInstitution> InstitutionList
) {
    public NpcLedgerListItem(long npcId, int sex, long nameId, long classNameId, int jobId, int finger, int voiceType,
                             int unitType, long unitTypeParam, List<NpcLedgerListItemInstitution> institutionList) {
        this(npcId,
                sex, NpcSexType.of(sex),
                nameId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.NPC_NAME, nameId),
                classNameId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.NPC_CLASS_NAME, classNameId),
                jobId,
                finger,
                voiceType, NpcVoiceType.of(voiceType),
                unitType, NpcUnitType.of(unitType),
                unitTypeParam,
                institutionList);
    }
}
