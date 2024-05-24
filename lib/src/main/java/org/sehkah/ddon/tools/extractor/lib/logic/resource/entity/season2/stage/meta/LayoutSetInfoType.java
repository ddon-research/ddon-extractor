package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.meta;


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
    SetInfoOmBreakTarget(26);

    public final long value;

    LayoutSetInfoType(long value) {
        this.value = value;
    }

    public static LayoutSetInfoType of(long value) {
        return Arrays.stream(LayoutSetInfoType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
