package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.EM.RageTableDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.MyRoom.AnimalDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.base.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.clankyoten.FurnitureLayoutDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.clankyoten.MsgSetDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea.FieldAreaAdjoinListDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea.FieldAreaMarkerInfoDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.preset.equip.EquipPresetDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.quest.QuestMarkerInfoDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.quest.QuestTextDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.scr.MapSpotDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.sg300000.ShopGoodsDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.skill.CustomSkillDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.skill.NormalSkillDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.stage.LocationDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.stage.Tbl2ChatMacroDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.tutorial_guide.TutorialDialogMessageDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.tutorial_guide.TutorialListDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.history.QuestHistoryDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster.AreaMasterRankDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster.AreaMasterSpotDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster.AreaMasterSpotDetailDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIArisenCard.AchievementHeaderDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUISkill.AbilityAddDataDeserializer;

import java.util.Arrays;
import java.util.List;

public enum ClientResourceFile {
    rAbilityAddData("aad", new FileHeader(1, 4), AbilityAddDataDeserializer.class),
    rAbilityData("abd", new FileHeader(3, 4), AbilityDataDeserializer.class),
    rAbilityList("abl", new FileHeader("abl0", 9, 4), AbilityListDeserializer.class),
    rAchievement("acv", new FileHeader(2, 4), AchievementDeserializer.class),
    rAchievementHeader("ach", new FileHeader(3, 4), AchievementHeaderDeserializer.class),
    rAdjustParam("ajp", new FileHeader(256, 4), JobAdjustParamDeserializer.class),
    rAreaInfo("ari", new FileHeader("ARI\0", 2, 4), AreaInfoDeserializer.class),
    rAreaInfoJointArea("arj", new FileHeader("ARJ\0", 2, 4), AreaInfoJointAreaDeserializer.class),
    rAreaInfoStage("ars", new FileHeader("ARS\0", 2, 4), AreaInfoStageDeserializer.class),
    rAreaMasterRankData("amr", new FileHeader(4, 4), AreaMasterRankDataDeserializer.class),
    rAreaMasterSpotData("ams", new FileHeader(8, 4), AreaMasterSpotDataDeserializer.class),
    rAreaMasterSpotDetailData("amsd", new FileHeader(5, 4), AreaMasterSpotDetailDataDeserializer.class),
    rCraftCapPass("ccp", new FileHeader(2, 4), CraftCapPassDeserializer.class),
    rCraftElementExp("cee", new FileHeader(1, 4), CraftElementExpDeserializer.class),
    rCraftQuality("cqr", new FileHeader(1, 4), CraftQualityDeserializer.class),
    rCraftSkillCost("ckc", new FileHeader(2, 4), CraftSkillCostDeserializer.class),
    rCraftSkillSpd("cks", new FileHeader(3, 4), CraftSkillSpeedDeserializer.class),
    rCraftUpGradeExp("cuex", new FileHeader(1, 4), CraftUpGradeExpDeserializer.class),
    rCustomSkillData("csd", new FileHeader(3, 4), CustomSkillDataDeserializer.class),
    rCycleQuestInfo("cqi", new FileHeader("CQI\0", 2, 4), CycleQuestInfoDeserializer.class),
    rEnemyGroup("emg", new FileHeader(1, 4), EnemyGroupDeserializer.class),
    rEquipPreset("equip_preset", new FileHeader(7, 4), EquipPresetDeserializer.class),
    rEventParam("evp", new FileHeader(19, 4), EventParamDeserializer.class),
    rFieldAreaAdjoinList("faa", new FileHeader("FAA\0", 2, 4), FieldAreaAdjoinListDeserializer.class),
    rFieldAreaList("fal", new FileHeader("FAl\0", 2, 4), FieldAreaListDeserializer.class),
    rFieldAreaMarkerInfo("fmi", new FileHeader("FMI\0", 1, 4), FieldAreaMarkerInfoDeserializer.class),
    rFieldMapData("fmd", new FileHeader("fmd\0", 18, 4), FieldMapDataDeserializer.class),
    rGUIMessage("gmd", new FileHeader("GMD\0", 66306, 4), GUIMessageDeserializer.class),
    rGatheringItem("gat", new FileHeader(1, 4), GatheringItemDeserializer.class),
    rHumanEnemyCustomSkill("hmcs", new FileHeader(3, 4), HumanEnemyCustomSkillDeserializer.class),
    rJobBaseParam("jobbase", new FileHeader(263, 4), JobBaseParamDeserializer.class),
    rJobLevelUpTbl2("jlt2", new FileHeader(1, 4), JobLevelUpTableDeserializer.class),
    rJobMasterCtrl("jmc", new FileHeader(256, 4), JobMasterCtrlDeserializer.class),
    rJobTutorialQuestList("jtq", new FileHeader("JTQ\0", 1, 2), JobTutorialQuestListDeserializer.class),
    rLandInfo("lai", new FileHeader("LAI\0", 4, 4), LandInfoDeserializer.class),
    rLayoutPreset("lop", new FileHeader(5, 4), LayoutPresetDeserializer.class),
    rLocationData("lcd", new FileHeader("lcd\0", 16, 4), LocationDataDeserializer.class),
    rMapSpotData("msd", new FileHeader("msd\0", 0, 4), MapSpotDataDeserializer.class),
    rMapSpotStageList("msl", new FileHeader("msl\0", 0, 4), MapSpotStageListDeserializer.class),
    rMsgSet("mss", new FileHeader("mgst", 3, 2), MsgSetDeserializer.class),
    rNormalSkillData("nsd", new FileHeader(5, 4), NormalSkillDataDeserializer.class),
    rPlayerExpTable("exp", new FileHeader(2, 4), PlayerExpTableDeserializer.class),
    rQuestHistoryData("qhd", new FileHeader(1, 4), QuestHistoryDataDeserializer.class),
    rQuestMarkerInfo("qmi", new FileHeader("QMI\0", 1, 4), QuestMarkerInfoDeserializer.class),
    rQuestSequenceList("qsq", new FileHeader(256, 4), QuestSequenceListDeserializer.class),
    rQuestTextData("qtd", new FileHeader("QTD\0", 2, 4), QuestTextDataDeserializer.class),
    rRageTable("rag", new FileHeader(257, 4), RageTableDeserializer.class),
    rShopGoods("spg_tbl", new FileHeader("TBL\0", 259, 4), ShopGoodsDeserializer.class),
    rStageList("slt", new FileHeader("slt\0", 34, 4), StageListDeserializer.class),
    rStageMap("smp", new FileHeader(1, 4), StageMapDeserializer.class),
    rStageToSpot("sts", new FileHeader(0, 4), StageToSpotDeserializer.class),
    rStartPosArea("sta", new FileHeader(0, 4), StartPosAreaDeserializer.class),
    rStatusGainTable("sg_tbl", new FileHeader(257, 4), StatusGainTableDeserializer.class),
    rTutorialDialogMessage("tdm", new FileHeader("TDM\0", 2, 4), TutorialDialogMessageDeserializer.class),
    rTutorialList("tlt", new FileHeader("TLT\0", 6, 4), TutorialListDeserializer.class),
    rTutorialQuestGroup("tqg", new FileHeader("TQG\0", 1, 2), TutorialQuestGroupDeserializer.class),
    rWarpLocation("wal", new FileHeader(353, 4), WarpLocationDeserializer.class),
    rTbl2ChatMacro("tcm", new FileHeader(256, 4), Tbl2ChatMacroDeserializer.class),
    rAnimalData("aml", new FileHeader(0, 4), AnimalDataDeserializer.class),
    rFurnitureLayout("fnl", new FileHeader(1, 4), FurnitureLayoutDeserializer.class);

    public final String fileExtension;
    public final FileHeader fileHeader;
    public final Class<? extends Deserializer> deserializer;

    ClientResourceFile(String fileExtension, FileHeader fileHeader, Class<? extends Deserializer> deserializer) {
        this.fileExtension = fileExtension;
        this.fileHeader = fileHeader;
        this.deserializer = deserializer;
    }

    public static ClientResourceFile findByFileExtension(String filePath) {
        for (ClientResourceFile value : ClientResourceFile.values()) {
            if (filePath.endsWith(value.fileExtension)) {
                return value;
            }
        }
        return null;
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
