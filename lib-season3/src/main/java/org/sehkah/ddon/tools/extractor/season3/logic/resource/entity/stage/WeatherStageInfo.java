package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

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
public final class WeatherStageInfo extends TopLevelClientResource {
    private final StageResourcePointer SkyRes;
    private final StageResourcePointer RefSkyRes;
    private final StageResourcePointer ModelScheduler;
    private final StageResourcePointer StarModel;
    private final StageResourcePointer StarTex;
    private final StageResourcePointer StarCatalog;
    private final float StarSize;
    private final float StarrySkyIntensity;
    private final float StarTwinkleAmplitude;
    private final List<Vector3f> EnvMapBaseColor;//2
    private final List<Float> EnvMapBlendColorScale;//2
}
