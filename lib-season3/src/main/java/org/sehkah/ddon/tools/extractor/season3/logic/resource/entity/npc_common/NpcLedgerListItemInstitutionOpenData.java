package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.meta.NpcFunctionType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
// See sNpcManager::getFunctionOpenData
// mType = FunctionOpenData->mType;
public class NpcLedgerListItemInstitutionOpenData {
    private long Type;
    @MetaInformation
    private NpcFunctionType TypeName;
    // isEnableContents = sQuestManagerExt::isMyQuestFlag(isClear, FunctionOpenData->mFlagNo) ^ (mType != 1);
    private long FlagNo;

    public NpcLedgerListItemInstitutionOpenData(long type, long flagNo) {
        this(
                type, NpcFunctionType.of(type),
                flagNo);
    }
}
