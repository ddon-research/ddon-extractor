package org.sehkah.ddon.tools.extractor.lib.logic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.EncryptedArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ReferenceArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.base.ItemListDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.game_common.PlayerExpTableDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM.BitTableDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM.EmDmgTimerTblDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM.EmLvUpParamDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM.RageTableDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.Human.BakeJointTblDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.Human.CatchInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.Human.CaughtInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.MyRoom.AnimalDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.MyRoom.MyRoomActParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.base.*;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.clankyoten.*;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.craft_common.*;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.em_common.BlowSaveEmLvParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.em_common.EmBaseInfoSvDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.em_common.EmDamageDirInfoDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.em_common.EvaluationTableDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.equip.EquipPresetDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.fieldarea.FieldAreaAdjoinListDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.fieldarea.FieldAreaMarkerInfoDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common.*;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.gui_cmn.*;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.job.StaminaDecTblDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.launcher.ArchiveListArrayDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.marker.DungeonMarkerDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.marker.StageAdjoinListDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.npc.SituationMsgCtrlDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.npc_common.NpcConstItemDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.npc_common.NpcMeetingPlaceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.pawn.AIPawnActNoSwitchTblDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.pawn.AISensorDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.quest.PawnQuestTalkDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.quest.QuestMarkerInfoDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.quest.QuestTextDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.scr.MapSpotDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.sg300000.ShopGoodsDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.skill.CustomSkillDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.skill.NormalSkillDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage.LocationDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage.Tbl2ChatMacroDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage.WaypointDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.tutorial_guide.TutorialDialogMessageDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.tutorial_guide.TutorialListDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.history.QuestHistoryDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIAreaMaster.AreaMasterRankDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIAreaMaster.AreaMasterSpotDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIAreaMaster.AreaMasterSpotDetailDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIArisenCard.AchievementHeaderDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIDogmaOrb.GUIDogmaOrbDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIKeyConfig.KeyConfigTextTableDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUISkill.AbilityAddDataDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.ClientResourceSerializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.ClientStringSerializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.season3.game_common.EnemyGroupSerializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.season3.game_common.GUIMessageSerializer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFileExtension.*;

@Slf4j
@Getter
public class ClientResourceFileManager {
    private final Set<ClientResourceFile> clientResourceFileSet;
    private final Map<Pair<ClientResourceFileExtension, FileHeader>, ClientResourceFile> clientResourceFileMap;
    private final Serializer<TopLevelClientResource> stringSerializer;

    protected ClientResourceFileManager(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        stringSerializer = ClientStringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
        clientResourceFileSet = HashSet.newHashSet(128);
        clientResourceFileMap = HashMap.newHashMap(128);
        setupClientResourceFiles(clientResourceFileSet);
        for (ClientResourceFile clientResourceFile : clientResourceFileSet) {
            clientResourceFileMap.put(clientResourceFile.getIdentifier(), clientResourceFile);
        }
    }

    public static ClientResourceFileManager get(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        return new ClientResourceFileManager(preferredSerializationType, shouldSerializeMetaInformation);
    }

    private static void setupClientResourceFiles(Set<ClientResourceFile> clientResourceFileSet) {
        clientResourceFileSet.add(new ClientResourceFile(rArchive, new FileHeader("ARCC", 7, 2), EncryptedArchiveDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rArchive, new FileHeader("ARCS", 7, 2), ReferenceArchiveDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rArchiveListArray, new FileHeader(11, 4), ArchiveListArrayDeserializer.class));
        setupClientResourceFilesSeasonThree(clientResourceFileSet);
        setupClientResourceFilesSeasonTwo(clientResourceFileSet);
    }

