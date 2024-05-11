package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Color;

import java.math.BigInteger;
import java.util.List;

public record StageCustomPartsInfo(
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
        List<BigInteger> ZoneUnitCtrl, //[3],
        BigInteger ZoneStatus,

        String Comment
) {
}
