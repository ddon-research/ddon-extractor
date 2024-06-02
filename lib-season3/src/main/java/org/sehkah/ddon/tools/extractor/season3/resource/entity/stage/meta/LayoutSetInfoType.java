package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.meta;


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
    SetInfoOmUnknown27(27),
    SetInfoOmUnknown28(28),
    SetInfoOmWarpNew(29),
    SetInfoOmUnknown30(30),
    SetInfoOmUnknown31(31),
    SetInfoOmUnknown32(32),
    SetInfoOmUnknown33(33),
    SetInfoOmUnknown34(34),
    // 35 - 39 unused
    SetInfoOmOld(40),
    // 41 unused
    SetInfoOmUnknown42(42),
    SetInfoOmWarpNewV3(43),
    SetInfoOmUnknown45(45),
    SetInfoOmUnknown46(46),
    SetInfoOmUnknown47(47),
    SetInfoOmUnknown48(48),
    SetInfoOmUnknown49(49),
    SetInfoOmUnknown50(50),
    SetInfoOmUnknown51(51),
    SetInfoOmUnknown52(52),
    SetInfoOmUnknown53(53),
    SetInfoOmWarpNewV2(54),
    SetInfoOmUnknown55(55),
    SetInfoEnemyV2(200);

    public final long value;

    LayoutSetInfoType(long value) {
        this.value = value;
    }

    public static LayoutSetInfoType of(long value) {
        return Arrays.stream(LayoutSetInfoType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
