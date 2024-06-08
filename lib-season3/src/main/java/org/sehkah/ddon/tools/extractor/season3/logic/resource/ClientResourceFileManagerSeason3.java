package org.sehkah.ddon.tools.extractor.season3.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common.NpcLedgerListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human.BakeJointTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human.CatchInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human.CaughtInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human.WeaponOffsetTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.character_edit.EditStageParamDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.collision_common.PushRateListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.craft_common.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.effect_common.VfxLightInfluenceListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.em_common.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.equip.EquipPresetDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea.FieldAreaAdjoinListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea.FieldAreaMarkerInfoDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.gui_cmn.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.job.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.launcher.ArchiveListArrayDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker.DungeonMarkerDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker.StageAdjoinList2Deserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker.StageAdjoinListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc.SituationMsgCtrlDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc_common.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.om.OmKeyDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.om.OmParamPartDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.pawn.AIPawnActNoSwitchTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.pawn.AISensorDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.quest.PawnQuestTalkDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.quest.QuestListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.quest.QuestMarkerInfoDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.quest.QuestTextDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.scr.MapSpotDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.sg300000.ShopGoodsDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.skill.CustomSkillDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.skill.NormalSkillDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.tutorial_guide.TutorialListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.history.QuestHistoryDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIAreaMaster.AreaMasterRankDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIAreaMaster.AreaMasterSpotDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIAreaMaster.AreaMasterSpotDetailDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIArisenCard.AchievementHeaderDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIDogmaOrb.GUIDogmaOrbDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIKeyConfig.KeyConfigTextTableDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUISkill.AbilityAddDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.wep_res_table.WeaponResTableDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.wep_res_table.WepCateResTblDeserializer;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFileExtension.*;

@Slf4j
public class ClientResourceFileManagerSeason3 extends ClientResourceFileManager {
    public ClientResourceFileManagerSeason3(Path clientRootFolder, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        super(clientRootFolder, preferredSerializationType, shouldSerializeMetaInformation);
    }

    @Override
    public ResourceMetadataLookupUtil setupResourceLookupUtil(Path clientRootFolder) {
        return new ResourceMetadataLookupUtilSeason3(clientRootFolder, GUIMessageResourceFile);
    }

