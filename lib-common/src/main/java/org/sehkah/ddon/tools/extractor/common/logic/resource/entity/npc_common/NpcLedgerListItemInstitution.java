package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.meta.NpcFunctionIdType;

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
}
