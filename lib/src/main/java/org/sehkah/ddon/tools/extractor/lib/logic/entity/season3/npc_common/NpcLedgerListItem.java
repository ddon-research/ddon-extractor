package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.meta.ItemListSexType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.meta.NpcUnitType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.meta.NpcVoiceType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record NpcLedgerListItem(
        long NpcId,
        int Sex,
        @MetaInformation
        ItemListSexType SexType,
        long NameId,
        long ClassNameId,
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
                sex, ItemListSexType.of(sex),
                nameId,
                classNameId,
                jobId,
                finger,
                voiceType, NpcVoiceType.of(voiceType),
                unitType, NpcUnitType.of(unitType),
                unitTypeParam,
                institutionList);
    }
}
