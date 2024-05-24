package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class StageInfo extends TopLevelClientResource {
    public final StageResourcePointer SchedulerModel;
    public final StageResourcePointer SchedulerFilter;
    public final StageResourcePointer CollisionScrSbc0;
    public final StageResourcePointer CollisionEffSbc0;
    public final StageResourcePointer CollisionScrSbc1;
    public final StageResourcePointer CollisionEffSbc1;
    public final StageResourcePointer CollisionScrSbc2;
    public final StageResourcePointer CollisionEffSbc2;
    public final StageResourcePointer NavigationMeshNaviMesh;
    //    public final StageResourcePointer AIPathConsecutiveWayPoint;
    public final StageResourcePointer OccluderExOCC;
    public final StageResourcePointer StartPosStartPos;
    //    public final StageResourcePointer CameraParamListFld;
    public final StageResourcePointer CameraParamListEvt;
    public final Vector3f Pos;
    public final float Ang;
    public final long SceLoadFlag;
    public final long Flag;
    public final StageResourcePointer WeatherStageInfo;
    public final StageResourcePointer WeatherParamInfoTbl;
    public final StageResourcePointer WeatherParamEfcInfo;
    public final StageResourcePointer WeatherEffectParam;
    public final StageResourcePointer SchedulerStageLightSchdl;
    public final StageResourcePointer EffectProvider;
    public final int EpvIndexAlways;
    public final int EpvIndexDay;
    public final int EpvIndexNight;
    public final List<StageResourcePointer> ZoneList;//4
    public final StageResourcePointer ZoneIndoorScr;
    public final StageResourcePointer ZoneIndoorEfc;
    public final float DayNightLightChgFrame;
    public final float DayNightFogChgFrame;
    public final int SkyInfiniteLightGroup;
    public final List<StageResourcePointer> ZoneUnitCtrl;//3
    public final StageResourcePointer ZoneStatus;
    public final List<StageResourcePointer> SoundZone; //3
    public final List<Float> EqLength; //4
    public final StageResourcePointer SoundAreaInfo;
    public final StageResourcePointer SchedulerEffectSchdl;
    public final StageResourcePointer SchedulerLanternSchdl;
    public final boolean IsCraftStage;
    public final StageResourcePointer LocationData;
    public final float GrassVisiblePercentMulValue;
    public final float GrassFadeBeginDistance;
    public final float GrassFadeEndDistance;
    public final int PerformanceFlag;
    public final String AnotherMapName;
    public final boolean Unknown;
}
