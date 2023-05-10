package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import java.util.Arrays;
import java.util.List;

public enum ClientResourceFile {
    rAbilityAddData(".aad", new FileHeader(1, 4)),
    rAbilityData(".abd", new FileHeader(3, 4)),
    rAbilityList(".abl", new FileHeader("abl0", 9, 4)),
    rAchievement(".acv", new FileHeader(2, 4)),
    rAchievementHeader(".ach", new FileHeader(3, 4)),
    rAdjustParam(".ajp", new FileHeader(256, 4)),
    rAnimalData(".aml", new FileHeader(0, 4)),
    rAreaInfo(".ari", new FileHeader("ARI\0", 2, 4)),
    rAreaInfoJointArea(".arj", new FileHeader("ARJ\0", 2, 4)),
    rAreaInfoStage(".ars", new FileHeader("ARS\0", 2, 4)),
    rAreaMasterRankData(".amr", new FileHeader(4, 4)),
    rAreaMasterSpotData(".ams", new FileHeader(8, 4)),
    rAreaMasterSpotDetailData(".amsd", new FileHeader(5, 4)),
    rCraftCapPass(".ccp", new FileHeader(2, 4)),
    rCraftElementExp(".cee", new FileHeader(1, 4)),
    rCraftQuality(".cqr", new FileHeader(1, 4)),
    rCraftSkillCost(".ckc", new FileHeader(2, 4)),
    rCraftSkillSpd(".cks", new FileHeader(3, 4)),
    rCraftUpGradeExp(".cuex", new FileHeader(1, 4)),
    rCustomSkillData(".csd", new FileHeader(3, 4)),
    rCycleQuestInfo(".cqi", new FileHeader("CQI\0", 2, 4)),
    rEmBaseInfoSv(".ebi_sv", new FileHeader(21, 4)),
    rEmDamageDirInfo(".edv", new FileHeader(2, 4)),
    rEnemyGroup(".emg", new FileHeader(1, 4)),
    rEquipPreset(".equip_preset", new FileHeader(7, 4)),
    rEvaluationTable(".evl", new FileHeader(4, 4)),
    rEventParam(".evp", new FileHeader(19, 4)),
    rFieldAreaAdjoinList(".faa", new FileHeader("FAA\0", 2, 4)),
    rFieldAreaList(".fal", new FileHeader("FAl\0", 2, 4)),
    rFieldAreaMarkerInfo(".fmi", new FileHeader("FMI\0", 1, 4)),
    rFieldMapData(".fmd", new FileHeader("fmd\0", 18, 4)),
    rFurnitureData(".fnd", new FileHeader(5, 4)),
    rFurnitureGroup(".fng", new FileHeader(1, 4)),
    rFurnitureItem(".fni", new FileHeader(1, 4)),
    rFurnitureLayout(".fnl", new FileHeader(1, 4)),
    rGUIDogmaOrb(".dgm", new FileHeader(1, 4)),
    rGUIMessage(".gmd", new FileHeader("GMD\0", 66306, 4)),
    rGatheringItem(".gat", new FileHeader(1, 4)),
    rHumanEnemyCustomSkill(".hmcs", new FileHeader(3, 4)),
    rJobBaseParam(".jobbase", new FileHeader(263, 4)),
    rJobLevelUpTbl2(".jlt2", new FileHeader(1, 4)),
    rJobMasterCtrl(".jmc", new FileHeader(256, 4)),
    rJobTutorialQuestList(".jtq", new FileHeader("JTQ\0", 1, 2)),
    rLandInfo(".lai", new FileHeader("LAI\0", 4, 4)),
    rLayoutPreset(".lop", new FileHeader(5, 4)),
    rLocationData(".lcd", new FileHeader("lcd\0", 16, 4)),
    rMapSpotData(".msd", new FileHeader("msd\0", 0, 4)),
    rMapSpotStageList(".msl", new FileHeader("msl\0", 0, 4)),
    rMsgSet(".mss", new FileHeader("mgst", 3, 2)),
    rNormalSkillData(".nsd", new FileHeader(5, 4)),
    rNpcConstItem(".nci", new FileHeader(2, 4)),
    rNpcMeetingPlace(".nmp", new FileHeader(0, 4)),
    rPlayerExpTable(".exp", new FileHeader(2, 4)),
    rQuestHistoryData(".qhd", new FileHeader(1, 4)),
    rQuestMarkerInfo(".qmi", new FileHeader("QMI\0", 1, 4)),
    rQuestSequenceList(".qsq", new FileHeader(256, 4)),
    rQuestTextData(".qtd", new FileHeader("QTD\0", 2, 4)),
    rRageTable(".rag", new FileHeader(257, 4)),
    rShopGoods(".spg_tbl", new FileHeader("TBL\0", 259, 4)),
    rSituationMsgCtrl(".smc", new FileHeader("SMC\0", 3, 4)),
    rStageList(".slt", new FileHeader("slt\0", 34, 4)),
    rStageMap(".smp", new FileHeader(1, 4)),
    rStageToSpot(".sts", new FileHeader(0, 4)),
    rStartPosArea(".sta", new FileHeader(0, 4)),
    rStatusGainTable(".sg_tbl", new FileHeader(257, 4)),
    rTbl2ChatMacro(".tcm", new FileHeader(256, 4)),
    rTutorialDialogMessage(".tdm", new FileHeader("TDM\0", 2, 4)),
    rTutorialList(".tlt", new FileHeader("TLT\0", 6, 4)),
    rTutorialQuestGroup(".tqg", new FileHeader("TQG\0", 1, 2)),
    rWarpLocation(".wal", new FileHeader(353, 4));

    public final String fileExtension;
    public final FileHeader fileHeader;

    ClientResourceFile(String fileExtension, FileHeader fileHeader) {
        this.fileExtension = fileExtension;
        this.fileHeader = fileHeader;
    }

    public static ClientResourceFile findByFileExtension(String fileExtension) {
        return Arrays.stream(ClientResourceFile.values()).filter(value -> fileExtension.equals(value.fileExtension)).findFirst().orElse(null);
    }

    public static List<String> getSupportedFileExtensions() {
        return Arrays.stream(ClientResourceFile.values()).map(extensionMap -> extensionMap.fileExtension).toList();
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"#\": " + ordinal() + ",\n"
                + "\"fileExtension\": \"" + fileExtension + "\",\n"
                + (fileHeader.magicString != null ? "\"magic\": \"" + fileHeader.magicString + "\",\n" : "")
                + "\"version\": " + fileHeader.versionNumber
                + "\n}";
    }
}
