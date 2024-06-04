package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.meta.NpcFunctionIdType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcLedgerListItemInstitution {
    private long FunctionId;
    @MetaInformation
    private String FunctionName;
    @MetaInformation
    private NpcFunctionIdType FunctionIdType;
    // if ( !sNpcManager::getJobMasterState(v8, FunctionParam) || sNpcManager::getJobMasterState(v8, FunctionParam) == 4 )
    private long FunctionParam;
    private List<NpcLedgerListItemInstitutionOpenData> FunctionOpenList;

    public NpcLedgerListItemInstitution(long institutionId, long institutionParam, List<NpcLedgerListItemInstitutionOpenData> institutionOpenList) {
        this(
                institutionId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.FUNC_SELECT_NAME, "FUNC_SELECT_NAME_" + institutionId), NpcFunctionIdType.of(institutionId),
                institutionParam,
                institutionOpenList);
    }
}
