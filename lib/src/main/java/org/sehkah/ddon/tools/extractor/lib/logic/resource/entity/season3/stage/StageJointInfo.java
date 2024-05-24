package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Color;

import java.math.BigInteger;
import java.util.List;

public record StageJointInfo(
        String Model,
        // TODO calculate pathCRC for all of these
        String ScrSbc0,
        String EffSbc0,
        String ScrSbc1,
        String EffSbc1,
        String ScrSbc2,
        String EffSbc2,
        String Light,
        String NaviMesh,
        String PlantTree,
        String SndInfo,
        List<Byte> Joint,
        Color Color,
        String Epv,
        int EpvIndexAlways,
        int EpvIndexDay,
        int EpvIndexNight,
        // TODO extract metainfo out of these resource IDs
        BigInteger EfcColorZoneResId,
        BigInteger EfcCtrlZoneResId,
        BigInteger IndoorZoneScrResId,
        BigInteger IndoorZoneEfcResId,
        BigInteger LightAndFogZoneResId,
        List<BigInteger> ZoneUnitCtrlResId,
        BigInteger ZoneStatusResId,
        String Comment
) {
}
