package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.meta.NpcFunctionIdType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

// See sNpcManager::getFunctionParam(qword_259C718, NpcId, 0x16u);
public record NpcLedgerListItemInstitution(
        long FunctionId,
        @MetaInformation
        NpcFunctionIdType FunctionIdType,
        // if ( !sNpcManager::getJobMasterState(v8, FunctionParam) || sNpcManager::getJobMasterState(v8, FunctionParam) == 4 )
        long FunctionParam,
        List<NpcLedgerListItemInstitutionOpenData> FunctionOpenList
) {
    public NpcLedgerListItemInstitution(long institutionId, long institutionParam, List<NpcLedgerListItemInstitutionOpenData> institutionOpenList) {
        this(
                institutionId, NpcFunctionIdType.of(institutionId),
                institutionParam,
                institutionOpenList);
    }
}
