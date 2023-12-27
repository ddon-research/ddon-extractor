package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.meta.NpcFunctionType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
