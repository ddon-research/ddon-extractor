package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.EM.RageTableDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.base.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea.FieldAreaAdjoinListDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea.FieldAreaMarkerInfoDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.preset.equip.EquipPresetDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.sg300000.ShopGoodsDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.skill.CustomSkillDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.skill.NormalSkillDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.stage.LocationDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.history.QuestHistoryDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster.AreaMasterRankDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster.AreaMasterSpotDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster.AreaMasterSpotDetailDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIArisenCard.AchievementHeaderDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUISkill.AbilityAddDataDeserializer;

import java.util.Arrays;
import java.util.List;

public enum ExtensionMap {
    rAbilityAddData("aad", null, 1, AbilityAddDataDeserializer.class),
    rAbilityData("abd", null, 3, AbilityDataDeserializer.class),
    rAchievement("acv", null, 2, AchievementDeserializer.class),
    rAchievementHeader("ach", null, 3, AchievementHeaderDeserializer.class),
    rAdjustParam("ajp", null, 256, JobAdjustParamDeserializer.class),
    rAreaInfo("ari", "ARI\0", 2, AreaInfoDeserializer.class),
    rAreaInfoStage("ars", "ARS\0", 2, AreaInfoStageDeserializer.class),
    rCraftCapPass("ccp", null, 2, CraftCapPassDeserializer.class),
    rCraftElementExp("cee", null, 1, CraftElementExpDeserializer.class),
    rCraftQuality("cqr", null, 1, CraftQualityDeserializer.class),
    rCraftSkillCost("ckc", null, 2, CraftSkillCostDeserializer.class),
    rCraftSkillSpd("cks", null, 3, CraftSkillSpeedDeserializer.class),
    rCraftUpGradeExp("cuex", null, 1, CraftUpGradeExpDeserializer.class),
    rCustomSkillData("csd", null, 3, CustomSkillDataDeserializer.class),
    rEnemyGroup("emg", null, 1, EnemyGroupDeserializer.class),
    rEquipPreset("equip_preset", null, 7, EquipPresetDeserializer.class),
    rEventParam("evp", null, 19, EventParamDeserializer.class),
    rFieldAreaAdjoinList("faa", "FAA\0", 2, FieldAreaAdjoinListDeserializer.class),
    rFieldAreaList("fal", "FAl\0", 2, FieldAreaListDeserializer.class),
    rFieldAreaMarkerInfo("fmi", "FMI\0", 1, FieldAreaMarkerInfoDeserializer.class),
    rGUIMessage("gmd", "GMD\0", 66306, GUIMessageDeserializer.class),
    rGatheringItem("gat", null, 1, GatheringItemDeserializer.class),
    rHumanEnemyCustomSkill("hmcs", null, 3, HumanEnemyCustomSkillDeserializer.class),
    rJobBaseParam("jobbase", null, 263, JobBaseParamDeserializer.class),
    rJobLevelUpTbl2("jlt2", null, 1, JobLevelUpTableDeserializer.class),
    rJobMasterCtrl("jmc", null, 256, JobMasterCtrlDeserializer.class),
    rJobTutorialQuestList("jtq", "JTQ\0", 1, JobTutorialQuestListDeserializer.class),
    rLandInfo("lai", "LAI\0", 4, LandInfoDeserializer.class),
    rLocationData("lcd", "lcd\0", 16, LocationDataDeserializer.class),
    rNormalSkillData("nsd", null, 5, NormalSkillDataDeserializer.class),
    rPlayerExpTable("exp", null, 2, PlayerExpTableDeserializer.class),
    rQuestHistoryData("qhd", null, 1, QuestHistoryDataDeserializer.class),
    rQuestSequenceList("qsq", null, 256, QuestSequenceListDeserializer.class),
    rRageTable("rag", null, 257, RageTableDeserializer.class),
    rShopGoods("spg_tbl", "TBL\0", 259, ShopGoodsDeserializer.class),
    rStageList("slt", "slt\0", 34, StageListDeserializer.class),
    rStageMap("smp", null, 1, StageMapDeserializer.class),
    rStageToSpot("sts", null, 0, StageToSpotDeserializer.class),
    rStartPosArea("sta", null, 0, StartPosAreaDeserializer.class),
    rStatusGainTable("sg_tbl", null, 257, StatusGainTableDeserializer.class),
    rTutorialQuestGroup("tqg", "TQG\0", 1, TutorialQuestGroupDeserializer.class),
    rWarpLocation("wal", null, 353, WarpLocationDeserializer.class),
    rAreaMasterRankData("amr", null, 4, AreaMasterRankDataDeserializer.class),
    rAreaMasterSpotData("ams", null, 8, AreaMasterSpotDataDeserializer.class),
    rAreaMasterSpotDetailData("amsd", null, 5, AreaMasterSpotDetailDataDeserializer.class),
    rAbilityList("abl", "abl0", 9, AbilityListDeserializer.class),
    rLayoutPreset("lop", null, 5, LayoutPresetDeserializer.class),
    rFieldMapData("fmd", "fmd\0", 18, FieldMapDataDeserializer.class),
    rAreaInfoJointArea("arj", "ARJ\0", 2, AreaInfoJointAreaDeserializer.class),
    UNSUPPORTED("", null, 999, null);

    public final String fileExtension;
    public final String magic;
    public final long version;
    public final Class<? extends Deserializer> deserializer;

    ExtensionMap(String fileExtension, String magic, long version, Class<? extends Deserializer> deserializer) {
        this.fileExtension = fileExtension;
        this.magic = magic;
        this.version = version;
        this.deserializer = deserializer;
    }

    public static ExtensionMap findByFileExtension(String filePath) {
        for (ExtensionMap value : ExtensionMap.values()) {
            if (filePath.endsWith(value.fileExtension)) {
                return value;
            }
        }
        return UNSUPPORTED;
    }

    public static List<String> getSupportedFileExtensions() {
        return Arrays.stream(ExtensionMap.values()).filter(extensionMap -> !extensionMap.fileExtension.isBlank()).map(extensionMap -> extensionMap.fileExtension).toList();
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"#\": " + ordinal() + ",\n"
                + "\"fileExtension\": \"" + fileExtension + "\",\n"
                + (magic != null ? "\"magic\": \"" + magic + "\",\n" : "")
                + "\"version\": " + version
                + "\n}";
    }
}
