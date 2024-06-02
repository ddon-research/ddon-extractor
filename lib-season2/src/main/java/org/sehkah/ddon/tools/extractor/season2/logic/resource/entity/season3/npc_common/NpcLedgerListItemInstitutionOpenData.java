package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.npc_common.meta.NpcFunctionType;

// See sNpcManager::getFunctionOpenData
// mType = FunctionOpenData->mType;
public record NpcLedgerListItemInstitutionOpenData(
        long Type,
        @MetaInformation
        NpcFunctionType TypeName,
// isEnableContents = sQuestManagerExt::isMyQuestFlag(isClear, FunctionOpenData->mFlagNo) ^ (mType != 1);
        long FlagNo
) {
    public NpcLedgerListItemInstitutionOpenData(long type, long flagNo) {
        this(
                type, NpcFunctionType.of(type),
                flagNo);
    }
}
