package org.sehkah.ddon.tools.extractor.season3.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common.NpcLedgerListDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human.BakeJointTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human.CatchInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human.CaughtInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human.WeaponOffsetTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.character_edit.EditStageParamDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.FurnitureDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.FurnitureGroupDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.FurnitureItemDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.FurnitureLayoutDeserializer;
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
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIDogmaOrb.GUIDogmaOrbDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIKeyConfig.KeyConfigTextTableDeserializer;
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
    public ResourceMetadataLookupUtil setupResourceLookupUtil(Path clientRootFolder, ClientResourceFile<GUIMessage> GUIMessageResourceFile, ClientResourceFile<NpcLedgerList> npcLedgerListResourceFile) {
        return new ResourceMetadataLookupUtilSeason3(clientRootFolder, GUIMessageResourceFile, npcLedgerListResourceFile);
    }

    @Override
    public <T extends Resource> Set<ClientResourceFile<T>> setupResourceMapping() {
        Set<ClientResourceFile<T>> clientResourceFileSet = HashSet.newHashSet(128);

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAbilityList, new FileHeader("abl0", 9, 4), new AbilityListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnAutoWordTbl, new FileHeader(4, 4), new AIPawnAutoWordTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnEmParam, new FileHeader(17, 4), new AIPawnEmParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnOrder, new FileHeader(15, 4), new AIPawnOrderDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAnimalData, new FileHeader(0, 4), new AnimalDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchiveListArray, new FileHeader(11, 4), new ArchiveListArrayDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaInfo, new FileHeader("ARI\0", 2, 4), new AreaInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaMasterRankData, new FileHeader(4, 4), new AreaMasterRankDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaMasterSpotData, new FileHeader(8, 4), new AreaMasterSpotDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaMasterSpotDetailData, new FileHeader(5, 4), new AreaMasterSpotDetailDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rBakeJoint, new FileHeader(3, 4), new BakeJointTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rBitTable, new FileHeader(2, 4), new BitTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rBlowSaveEmLvParam, new FileHeader(2, 4), new BlowSaveEmLvParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageAtdmAdj, new FileHeader(1, 4), new CalcDamageAtdmAdjTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageAtdmAdjRate, new FileHeader(1, 4), new CalcDamageAtdmAdjRateTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageLvAdj, new FileHeader(17, 4), new CalcDamageLvAdjTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCatchInfoParam, new FileHeader(19, 4), new CatchInfoParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtDamageRateRefTbl, new FileHeader(1, 4), new CaughtDamageRateRefTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtDamageRateTbl, new FileHeader(1, 4), new CaughtDamageRateTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtInfoParam, new FileHeader(16, 4), new CaughtInfoParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCharParamEnemy, new FileHeader("cpe\0", 11, 4), new CharParamEnemyTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rChildRegionStatusParam, new FileHeader(65, 4), new ChildRegionStatusParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rChildRegionStatusParamList, new FileHeader(65, 4), new ChildRegionStatusParamListTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftCapPass, new FileHeader(2, 4), new CraftCapPassDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftElementExp, new FileHeader(1, 4), new CraftElementExpDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftQuality, new FileHeader(1, 4), new CraftQualityDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillCost, new FileHeader(2, 4), new CraftSkillCostDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillSpd, new FileHeader(3, 4), new CraftSkillSpeedDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftUpGradeExp, new FileHeader(1, 4), new CraftUpGradeExpDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCustomSkillData, new FileHeader(3, 4), new CustomSkillDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCycleContentsSortieInfo, new FileHeader(1, 4), new CycleContentsSortieInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCycleQuestInfo, new FileHeader("CQI\0", 2, 4), new CycleQuestInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rDungeonMarker, new FileHeader("DMI\0", 1, 4), new DungeonMarkerDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEditStageParam, new FileHeader("esp\0", 12, 4), new EditStageParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmBaseInfoSv, new FileHeader(21, 4), new EmBaseInfoSvDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmDamageDirInfo, new FileHeader(2, 4), new EmDamageDirInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmDmgTimerTbl, new FileHeader(2, 4), new EmDmgTimerTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmLvUpParam, new FileHeader(7, 4), new EmLvUpParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmScaleTable, new FileHeader(257, 4), new EmScaleTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmSoundTable, new FileHeader(261, 4), new EmSoundTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmWarpParam, new FileHeader(3, 4), new EmWarpParamTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmWorkRateTable, new FileHeader(258, 4), new EmWorkRateTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEndContentsSortieInfo, new FileHeader(4, 4), new EndContentsSortieInfoDeserializer()));

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyLocalEst, new FileHeader(259, 4), new EnemyLocalEstTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyMaterialTable, new FileHeader(260, 4), new EnemyMaterialTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyReactResEx, new FileHeader(3, 4), new EnemyReactResExTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyReactResEx, new FileHeader(6, 4), new EnemyReactResExTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyStatusChange, new FileHeader(9, 4), new EnemyStatusChangeTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEquipPreset, new FileHeader(7, 4), new EquipPresetDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEvaluationTable, new FileHeader(4, 4), new EvaluationTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEventParam, new FileHeader(19, 4), new EventParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFieldAreaAdjoinList, new FileHeader("FAA\0", 2, 4), new FieldAreaAdjoinListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFieldAreaList, new FileHeader("FAl\0", 2, 4), new FieldAreaListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFieldAreaMarkerInfo, new FileHeader("FMI\0", 1, 4), new FieldAreaMarkerInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFieldMapData, new FileHeader("fmd\0", 18, 4), new FieldMapDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFurnitureData, new FileHeader(5, 4), new FurnitureDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFurnitureGroup, new FileHeader(1, 4), new FurnitureGroupDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFurnitureItem, new FileHeader(1, 4), new FurnitureItemDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFurnitureLayout, new FileHeader(1, 4), new FurnitureLayoutDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rGatheringItem, new FileHeader(1, 4), new GatheringItemDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rGUIDogmaOrb, new FileHeader(1, 4), new GUIDogmaOrbDeserializer()));

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rHumanEnemyCustomSkill, new FileHeader(3, 4), new HumanEnemyCustomSkillDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rHumanEnemyEquip, new FileHeader(3, 4), new HumanEnemyEquipDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJobBaseParam, new FileHeader(263, 4), new JobBaseParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJobLevelUpTbl2, new FileHeader(1, 4), new JobLevelUpTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJobMasterCtrl, new FileHeader(256, 4), new JobMasterCtrlDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJobTutorialQuestList, new FileHeader("JTQ\0", 1, 2), new JobTutorialQuestListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJointInfo, new FileHeader(6, 4), new JointInfoTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJointInfo, new FileHeader(259, 4), new JointInfoTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJointOrder, new FileHeader(3, 4), new JointOrderTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJumpParamTbl, new FileHeader(4, 4), new JumpParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rKeyConfigTextTable, new FileHeader(1, 4), new KeyConfigTextTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLandInfo, new FileHeader("LAI\0", 4, 4), new LandInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLayout, new FileHeader("lot\0", 138, 4), new LayoutDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLayoutPreset, new FileHeader(5, 4), new LayoutPresetDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLocationData, new FileHeader("lcd\0", 16, 4), new LocationDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMagicChantParam, new FileHeader(17, 4), new MagicChantParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMagicCommandList, new FileHeader(27, 4), new MagicCommandListTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMagicCommandWord, new FileHeader(1, 4), new MagicCommandWordTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMapSpotData, new FileHeader("msd\0", 0, 4), new MapSpotDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMapSpotStageList, new FileHeader("msl\0", 0, 4), new MapSpotStageListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMyRoomActParam, new FileHeader(15, 4), new MyRoomActParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNormalSkillData, new FileHeader(5, 4), new NormalSkillDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcConstItem, new FileHeader(2, 4), new NpcConstItemDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcCustomSkill, new FileHeader(5, 4), new NpcCustomSkillListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcIsNoSetPS3, new FileHeader(1, 4), new NpcIsNoSetPS3TblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcIsUseJobParamEx, new FileHeader(1, 4), new NpcIsUseJobParamExDeserializer()));

        NpcLedgerListResourceFile = new ClientResourceFile<>(rNpcLedgerList, new FileHeader("nll\0", 6, 4), new NpcLedgerListDeserializer());
        clientResourceFileSet.add((ClientResourceFile<T>) NpcLedgerListResourceFile);

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcMeetingPlace, new FileHeader(0, 4), new NpcMeetingPlaceDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOcdElectricParam, new FileHeader(1, 4), new OcdElectricParamListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOcdImmuneParamRes, new FileHeader(37, 4), new OcdImmuneParamResTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOcdStatusParamRes, new FileHeader(37, 4), new OcdStatusParamResListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOmKey, new FileHeader("XFS\0", 15, 4), new OmKeyDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOmParamPart, new FileHeader("OMPP", 69, 4), new OmParamPartDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPackageQuestInfo, new FileHeader("PQI\0", 2, 4), new PackageQuestInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rParentRegionStatusParam, new FileHeader(65, 4), new ParentRegionStatusParamTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPartnerPawnTalk, new FileHeader("ppt\0", 1, 4), new PartnerPawnTalkDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPartnerReactParam, new FileHeader(4, 4), new PartnerReactParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPartsCtrlTable, new FileHeader(256, 4), new PartsCtrlTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPawnQuestTalk, new FileHeader("PQT\0", 1, 4), new PawnQuestTalkDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPlPartsInfo, new FileHeader("PSI\0", 1, 4), new PlPartsInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPrologueHmStatus, new FileHeader(0, 4), new PrologueHmStatusDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPushRate, new FileHeader(256, 4), new PushRateListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestHistoryData, new FileHeader(1, 4), new QuestHistoryDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestList, new FileHeader("XFS\0", 9043983, 4), new QuestListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestMarkerInfo, new FileHeader("QMI\0", 1, 4), new QuestMarkerInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestSequenceList, new FileHeader(256, 4), new QuestSequenceListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestTextData, new FileHeader("QTD\0", 2, 4), new QuestTextDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rRageTable, new FileHeader(257, 4), new RageTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rReplaceWardGmdList, new FileHeader(1, 4), new ReplaceWardGmdListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rRoomWearParam, new FileHeader(2, 4), new RoomWearParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShopGoods, new FileHeader("TBL\0", 259, 4), new ShopGoodsDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShotReqInfo, new FileHeader(9, 4), new ShotReqInfoTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShotReqInfo2, new FileHeader(9, 4), new ShotReqInfo2TblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShrinkBlowValue, new FileHeader(2, 4), new ShrinkBlowValueDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rSituationMsgCtrl, new FileHeader("SMC\0", 3, 4), new SituationMsgCtrlDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageAdjoinList, new FileHeader("SAL\0", 4, 4), new StageAdjoinListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageAdjoinList2, new FileHeader("SAL2", 1, 4), new StageAdjoinList2Deserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageConnect, new FileHeader("scc\0", 7, 4), new StageConnectDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageCustom, new FileHeader("sca\0", 9, 4), new StageCustomDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageCustomPartsEx, new FileHeader("scpx", 5, 4), new StageCustomPartsExDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageInfo, new FileHeader("sti\0", 265, 4), new StageInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageJoint, new FileHeader("sja\0", 19, 4), new StageJointDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageList, new FileHeader("slt\0", 34, 4), new StageListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageMap, new FileHeader(1, 4), new StageMapDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageToSpot, new FileHeader(0, 4), new StageToSpotDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStaminaDecTbl, new FileHeader("sdt\0", 7, 4), new StaminaDecTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStartPos, new FileHeader("XFS\0", 196623, 4), new StartPosDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStartPosArea, new FileHeader(0, 4), new StartPosAreaDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStatusCheck, new FileHeader(4, 4), new StatusCheckTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStatusGainTable, new FileHeader(257, 4), new StatusGainTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTbl2ChatMacro, new FileHeader(256, 4), new Tbl2ChatMacroDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTexDetailEdit, new FileHeader("XFS\0", 393231, 4), new TexDetailEditDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTutorialList, new FileHeader("TLT\0", 6, 4), new TutorialListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTutorialQuestGroup, new FileHeader("TQG\0", 1, 2), new TutorialQuestGroupDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rVfxLightInfluence, new FileHeader(3, 4), new VfxLightInfluenceListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWarpLocation, new FileHeader(353, 4), new WarpLocationDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWaypoint, new FileHeader("WPT\0", 2, 4), new WaypointDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWaypoint2, new FileHeader("WP2\0", 1, 4), new WaypointDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeaponOffset, new FileHeader(3, 4), new WeaponOffsetTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeaponResTable, new FileHeader(11, 4), new WeaponResTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeatherStageInfo, new FileHeader("WSI_", 7, 4), new WeatherStageInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWepCateResTbl, new FileHeader(1, 4), new WepCateResTblDeserializer()));
        //TODO: rAIFSM continuation
        //clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIFSM, new FileHeader("XFS\0", 131087, 4), new AIFSMDeserializer()));

        return clientResourceFileSet;
    }
}
