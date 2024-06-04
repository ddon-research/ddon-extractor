package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.character_edit;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.math.BigInteger;
import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EditStageParamInfo {
    private String ModelSdl;
    private String FilterSdl;
    private String LightSdl;
    private String OmListSdl;
    private long Reverb;
    private Vector3f plPos;
    private float PlRotY;
    private String WeatherStageInfo;
    private String WeatherParamInfo;
    private List<EditStageParamInfoWeatherData> WeatherData;
    private BigInteger ResPathExSkyWep;
    private BigInteger ResPathExRoomWep;
    private BigInteger ResPathExEpv;
    private int EpvIndexAlways;
    private int EpvIndexDay;
    private int EpvIndexNight;
    private long Flag;
}
