package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.GroupParamKillAreaType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GroupParam {
    private GroupParamDataCommon DataCommon;
    private List<GroupParamId> LayoutIdArray;
    private GroupParamLoadCondition LoadCondition1;
    private GroupParamDataLotFlag DataLotFlag;
    private GroupParamLoadCondition LoadCondition2;
    private GroupParamGuardData GuardData;
    private GroupParamLoadCondition LoadCondition3;
    private GroupParamLoadCondition LoadCondition4;
    private long LoadStageNo;
    private GroupParamSetCondition SetCondition1;
    private List<AreaHitShape> AreaHitShapeList;
    private GroupParamSetCondition SetCondition2;
    private GroupParamSetCondition SetCondition3;
    private GroupParamDeleteCondition DeleteCondition1;
    private GroupParamDeleteCondition DeleteCondition2;
    private List<GroupParamLifeArea> LifeAreaArray;
    private int KillAreaType;
    @MetaInformation
    private GroupParamKillAreaType KillAreaTypeName;
    private List<AreaHitShape> KillAreaList;

    public GroupParam(GroupParamDataCommon dataCommon, List<GroupParamId> layoutIdArray, GroupParamLoadCondition loadCondition1, GroupParamDataLotFlag dataLotFlag, GroupParamLoadCondition loadCondition2, GroupParamGuardData guardData, GroupParamLoadCondition loadCondition3, GroupParamLoadCondition loadCondition4, long loadStageNo, GroupParamSetCondition setCondition1, List<AreaHitShape> areaHitShapeList, GroupParamSetCondition setCondition2, GroupParamSetCondition setCondition3, GroupParamDeleteCondition deleteCondition1, GroupParamDeleteCondition deleteCondition2, List<GroupParamLifeArea> lifeAreaArray, int killAreaType, List<AreaHitShape> killAreaList) {
        DataCommon = dataCommon;
        LayoutIdArray = layoutIdArray;
        LoadCondition1 = loadCondition1;
        DataLotFlag = dataLotFlag;
        LoadCondition2 = loadCondition2;
        GuardData = guardData;
        LoadCondition3 = loadCondition3;
        LoadCondition4 = loadCondition4;
        LoadStageNo = loadStageNo;
        SetCondition1 = setCondition1;
        AreaHitShapeList = areaHitShapeList;
        SetCondition2 = setCondition2;
        SetCondition3 = setCondition3;
        DeleteCondition1 = deleteCondition1;
        DeleteCondition2 = deleteCondition2;
        LifeAreaArray = lifeAreaArray;
        KillAreaType = killAreaType;
        KillAreaTypeName = GroupParamKillAreaType.of(killAreaType);
        KillAreaList = killAreaList;
    }
}
