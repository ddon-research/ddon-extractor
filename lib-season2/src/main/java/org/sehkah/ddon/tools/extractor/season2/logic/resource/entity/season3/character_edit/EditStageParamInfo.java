package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.character_edit;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.math.BigInteger;
import java.util.List;

public record EditStageParamInfo(
        String ModelSdl,
        String FilterSdl,
        String LightSdl,
        String OmListSdl,
        long Reverb,
        Vector3f plPos,
        float PlRotY,
        String WeatherStageInfo,
        String WeatherParamInfo,
        List<EditStageParamInfoWeatherData> WeatherData,
        BigInteger ResPathExSkyWep,
        BigInteger ResPathExRoomWep,
        BigInteger ResPathExEpv,
        int EpvIndexAlways,
        int EpvIndexDay,
        int EpvIndexNight,
        long Flag
) {

}
