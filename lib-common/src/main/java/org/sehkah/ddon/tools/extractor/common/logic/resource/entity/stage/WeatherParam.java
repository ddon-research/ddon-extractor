package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class WeatherParam {
    private Vector3f SunColor;
    private Vector3f MieScattering;
    private float MieDensity;
    private float CloudHeight;
    private float Cloudiness;
    private float CloudThickness;
    private float CloudScattering;
    private float CloudEccentricity;
    private float MoonLRate;
    private float SunIntensityRate;
    private float EnvMapBaseScale;
    private float FogDensity;
}
