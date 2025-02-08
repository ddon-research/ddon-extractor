package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class WeatherParamInfo {
    private WeatherParam WeatherParameter;
    private int WeatherID;
    private float WeatherSoundVolume;
    private float WeatherStarIntensity;
    private float LightMainIntensityScale;
    private float LightMainSatuationScale;
    private Vector3f LightSubDayColor;
    private Vector3f LightHemiDayColor;
    private Vector3f LightHemiDayRevColor;
    private StageResourcePointer FogParam;
    private StageResourcePointer SoundReq;
    private List<WeatherCloudModel> Clouds;
}
