package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class WeatherCloudModel {
    private StageResourcePointer Model;
    private long ColorType;
    private float SunColorScale;
    private float SaturationScale;
    private float IntensityScale;
    private float FogMulRate;
    private float FogAddRate;
    private long ViewType;
}
