package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageInfo extends Resource {
    public StageResourcePointer SchedulerModel;
    public StageResourcePointer SchedulerFilter;
    public StageResourcePointer CollisionScrSbc0;
    public StageResourcePointer CollisionEffSbc0;
    public StageResourcePointer CollisionScrSbc1;
    public StageResourcePointer CollisionEffSbc1;
    public StageResourcePointer CollisionScrSbc2;
    public StageResourcePointer CollisionEffSbc2;
    public StageResourcePointer NavigationMeshNaviMesh;
    //    public StageResourcePointer AIPathConsecutiveWayPoint;
    public StageResourcePointer OccluderExOCC;
    public StageResourcePointer StartPosStartPos;
    //    public StageResourcePointer CameraParamListFld;
    public StageResourcePointer CameraParamListEvt;
    public Vector3f Pos;
    public float Ang;
    public long SceLoadFlag;
    public long Flag;
    public StageResourcePointer WeatherStageInfo;
    public StageResourcePointer WeatherParamInfoTbl;
    public StageResourcePointer WeatherParamEfcInfo;
    public StageResourcePointer WeatherEffectParam;
    public StageResourcePointer SchedulerStageLightSchdl;
    public StageResourcePointer EffectProvider;
    public int EpvIndexAlways;
    public int EpvIndexDay;
    public int EpvIndexNight;
    public List<StageResourcePointer> ZoneList;//4
    public StageResourcePointer ZoneIndoorScr;
    public StageResourcePointer ZoneIndoorEfc;
    public float DayNightLightChgFrame;
    public float DayNightFogChgFrame;
    public int SkyInfiniteLightGroup;
    public List<StageResourcePointer> ZoneUnitCtrl;//3
    public StageResourcePointer ZoneStatus;
    public List<StageResourcePointer> SoundZone; //3
    public List<Float> EqLength; //4
    public StageResourcePointer SoundAreaInfo;
    public StageResourcePointer SchedulerEffectSchdl;
    public StageResourcePointer SchedulerLanternSchdl;
    public boolean IsCraftStage;
    public StageResourcePointer LocationData;
    public float GrassVisiblePercentMulValue;
    public float GrassFadeBeginDistance;
    public float GrassFadeEndDistance;
    public int PerformanceFlag;
    public String AnotherMapName;
    public boolean Unknown;
}
