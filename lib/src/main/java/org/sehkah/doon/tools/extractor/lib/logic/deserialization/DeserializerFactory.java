package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.EM.RageTableDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.MyRoom.AnimalDataDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.base.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.clankyoten.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.em_common.EmBaseInfoSvDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.em_common.EmDamageDirInfoDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.em_common.EvaluationTableDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea.FieldAreaAdjoinListDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea.FieldAreaMarkerInfoDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.npc.SituationMsgCtrlDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.npc_common.NpcConstItemDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.npc_common.NpcMeetingPlaceDeserializer;
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
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIDogmaOrb.GUIDogmaOrbDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUISkill.AbilityAddDataDeserializer;

import java.util.HashMap;
import java.util.Map;


public class DeserializerFactory {
    private static final Map<String, Deserializer<?>> DESERIALIZER_MAP = new HashMap<>(64);

    static {
        DESERIALIZER_MAP.put(".aad", new AbilityAddDataDeserializer());
        DESERIALIZER_MAP.put(".abd", new AbilityDataDeserializer());
        DESERIALIZER_MAP.put(".abl", new AbilityListDeserializer());
        DESERIALIZER_MAP.put(".acv", new AchievementDeserializer());
        DESERIALIZER_MAP.put(".ach", new AchievementHeaderDeserializer());
        DESERIALIZER_MAP.put(".ajp", new JobAdjustParamDeserializer());
        DESERIALIZER_MAP.put(".ari", new AreaInfoDeserializer());
        DESERIALIZER_MAP.put(".arj", new AreaInfoJointAreaDeserializer());
        DESERIALIZER_MAP.put(".ars", new AreaInfoStageDeserializer());
        DESERIALIZER_MAP.put(".amr", new AreaMasterRankDataDeserializer());
        DESERIALIZER_MAP.put(".ams", new AreaMasterSpotDataDeserializer());
        DESERIALIZER_MAP.put(".amsd", new AreaMasterSpotDetailDataDeserializer());
        DESERIALIZER_MAP.put(".ccp", new CraftCapPassDeserializer());
        DESERIALIZER_MAP.put(".cee", new CraftElementExpDeserializer());
        DESERIALIZER_MAP.put(".cqr", new CraftQualityDeserializer());
        DESERIALIZER_MAP.put(".ckc", new CraftSkillCostDeserializer());
        DESERIALIZER_MAP.put(".cks", new CraftSkillSpeedDeserializer());
        DESERIALIZER_MAP.put(".cuex", new CraftUpGradeExpDeserializer());
        DESERIALIZER_MAP.put(".csd", new CustomSkillDataDeserializer());
        DESERIALIZER_MAP.put(".cqi", new CycleQuestInfoDeserializer());
        DESERIALIZER_MAP.put(".emg", new EnemyGroupDeserializer());
        DESERIALIZER_MAP.put(".equip_preset", new EquipPresetDeserializer());
        DESERIALIZER_MAP.put(".evp", new EventParamDeserializer());
        DESERIALIZER_MAP.put(".faa", new FieldAreaAdjoinListDeserializer());
        DESERIALIZER_MAP.put(".fal", new FieldAreaListDeserializer());
        DESERIALIZER_MAP.put(".fmi", new FieldAreaMarkerInfoDeserializer());
        DESERIALIZER_MAP.put(".fmd", new FieldMapDataDeserializer());
        DESERIALIZER_MAP.put(".gmd", new GUIMessageDeserializer());
        DESERIALIZER_MAP.put(".gat", new GatheringItemDeserializer());
        DESERIALIZER_MAP.put(".hmcs", new HumanEnemyCustomSkillDeserializer());
        DESERIALIZER_MAP.put(".jobbase", new JobBaseParamDeserializer());
        DESERIALIZER_MAP.put(".jlt2", new JobLevelUpTableDeserializer());
        DESERIALIZER_MAP.put(".jmc", new JobMasterCtrlDeserializer());
        DESERIALIZER_MAP.put(".jtq", new JobTutorialQuestListDeserializer());
        DESERIALIZER_MAP.put(".lai", new LandInfoDeserializer());
        DESERIALIZER_MAP.put(".lop", new LayoutPresetDeserializer());
        DESERIALIZER_MAP.put(".lcd", new LocationDataDeserializer());
        DESERIALIZER_MAP.put(".msd", new MapSpotDataDeserializer());
        DESERIALIZER_MAP.put(".msl", new MapSpotStageListDeserializer());
        DESERIALIZER_MAP.put(".mss", new MsgSetDeserializer());
        DESERIALIZER_MAP.put(".nsd", new NormalSkillDataDeserializer());
        DESERIALIZER_MAP.put(".exp", new PlayerExpTableDeserializer());
        DESERIALIZER_MAP.put(".qhd", new QuestHistoryDataDeserializer());
        DESERIALIZER_MAP.put(".qmi", new QuestMarkerInfoDeserializer());
        DESERIALIZER_MAP.put(".qsq", new QuestSequenceListDeserializer());
        DESERIALIZER_MAP.put(".qtd", new QuestTextDataDeserializer());
        DESERIALIZER_MAP.put(".rag", new RageTableDeserializer());
        DESERIALIZER_MAP.put(".spg_tbl", new ShopGoodsDeserializer());
        DESERIALIZER_MAP.put(".slt", new StageListDeserializer());
        DESERIALIZER_MAP.put(".smp", new StageMapDeserializer());
        DESERIALIZER_MAP.put(".sts", new StageToSpotDeserializer());
        DESERIALIZER_MAP.put(".sta", new StartPosAreaDeserializer());
        DESERIALIZER_MAP.put(".sg_tbl", new StatusGainTableDeserializer());
        DESERIALIZER_MAP.put(".tdm", new TutorialDialogMessageDeserializer());
        DESERIALIZER_MAP.put(".tlt", new TutorialListDeserializer());
        DESERIALIZER_MAP.put(".tqg", new TutorialQuestGroupDeserializer());
        DESERIALIZER_MAP.put(".wal", new WarpLocationDeserializer());
        DESERIALIZER_MAP.put(".tcm", new Tbl2ChatMacroDeserializer());
        DESERIALIZER_MAP.put(".aml", new AnimalDataDeserializer());
        DESERIALIZER_MAP.put(".fnl", new FurnitureLayoutDeserializer());
        DESERIALIZER_MAP.put(".fng", new FurnitureGroupDeserializer());
        DESERIALIZER_MAP.put(".fnd", new FurnitureDataDeserializer());
        DESERIALIZER_MAP.put(".fni", new FurnitureItemDeserializer());
        DESERIALIZER_MAP.put(".ebi_sv", new EmBaseInfoSvDeserializer());
        DESERIALIZER_MAP.put(".edv", new EmDamageDirInfoDeserializer());
        DESERIALIZER_MAP.put(".evl", new EvaluationTableDeserializer());
        DESERIALIZER_MAP.put(".dgm", new GUIDogmaOrbDeserializer());
        DESERIALIZER_MAP.put(".nmp", new NpcMeetingPlaceDeserializer());
        DESERIALIZER_MAP.put(".nci", new NpcConstItemDeserializer());
        DESERIALIZER_MAP.put(".smc", new SituationMsgCtrlDeserializer());
    }

    private final Logger logger = LogManager.getLogger(DeserializerFactory.class);

    public Deserializer forFile(String fileName) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));
        Deserializer<?> deserializer = DESERIALIZER_MAP.getOrDefault(fileNameExtension, null);
        if (deserializer != null) {
            logger.debug("File extension '{}' matches deserializer {}.", fileNameExtension, deserializer.getClass().getSimpleName());
        } else {
            logger.debug("No deserializer found for file extension '{}'.", fileNameExtension);
        }
        return deserializer;
    }
}
