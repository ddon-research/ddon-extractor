package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Color;

import java.math.BigInteger;
import java.util.List;

public record StageCustomPartsExInfoEx(
        String Model,
        String ScrSbc1,
        String EffSbc1,
        String ScrSbc2,
        String EffSbc2,
        String ScrSbc3,
        String EffSbc3,
        String Light,
        String NaviMesh,
        String Epv,
        String Occluder,

        int AreaNo,
        int Type,
        long Size,
        float OffsetZ,
        int EpvIndexAlways,
        int EpvIndexDay,
        int EpvIndexNight,
        Color Color,

        BigInteger EfcColorZone,
        BigInteger EfcCtrlZone,
        BigInteger IndoorZoneScr,
        BigInteger IndoorZoneEfc,
        BigInteger LightAndFogZone,
        BigInteger SoundAreaInfo,
        List<BigInteger> ZoneUnitCtrl,
        BigInteger ZoneStatus,

        String Comment,

        long AddVersion,
        List<StageCustomPartsExAreaParam> AreaParamList
) {
    public StageCustomPartsExInfoEx(String model, String scrSbc1, String effSbc1, String scrSbc2, String effSbc2, String scrSbc3, String effSbc3, String light, String naviMesh, String epv, String occluder, int areaNo, int type, long size, float offsetZ, int epvIndexAlways, int epvIndexDay, int epvIndexNight, org.sehkah.ddon.tools.extractor.lib.common.datatype.Color color, BigInteger efcColorZone, BigInteger efcCtrlZone, BigInteger indoorZoneScr, BigInteger indoorZoneEfc, BigInteger lightAndFogZone, BigInteger soundAreaInfo, List<BigInteger> zoneUnitCtrl, BigInteger zoneStatus, String comment, List<StageCustomPartsExAreaParam> areaParamList) {
        this(model, scrSbc1, effSbc1, scrSbc2, effSbc2, scrSbc3, effSbc3, light, naviMesh, epv, occluder, areaNo, type, size, offsetZ, epvIndexAlways, epvIndexDay, epvIndexNight, color, efcColorZone, efcCtrlZone, indoorZoneScr, indoorZoneEfc, lightAndFogZone, soundAreaInfo, zoneUnitCtrl, zoneStatus, comment, areaParamList.size(), areaParamList);
    }
}