    @Override
    public <T extends Resource> Set<ClientResourceFile<T>> setupResourceMapping() {
        Set<ClientResourceFile<T>> clientResourceFileSet = HashSet.newHashSet(128);

        clientResourceFileSet.add(new ClientResourceFile(rAbilityAddData, new FileHeader(1, 4), new AbilityAddDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAbilityList, new FileHeader("abl0", 9, 4), new AbilityListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAchievementHeader, new FileHeader(3, 4), new AchievementHeaderDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAdjLimitParam, new FileHeader(5, 4), new AdjLimitParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAdjustParam, new FileHeader(256, 4), new JobAdjustParamDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnActNoSwitch, new FileHeader(5, 4), new AIPawnActNoSwitchTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnAutoMotionTbl, new FileHeader(6, 4), new AIPawnAutoMotionTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnAutoWordTbl, new FileHeader(4, 4), new AIPawnAutoWordTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnEmParam, new FileHeader(17, 4), new AIPawnEmParamDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnOrder, new FileHeader(15, 4), new AIPawnOrderDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAIPawnSkillParamTbl, new FileHeader(6, 4), new AIPawnSkillParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAISensor, new FileHeader("SNR2", 1, 4), new AISensorDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAnimalData, new FileHeader(0, 4), new AnimalDataDeserializer()));

        clientResourceFileSet.add(new ClientResourceFile(rArchiveListArray, new FileHeader(11, 4), new ArchiveListArrayDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAreaInfo, new FileHeader("ARI\0", 2, 4), new AreaInfoDeserializer()));

        clientResourceFileSet.add(new ClientResourceFile(rAreaMasterRankData, new FileHeader(4, 4), new AreaMasterRankDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAreaMasterSpotData, new FileHeader(8, 4), new AreaMasterSpotDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rAreaMasterSpotDetailData, new FileHeader(5, 4), new AreaMasterSpotDetailDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rBakeJoint, new FileHeader(3, 4), new BakeJointTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rBitTable, new FileHeader(2, 4), new BitTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rBlowSaveEmLvParam, new FileHeader(2, 4), new BlowSaveEmLvParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCalcDamageAtdmAdj, new FileHeader(1, 4), new CalcDamageAtdmAdjTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCalcDamageAtdmAdjRate, new FileHeader(1, 4), new CalcDamageAtdmAdjRateTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCalcDamageLvAdj, new FileHeader(17, 4), new CalcDamageLvAdjTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCatchInfoParam, new FileHeader(19, 4), new CatchInfoParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCaughtDamageRateRefTbl, new FileHeader(1, 4), new CaughtDamageRateRefTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCaughtDamageRateTbl, new FileHeader(1, 4), new CaughtDamageRateTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCaughtInfoParam, new FileHeader(16, 4), new CaughtInfoParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCharParamEnemy, new FileHeader("cpe\0", 11, 4), new CharParamEnemyTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rChildRegionStatusParam, new FileHeader(65, 4), new ChildRegionStatusParamDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rChildRegionStatusParamList, new FileHeader(65, 4), new ChildRegionStatusParamListTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCraftCapPass, new FileHeader(2, 4), new CraftCapPassDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCraftElementExp, new FileHeader(1, 4), new CraftElementExpDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCraftQuality, new FileHeader(1, 4), new CraftQualityDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCraftSkillCost, new FileHeader(2, 4), new CraftSkillCostDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCraftSkillSpd, new FileHeader(3, 4), new CraftSkillSpeedDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCraftUpGradeExp, new FileHeader(1, 4), new CraftUpGradeExpDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCustomSkillData, new FileHeader(3, 4), new CustomSkillDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCycleContentsSortieInfo, new FileHeader(1, 4), new CycleContentsSortieInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rCycleQuestInfo, new FileHeader("CQI\0", 2, 4), new CycleQuestInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rDungeonMarker, new FileHeader("DMI\0", 1, 4), new DungeonMarkerDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEditStageParam, new FileHeader("esp\0", 12, 4), new EditStageParamDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEmBaseInfoSv, new FileHeader(21, 4), new EmBaseInfoSvDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEmDamageDirInfo, new FileHeader(2, 4), new EmDamageDirInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEmDmgTimerTbl, new FileHeader(2, 4), new EmDmgTimerTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEmLvUpParam, new FileHeader(7, 4), new EmLvUpParamDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEmScaleTable, new FileHeader(257, 4), new EmScaleTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEmSoundTable, new FileHeader(261, 4), new EmSoundTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEmWarpParam, new FileHeader(3, 4), new EmWarpParamTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEmWorkRateTable, new FileHeader(258, 4), new EmWorkRateTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEndContentsSortieInfo, new FileHeader(4, 4), new EndContentsSortieInfoDeserializer()));

        clientResourceFileSet.add(new ClientResourceFile(rEnemyLocalEst, new FileHeader(259, 4), new EnemyLocalEstTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEnemyMaterialTable, new FileHeader(260, 4), new EnemyMaterialTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEnemyReactResEx, new FileHeader(3, 4), new EnemyReactResExTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEnemyReactResEx, new FileHeader(6, 4), new EnemyReactResExTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEnemyStatusChange, new FileHeader(9, 4), new EnemyStatusChangeTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEquipPreset, new FileHeader(7, 4), new EquipPresetDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEvaluationTable, new FileHeader(4, 4), new EvaluationTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rEventParam, new FileHeader(19, 4), new EventParamDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rFieldAreaAdjoinList, new FileHeader("FAA\0", 2, 4), new FieldAreaAdjoinListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rFieldAreaList, new FileHeader("FAl\0", 2, 4), new FieldAreaListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rFieldAreaMarkerInfo, new FileHeader("FMI\0", 1, 4), new FieldAreaMarkerInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rFieldMapData, new FileHeader("fmd\0", 18, 4), new FieldMapDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureData, new FileHeader(5, 4), new FurnitureDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureGroup, new FileHeader(1, 4), new FurnitureGroupDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureItem, new FileHeader(1, 4), new FurnitureItemDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rFurnitureLayout, new FileHeader(1, 4), new FurnitureLayoutDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rGatheringItem, new FileHeader(1, 4), new GatheringItemDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rGUIDogmaOrb, new FileHeader(1, 4), new GUIDogmaOrbDeserializer()));

        clientResourceFileSet.add(new ClientResourceFile(rHumanEnemyCustomSkill, new FileHeader(3, 4), new HumanEnemyCustomSkillDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rHumanEnemyEquip, new FileHeader(3, 4), new HumanEnemyEquipDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rJobBaseParam, new FileHeader(263, 4), new JobBaseParamDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rJobLevelUpTbl2, new FileHeader(1, 4), new JobLevelUpTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rJobMasterCtrl, new FileHeader(256, 4), new JobMasterCtrlDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rJobTutorialQuestList, new FileHeader("JTQ\0", 1, 2), new JobTutorialQuestListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rJointInfo, new FileHeader(6, 4), new JointInfoTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rJointInfo, new FileHeader(259, 4), new JointInfoTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rJointOrder, new FileHeader(3, 4), new JointOrderTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rJumpParamTbl, new FileHeader(4, 4), new JumpParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rKeyConfigTextTable, new FileHeader(1, 4), new KeyConfigTextTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rLandInfo, new FileHeader("LAI\0", 4, 4), new LandInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rLayout, new FileHeader("lot\0", 138, 4), new LayoutDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rLayoutPreset, new FileHeader(5, 4), new LayoutPresetDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rLocationData, new FileHeader("lcd\0", 16, 4), new LocationDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rMagicChantParam, new FileHeader(17, 4), new MagicChantParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rMagicCommandList, new FileHeader(27, 4), new MagicCommandListTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rMagicCommandWord, new FileHeader(1, 4), new MagicCommandWordTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rMapSpotData, new FileHeader("msd\0", 0, 4), new MapSpotDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rMapSpotStageList, new FileHeader("msl\0", 0, 4), new MapSpotStageListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rMsgSet, new FileHeader("mgst", 3, 2), new MsgSetDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rMyRoomActParam, new FileHeader(15, 4), new MyRoomActParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rNormalSkillData, new FileHeader(5, 4), new NormalSkillDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rNpcConstItem, new FileHeader(2, 4), new NpcConstItemDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rNpcCustomSkill, new FileHeader(5, 4), new NpcCustomSkillListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rNpcIsNoSetPS3, new FileHeader(1, 4), new NpcIsNoSetPS3TblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rNpcIsUseJobParamEx, new FileHeader(1, 4), new NpcIsUseJobParamExDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rNpcLedgerList, new FileHeader("nll\0", 6, 4), new NpcLedgerListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rNpcMeetingPlace, new FileHeader(0, 4), new NpcMeetingPlaceDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rOcdElectricParam, new FileHeader(1, 4), new OcdElectricParamListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rOcdImmuneParamRes, new FileHeader(37, 4), new OcdImmuneParamResTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rOcdStatusParamRes, new FileHeader(37, 4), new OcdStatusParamResListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rOmKey, new FileHeader("XFS\0", 15, 4), new OmKeyDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rOmParamPart, new FileHeader("OMPP", 69, 4), new OmParamPartDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rPackageQuestInfo, new FileHeader("PQI\0", 2, 4), new PackageQuestInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rParentRegionStatusParam, new FileHeader(65, 4), new ParentRegionStatusParamTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rPartnerPawnTalk, new FileHeader("ppt\0", 1, 4), new PartnerPawnTalkDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rPartnerReactParam, new FileHeader(4, 4), new PartnerReactParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rPartsCtrlTable, new FileHeader(256, 4), new PartsCtrlTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rPawnQuestTalk, new FileHeader("PQT\0", 1, 4), new PawnQuestTalkDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rPlPartsInfo, new FileHeader("PSI\0", 1, 4), new PlPartsInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rPrologueHmStatus, new FileHeader(0, 4), new PrologueHmStatusDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rPushRate, new FileHeader(256, 4), new PushRateListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rQuestHistoryData, new FileHeader(1, 4), new QuestHistoryDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rQuestList, new FileHeader("XFS\0", 9043983, 4), new QuestListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rQuestMarkerInfo, new FileHeader("QMI\0", 1, 4), new QuestMarkerInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rQuestSequenceList, new FileHeader(256, 4), new QuestSequenceListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rQuestTextData, new FileHeader("QTD\0", 2, 4), new QuestTextDataDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rRageTable, new FileHeader(257, 4), new RageTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rReplaceWardGmdList, new FileHeader(1, 4), new ReplaceWardGmdListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rRoomWearParam, new FileHeader(2, 4), new RoomWearParamTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rShopGoods, new FileHeader("TBL\0", 259, 4), new ShopGoodsDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rShotReqInfo, new FileHeader(9, 4), new ShotReqInfoTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rShotReqInfo2, new FileHeader(9, 4), new ShotReqInfo2TblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rShrinkBlowValue, new FileHeader(2, 4), new ShrinkBlowValueDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rSituationMsgCtrl, new FileHeader("SMC\0", 3, 4), new SituationMsgCtrlDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageAdjoinList, new FileHeader("SAL\0", 4, 4), new StageAdjoinListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageAdjoinList2, new FileHeader("SAL2", 1, 4), new StageAdjoinList2Deserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageConnect, new FileHeader("scc\0", 7, 4), new StageConnectDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageCustom, new FileHeader("sca\0", 9, 4), new StageCustomDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageCustomPartsEx, new FileHeader("scpx", 5, 4), new StageCustomPartsExDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageInfo, new FileHeader("sti\0", 265, 4), new StageInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageJoint, new FileHeader("sja\0", 19, 4), new StageJointDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageList, new FileHeader("slt\0", 34, 4), new StageListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageMap, new FileHeader(1, 4), new StageMapDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStageToSpot, new FileHeader(0, 4), new StageToSpotDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStaminaDecTbl, new FileHeader("sdt\0", 7, 4), new StaminaDecTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStartPos, new FileHeader("XFS\0", 196623, 4), new StartPosDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStartPosArea, new FileHeader(0, 4), new StartPosAreaDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStatusCheck, new FileHeader(4, 4), new StatusCheckTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rStatusGainTable, new FileHeader(257, 4), new StatusGainTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rTbl2ChatMacro, new FileHeader(256, 4), new Tbl2ChatMacroDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rTexDetailEdit, new FileHeader("XFS\0", 393231, 4), new TexDetailEditDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rTutorialList, new FileHeader("TLT\0", 6, 4), new TutorialListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rTutorialQuestGroup, new FileHeader("TQG\0", 1, 2), new TutorialQuestGroupDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rVfxLightInfluence, new FileHeader(3, 4), new VfxLightInfluenceListDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rWarpLocation, new FileHeader(353, 4), new WarpLocationDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rWaypoint, new FileHeader("WPT\0", 2, 4), new WaypointDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rWaypoint2, new FileHeader("WP2\0", 1, 4), new WaypointDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rWeaponOffset, new FileHeader(3, 4), new WeaponOffsetTblDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rWeaponResTable, new FileHeader(11, 4), new WeaponResTableDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rWeatherStageInfo, new FileHeader("WSI_", 7, 4), new WeatherStageInfoDeserializer()));
        clientResourceFileSet.add(new ClientResourceFile(rWepCateResTbl, new FileHeader(1, 4), new WepCateResTblDeserializer()));
        //TODO: rAIFSM continuation
        //clientResourceFileSet.add(new ClientResourceFile(rAIFSM, new FileHeader("XFS\0", 131087, 4), new AIFSMDeserializer()));

        return clientResourceFileSet;
    }
}
