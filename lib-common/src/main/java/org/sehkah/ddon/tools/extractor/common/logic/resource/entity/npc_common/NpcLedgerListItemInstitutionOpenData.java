package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.meta.NpcFunctionType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcLedgerListItemInstitutionOpenData {
    private long Type;
    @MetaInformation
    private NpcFunctionType TypeName;
    // isEnableContents = sQuestManagerExt::isMyQuestFlag(isClear, FunctionOpenData->mFlagNo) ^ (mType != 1);
    private long FlagNo;
}
