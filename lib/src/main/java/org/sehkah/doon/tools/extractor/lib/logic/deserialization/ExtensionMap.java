package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.EM.RageTableDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.base.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea.FieldAreaAdjoinListDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea.FieldAreaMarkerInfoDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.AchievementDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.StageMapDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.StartPosAreaDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.WarpLocationDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.preset.equip.EquipPresetDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.sg300000.ShopGoodsDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.stage.LocationDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.history.QuestHistoryDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIArisenCard.AchievementHeaderDeserializer;

import java.util.Arrays;
import java.util.List;

public enum ExtensionMap {
    rAdjustParam("ajp", null, 256, JobAdjustParamDeserializer.class),
    rAreaInfo("ari", "ARI\0", 2, AreaInfoDeserializer.class),
    rAreaInfoStage("ars", "ARS\0", 2, AreaInfoStageDeserializer.class),
    rEnemyGroup("emg", null, 1, EnemyGroupDeserializer.class),
    rEventParam("evp", null, 19, EventParamDeserializer.class),
    rFieldAreaAdjoinList("faa", "FAA\0", 2, FieldAreaAdjoinListDeserializer.class),
    rFieldAreaList("fal", "FAl\0", 2, FieldAreaListDeserializer.class),
    rFieldAreaMarkerInfo("fmi", "FMI\0", 1, FieldAreaMarkerInfoDeserializer.class),
    rGUIMessage("gmd", "GMD\0", 66306, GUIMessageDeserializer.class),
    rJobBaseParam("jobbase", null, 263, JobBaseParamDeserializer.class),
    rJobLevelUpTbl2("jlt2", null, 1, JobLevelUpTableDeserializer.class),
    rJobTutorialQuestList("jtq", "JTQ\0", 1, JobTutorialQuestListDeserializer.class),
    rLandInfo("lai", "LAI\0", 4, LandInfoDeserializer.class),
    rLocationData("lcd", "lcd\0", 16, LocationDataDeserializer.class),
    rQuestSequenceList("qsq", null, 256, QuestSequenceListDeserializer.class),
    rStageList("slt", "slt\0", 34, StageListDeserializer.class),
    rStageMap("smp", null, 1, StageMapDeserializer.class),
    rStageToSpot("sts", null, 0, StageToSpotDeserializer.class),
    rStatusGainTable("sg_tbl", null, 257, StatusGainTableDeserializer.class),
    rTutorialQuestGroup("tqg", "TQG\0", 1, TutorialQuestGroupDeserializer.class),
    rWarpLocation("wal", null, 353, WarpLocationDeserializer.class),
    rGatheringItem("gat", null, 1, GatheringItemDeserializer.class),
    rShopGoods("spg_tbl", "TBL\0", 259, ShopGoodsDeserializer.class),
    rQuestHistoryData("qhd", null, 1, QuestHistoryDataDeserializer.class),
    rPlayerExpTable("exp", null, 2, PlayerExpTableDeserializer.class),
    rCraftUpGradeExp("cuex", null, 1, CraftUpGradeExpDeserializer.class),
    rCraftElementExp("cee", null, 1, CraftElementExpDeserializer.class),
    rCraftSkillSpd("cks", null, 3, CraftSkillSpeedDeserializer.class),
    rCraftSkillCost("ckc", null, 2, CraftSkillCostDeserializer.class),
    rCraftCapPass("ccp", null, 2, CraftCapPassDeserializer.class),
    rCraftQuality("cqr", null, 1, CraftQualityDeserializer.class),
    rAchievement("acv", null, 2, AchievementDeserializer.class),
    rAchievementHeader("ach", null, 3, AchievementHeaderDeserializer.class),
    rJobMasterCtrl("jmc", null, 256, JobMasterCtrlDeserializer.class),
    rHumanEnemyCustomSkill("hmcs", null, 3, HumanEnemyCustomSkillDeserializer.class),
    rEquipPreset("equip_preset", null, 7, EquipPresetDeserializer.class),
    rRageTable("rag", null, 257, RageTableDeserializer.class),
    rStartPosArea("sta", null, 0, StartPosAreaDeserializer.class),
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
        return "{\n\"fileExtension\": \"" + fileExtension + "\",\n"
                + (magic != null ? "\"magic\": \"" + magic + "\",\n" : "")
                + "\"version\": " + version + "\n}";
    }
}
