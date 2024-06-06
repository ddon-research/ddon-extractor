package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ResourceMetadataLookupUtilSeason3;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.meta.NpcFunctionIdType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcLedgerListItemInstitution {
    // See sNpcManager::getFunctionParam(qword_259C718, NpcId, 0x16u);
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
                institutionId, ResourceMetadataLookupUtilSeason3.getMessage(ResourceFileLookupType.FUNC_SELECT_NAME, "FUNC_SELECT_NAME_" + institutionId), NpcFunctionIdType.of(institutionId),
                institutionParam,
                institutionOpenList);
    }
}
