package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.meta.NpcFunctionIdType;

import java.util.List;

// See sNpcManager::getFunctionParam(qword_259C718, NpcId, 0x16u);
public record NpcLedgerListItemInstitution(
        long FunctionId,
        @MetaInformation
        String FunctionName,
        @MetaInformation
        NpcFunctionIdType FunctionIdType,
        // if ( !sNpcManager::getJobMasterState(v8, FunctionParam) || sNpcManager::getJobMasterState(v8, FunctionParam) == 4 )
        long FunctionParam,
        List<NpcLedgerListItemInstitutionOpenData> FunctionOpenList
) {
    public NpcLedgerListItemInstitution(long institutionId, long institutionParam, List<NpcLedgerListItemInstitutionOpenData> institutionOpenList) {
        this(
                institutionId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.FUNC_SELECT_NAME, "FUNC_SELECT_NAME_" + institutionId), NpcFunctionIdType.of(institutionId),
                institutionParam,
                institutionOpenList);
    }
}
