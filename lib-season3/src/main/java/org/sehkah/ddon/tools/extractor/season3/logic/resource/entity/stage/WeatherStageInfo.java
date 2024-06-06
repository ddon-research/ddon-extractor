package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class WeatherStageInfo extends TopLevelClientResource {
    private StageResourcePointer SkyRes;
    private StageResourcePointer RefSkyRes;
    private StageResourcePointer ModelScheduler;
    private StageResourcePointer StarModel;
    private StageResourcePointer StarTex;
    private StageResourcePointer StarCatalog;
    private float StarSize;
    private float StarrySkyIntensity;
    private float StarTwinkleAmplitude;
    private List<Vector3f> EnvMapBaseColor;//2
    private List<Float> EnvMapBlendColorScale;//2
}
