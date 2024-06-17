package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.StageResourcePointer;

import java.util.List;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageInfo extends Resource {
    private StageResourcePointer SchedulerModel;
    private StageResourcePointer SchedulerFilter;
    private StageResourcePointer CollisionScrSbc0;
    private StageResourcePointer CollisionEffSbc0;
    private StageResourcePointer CollisionScrSbc1;
    private StageResourcePointer CollisionEffSbc1;
    private StageResourcePointer CollisionScrSbc2;
    private StageResourcePointer CollisionEffSbc2;
    private StageResourcePointer NavigationMeshNaviMesh;
    private StageResourcePointer OccluderExOCC;
    private StageResourcePointer StartPosStartPos;
    private StageResourcePointer CameraParamListEvt;
    private Vector3f Pos;
    private float Ang;
    private long SceLoadFlag;
    private long Flag;
    private StageResourcePointer WeatherStageInfo;
    private StageResourcePointer WeatherParamInfoTbl;
    private StageResourcePointer WeatherParamEfcInfo;
    private StageResourcePointer WeatherEffectParam;
    private StageResourcePointer SchedulerStageLightSchdl;
    private StageResourcePointer EffectProvider;
    private int EpvIndexAlways;
    private int EpvIndexDay;
    private int EpvIndexNight;
    private List<StageResourcePointer> ZoneList;//4
    private StageResourcePointer ZoneIndoorScr;
    private StageResourcePointer ZoneIndoorEfc;
    private float DayNightLightChgFrame;
    private float DayNightFogChgFrame;
    private int SkyInfiniteLightGroup;
    private List<StageResourcePointer> ZoneUnitCtrl;//3
    private StageResourcePointer ZoneStatus;
    private List<StageResourcePointer> SoundZone; //3
    private List<Float> EqLength; //4
    private StageResourcePointer SoundAreaInfo;
    private StageResourcePointer SchedulerEffectSchdl;
    private StageResourcePointer SchedulerLanternSchdl;
    private boolean IsCraftStage;
    private StageResourcePointer LocationData;
    private float GrassVisiblePercentMulValue;
    private float GrassFadeBeginDistance;
    private float GrassFadeEndDistance;
    private int PerformanceFlag;
    private String AnotherMapName;
    private boolean Unknown;
}