    private static void setupClientResourceFilesSeasonThree(Set<ClientResourceFile> clientResourceFileSet) {
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnActNoSwitch, new FileHeader(5, 4), AIPawnActNoSwitchTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnAutoMotionTbl, new FileHeader(6, 4), AIPawnAutoMotionTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnAutoWordTbl, new FileHeader(4, 4), AIPawnAutoWordTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnEmParam, new FileHeader(17, 4), AIPawnEmParamDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnOrder, new FileHeader(15, 4), AIPawnOrderDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnSkillParamTbl, new FileHeader(6, 4), AIPawnSkillParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAISensor, new FileHeader("SNR2", 1, 4), AISensorDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAbilityAddData, new FileHeader(1, 4), AbilityAddDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAbilityData, new FileHeader(3, 4), AbilityDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAbilityList, new FileHeader("abl0", 9, 4), AbilityListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAchievement, new FileHeader(2, 4), AchievementDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAchievementHeader, new FileHeader(3, 4), AchievementHeaderDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAdjLimitParam, new FileHeader(5, 4), AdjLimitParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAdjustParam, new FileHeader(256, 4), JobAdjustParamDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAnimalData, new FileHeader(0, 4), AnimalDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAreaInfo, new FileHeader("ARI\0", 2, 4), AreaInfoDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAreaInfoJointArea, new FileHeader("ARJ\0", 2, 4), AreaInfoJointAreaDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAreaInfoStage, new FileHeader("ARS\0", 2, 4), AreaInfoStageDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAreaMasterRankData, new FileHeader(4, 4), AreaMasterRankDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAreaMasterSpotData, new FileHeader(8, 4), AreaMasterSpotDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAreaMasterSpotDetailData, new FileHeader(5, 4), AreaMasterSpotDetailDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rBakeJoint, new FileHeader(3, 4), BakeJointTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rBitTable, new FileHeader(2, 4), BitTableDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rBlowSaveEmLvParam, new FileHeader(2, 4), BlowSaveEmLvParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCalcDamageAtdmAdj, new FileHeader(1, 4), CalcDamageAtdmAdjTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCalcDamageAtdmAdjRate, new FileHeader(1, 4), CalcDamageAtdmAdjRateTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCalcDamageLvAdj, new FileHeader(17, 4), CalcDamageLvAdjTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCatchInfoParam, new FileHeader(19, 4), CatchInfoParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCaughtDamageRateRefTbl, new FileHeader(1, 4), CaughtDamageRateRefTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCaughtDamageRateTbl, new FileHeader(1, 4), CaughtDamageRateTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCaughtInfoParam, new FileHeader(16, 4), CaughtInfoParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCraftCapPass, new FileHeader(2, 4), CraftCapPassDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCraftElementExp, new FileHeader(1, 4), CraftElementExpDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCraftQuality, new FileHeader(1, 4), CraftQualityDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCraftSkillCost, new FileHeader(2, 4), CraftSkillCostDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCraftSkillSpd, new FileHeader(3, 4), CraftSkillSpeedDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCraftUpGradeExp, new FileHeader(1, 4), CraftUpGradeExpDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCustomSkillData, new FileHeader(3, 4), CustomSkillDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCycleQuestInfo, new FileHeader("CQI\0", 2, 4), CycleQuestInfoDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rDungeonMarker, new FileHeader("DMI\0", 1, 4), DungeonMarkerDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEmBaseInfoSv, new FileHeader(21, 4), EmBaseInfoSvDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEmDamageDirInfo, new FileHeader(2, 4), EmDamageDirInfoDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEmDmgTimerTbl, new FileHeader(2, 4), EmDmgTimerTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEmLvUpParam, new FileHeader(7, 4), EmLvUpParamDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEnemyGroup, new FileHeader(1, 4), EnemyGroupDeserializer.class, EnemyGroupSerializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEquipPreset, new FileHeader(7, 4), EquipPresetDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEvaluationTable, new FileHeader(4, 4), EvaluationTableDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEventParam, new FileHeader(19, 4), EventParamDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFieldAreaAdjoinList, new FileHeader("FAA\0", 2, 4), FieldAreaAdjoinListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFieldAreaList, new FileHeader("FAl\0", 2, 4), FieldAreaListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFieldAreaMarkerInfo, new FileHeader("FMI\0", 1, 4), FieldAreaMarkerInfoDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFieldMapData, new FileHeader("fmd\0", 18, 4), FieldMapDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureData, new FileHeader(5, 4), FurnitureDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureGroup, new FileHeader(1, 4), FurnitureGroupDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureItem, new FileHeader(1, 4), FurnitureItemDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureLayout, new FileHeader(1, 4), FurnitureLayoutDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rGUIDogmaOrb, new FileHeader(1, 4), GUIDogmaOrbDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rGUIMessage, new FileHeader("GMD\0", 66306, 4), GUIMessageDeserializer.class, GUIMessageSerializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rGatheringItem, new FileHeader(1, 4), GatheringItemDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rHumanEnemyCustomSkill, new FileHeader(3, 4), HumanEnemyCustomSkillDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rHumanEnemyEquip, new FileHeader(3, 4), HumanEnemyEquipDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rJobBaseParam, new FileHeader(263, 4), JobBaseParamDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rJobLevelUpTbl2, new FileHeader(1, 4), JobLevelUpTableDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rJobMasterCtrl, new FileHeader(256, 4), JobMasterCtrlDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rJobTutorialQuestList, new FileHeader("JTQ\0", 1, 2), JobTutorialQuestListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rKeyConfigTextTable, new FileHeader(1, 4), KeyConfigTextTableDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rLandInfo, new FileHeader("LAI\0", 4, 4), LandInfoDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rLayoutPreset, new FileHeader(5, 4), LayoutPresetDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rLocationData, new FileHeader("lcd\0", 16, 4), LocationDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rMapSpotData, new FileHeader("msd\0", 0, 4), MapSpotDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rMapSpotStageList, new FileHeader("msl\0", 0, 4), MapSpotStageListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rMsgSet, new FileHeader("mgst", 3, 2), MsgSetDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rMyRoomActParam, new FileHeader(15, 4), MyRoomActParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rNamedParam, new FileHeader(5, 4), NamedParamDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rNormalSkillData, new FileHeader(5, 4), NormalSkillDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rNpcConstItem, new FileHeader(2, 4), NpcConstItemDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rNpcMeetingPlace, new FileHeader(0, 4), NpcMeetingPlaceDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rPawnQuestTalk, new FileHeader("PQT\0", 1, 4), PawnQuestTalkDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rPlPartsInfo, new FileHeader("PSI\0", 1, 4), PlPartsInfoDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rPrologueHmStatus, new FileHeader(0, 4), PrologueHmStatusDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rQuestHistoryData, new FileHeader(1, 4), QuestHistoryDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rQuestMarkerInfo, new FileHeader("QMI\0", 1, 4), QuestMarkerInfoDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rQuestSequenceList, new FileHeader(256, 4), QuestSequenceListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rQuestTextData, new FileHeader("QTD\0", 2, 4), QuestTextDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rRageTable, new FileHeader(257, 4), RageTableDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rShopGoods, new FileHeader("TBL\0", 259, 4), ShopGoodsDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rShrinkBlowValue, new FileHeader(2, 4), ShrinkBlowValueDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rSituationMsgCtrl, new FileHeader("SMC\0", 3, 4), SituationMsgCtrlDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rStageAdjoinList, new FileHeader("SAL\0", 4, 4), StageAdjoinListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rStageList, new FileHeader("slt\0", 34, 4), StageListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rStageMap, new FileHeader(1, 4), StageMapDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rStageToSpot, new FileHeader(0, 4), StageToSpotDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rStaminaDecTbl, new FileHeader("sdt\0", 7, 4), StaminaDecTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rStartPosArea, new FileHeader(0, 4), StartPosAreaDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rStatusGainTable, new FileHeader(257, 4), StatusGainTableDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rTbl2ChatMacro, new FileHeader(256, 4), Tbl2ChatMacroDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rTutorialDialogMessage, new FileHeader("TDM\0", 2, 4), TutorialDialogMessageDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rTutorialList, new FileHeader("TLT\0", 6, 4), TutorialListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rTutorialQuestGroup, new FileHeader("TQG\0", 1, 2), TutorialQuestGroupDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rWarpLocation, new FileHeader(353, 4), WarpLocationDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rWaypoint, new FileHeader("WPT\0", 2, 4), WaypointDeserializer.class));
    }

    private static void setupClientResourceFilesSeasonTwo(Set<ClientResourceFile> clientResourceFileSet) {
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnEmParam, new FileHeader(15, 4), AIPawnEmParamDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAbilityList, new FileHeader("abl0", 8, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.base.AbilityListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAreaMasterSpotData, new FileHeader(7, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.ui.uGUIAreaMaster.AreaMasterSpotDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rAreaMasterSpotDetailData, new FileHeader(4, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.ui.uGUIAreaMaster.AreaMasterSpotDetailDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCatchInfoParam, new FileHeader(18, 4), CatchInfoParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCaughtInfoParam, new FileHeader(15, 4), CaughtInfoParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rCustomSkillData, new FileHeader(1, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.skill.CustomSkillDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rEventParam, new FileHeader(18, 4), EventParamDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureData, new FileHeader(4, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.clankyoten.FurnitureDataDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rItemList, new FileHeader("ipa\0", 58, 4), ItemListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rLandInfo, new FileHeader("LAI\0", 2, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.base.LandInfoDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rMyRoomActParam, new FileHeader(14, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.MyRoom.MyRoomActParamTblDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rPlayerExpTable, new FileHeader(2, 4), PlayerExpTableDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rSituationMsgCtrl, new FileHeader("SMC\0", 2, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.npc.SituationMsgCtrlDeserializer.class));
// TODO: java.nio.BufferUnderflowException       clientResourceFileSet.add(new ClientResourceFile(rStageAdjoinList, new FileHeader("SAL\0", 3, 4), StageAdjoinListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rTutorialList, new FileHeader("TLT\0", 5, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.tutorial_guide.TutorialListDeserializer.class));
        clientResourceFileSet.add(new ClientResourceFile(rWarpLocation, new FileHeader(352, 4), org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.gui_cmn.WarpLocationDeserializer.class));
    }

    public ClientResourceDeserializer<TopLevelClientResource> getDeserializer(String fileName, FileReader fileReader) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));
        ClientResourceFileExtension clientResourceFileExtension = ClientResourceFileExtension.of(fileNameExtension);
        ClientResourceDeserializer<TopLevelClientResource> clientResourceDeserializer;
        Set<FileHeader> fileHeaderCandidates = ClientResourceFileDeserializer.identifyFileHeaderCandidates(fileReader);
        for (FileHeader fileHeaderCandidate : fileHeaderCandidates) {
            Pair<ClientResourceFileExtension, FileHeader> candidateKey = Pair.of(clientResourceFileExtension, fileHeaderCandidate);
            log.debug("Attempting to match candidate file header '%s'.".formatted(candidateKey));
            if (clientResourceFileMap.containsKey(candidateKey)) {
                clientResourceDeserializer = clientResourceFileMap.get(candidateKey).getDeserializer();
                log.debug("File matches deserializer {}.", clientResourceDeserializer.getClass().getSimpleName());
                return clientResourceDeserializer;
            }
        }
        log.debug("No deserializer found for file '%s'.".formatted(fileName));
        return null;
    }

    public ClientResourceSerializer<TopLevelClientResource> getSerializer(String fileName, TopLevelClientResource deserialized) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.')).replace(".json", "").replace(".yaml", "");
        ClientResourceFileExtension clientResourceFileExtension = ClientResourceFileExtension.of(fileNameExtension);
        ClientResourceFile clientResourceFile = clientResourceFileMap.getOrDefault(Pair.of(clientResourceFileExtension, deserialized.getFileHeader()), null);
        if (clientResourceFile != null) {
            ClientResourceSerializer<TopLevelClientResource> serializer = clientResourceFile.getSerializer();
            log.debug("File matches serializer {}.", serializer.getClass().getSimpleName());
            return serializer;
        }
        log.debug("No serializer found for file.");
        return null;
    }
}
