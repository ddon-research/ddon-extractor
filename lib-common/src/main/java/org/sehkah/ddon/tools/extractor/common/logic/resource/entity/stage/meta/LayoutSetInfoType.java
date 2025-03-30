package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum LayoutSetInfoType {
    SetInfoOm(0), // Mostly contained in files with file name prefix "s"
    SetInfoEnemy(1), // Mostly contained in files with file name prefix "e"
    SetInfoNpc(2), // Mostly contained in files with file name prefix "n"
    SetInfoGeneralPoint(3), // Mostly contained in files with file name prefix "t"
    SetInfoOmGather(4), // Mostly contained in files with file name prefix "p"
    SetInfoOmLadder(5),
    SetInfoOmWarp(6), // Mostly contained in files with file name prefix "p"
    SetInfoOmTreasureBox(7),
    SetInfoOmBoard(8),
    SetInfoOmCtrl(9),
    SetInfoOmElfSW(10),
    SetInfoOmFall(11),
    SetInfoOmLever(12),
    SetInfoOmRange(13),
    SetInfoOmText(14),
    SetInfoOmWall(15),
    SetInfoOmHakuryuu(16),
    SetInfoOmDoor(17),
    SetInfoOmBowlOfLife(18),
    SetInfoOmNav(19),
    SetInfoOmHeal(20),
    SetInfoOmBadStatus(21),
    SetInfoOmBlock(22),
    SetInfoOmEx(23),
    SetInfoOmOldDoor(24),
    SetInfoOmOneWay(25),
    SetInfoOmBreakTarget(26),
    SetInfoOmCannon(27),
    SetInfoOmXXX(28),
    SetInfoOmLimitWarp(29),
    SetInfoOmActText(30),
    SetInfoOmPLJump(31),
    SetInfoOmPlCannon(32),
    SetInfoOmBreakRecovery(33),
    SetInfoOmBreakHeal(34),
    // 35 - 39 unused
    SetInfoOmOld(40),
    // 41 unused
    SetInfoOmTreasureBoxG(42), // Mostly contained in files with file name prefix "p"
    SetInfoOmRimWarp(43),
    SetInfoOmMagmaSpring(45),
    SetInfoOmFlagMapMarker(46),
    SetInfoOm511380(47),
    SetInfoOmGauge(48),
    SetInfoOmHugeRimShl(49),
    SetInfoOmRisingMagma(50),
    SetInfoOmMagmaFall(51),
    SetInfoOmRisingMagma2(52),
    SetInfoOmGrpID(53),
    SetInfoOmWarpFX(54),
    SetInfoOmVolcano(55),
    SetInfoEnemyLinked(200);

    public long value;

    LayoutSetInfoType(long value) {
        this.value = value;
    }

    public static LayoutSetInfoType of(long value) {
        return Arrays.stream(LayoutSetInfoType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
