package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.character_edit;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EditStageParamInfoWeatherData {
    private long WeatherID;
    private long Hour;
    private long Minute;
}
