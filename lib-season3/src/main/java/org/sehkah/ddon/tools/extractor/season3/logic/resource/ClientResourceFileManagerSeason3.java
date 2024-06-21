package org.sehkah.ddon.tools.extractor.season3.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM.EmLvUpParamDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM.EmWorkRateTableDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM.OcdImmuneParamResTableDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.Human.CatchInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.Human.CaughtInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common.EmBaseInfoSvDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common.OcdStatusParamResListDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.job.StaminaDecTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common.NpcLedgerListDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.stage.WaypointDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui.AreaMasterRankDataDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.wep_res_table.WeaponResTableDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroupList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.FurnitureDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.FurnitureGroupDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.FurnitureItemDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten.FurnitureLayoutDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.em_common.BlowSaveEmLvParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea.FieldAreaAdjoinListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea.FieldAreaMarkerInfoDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.gui_cmn.FieldMapDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.gui_cmn.MapSpotStageListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.gui_cmn.WarpLocationDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.job.JumpParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker.DungeonMarkerDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker.StageAdjoinList2Deserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker.StageAdjoinListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc.SituationMsgCtrlDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc_common.NpcIsNoSetPS3TblDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc_common.NpcIsUseJobParamExDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.om.OmKeyDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.om.OmParamPartDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.quest.AIFSMDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.quest.PawnQuestTalkDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.quest.QuestListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.scr.MapSpotDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.skill.CustomSkillDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.tutorial_guide.TutorialListDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.GUIMapSettingDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIAreaMaster.AreaMasterSpotDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIAreaMaster.AreaMasterSpotDetailDataDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIKeyConfig.KeyConfigTextTableDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.ItemList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.StageListInfoList;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFileExtension.*;

@Slf4j
public class ClientResourceFileManagerSeason3 extends ClientResourceFileManager {
    private ClientResourceFile<StageListInfoList> StageListInfoResourceFile;
    private ClientResourceFile<ItemList> ItemListResourceFile;

    public ClientResourceFileManagerSeason3(Path clientRootFolder, Path clientTranslationFile, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        super(clientRootFolder, clientTranslationFile, preferredSerializationType, shouldSerializeMetaInformation);
    }

    @Override
    public ResourceMetadataLookupUtil setupResourceLookupUtil(Path clientRootFolder, Path clientTranslationFile, ClientResourceFile<NpcLedgerList> npcLedgerListResourceFile, ClientResourceFile<EnemyGroupList> enemyGroupListResourceFile) {
        return new ResourceMetadataLookupUtilSeason3(clientRootFolder, clientTranslationFile, npcLedgerListResourceFile, enemyGroupListResourceFile, StageListInfoResourceFile, ItemListResourceFile);
    }

    @Override
    public <T extends Resource> Set<ClientResourceFile<T>> setupResourceMapping() {
        Set<ClientResourceFile<T>> clientResourceFileSet = HashSet.newHashSet(128);

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIFSM, new FileHeader("XFS\0", 131087, 4), new AIFSMDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAbilityList, new FileHeader("abl0", 9, 4), new AbilityListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnAutoWordTbl, new FileHeader(4, 4), new AIPawnAutoWordTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnEmParam, new FileHeader(17, 4), new AIPawnEmParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnOrder, new FileHeader(15, 4), new AIPawnOrderDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAnimalData, new FileHeader(0, 4), new AnimalDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaInfo, new FileHeader("ARI\0", 2, 4), new AreaInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaMasterRankData, new FileHeader(4, 4), new AreaMasterRankDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaMasterSpotData, new FileHeader(8, 4), new AreaMasterSpotDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaMasterSpotDetailData, new FileHeader(5, 4), new AreaMasterSpotDetailDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rBlowSaveEmLvParam, new FileHeader(2, 4), new BlowSaveEmLvParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCatchInfoParam, new FileHeader(19, 4), new CatchInfoParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtInfoParam, new FileHeader(16, 4), new CaughtInfoParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCharParamEnemy, new FileHeader("cpe\0", 11, 4), new CharParamEnemyTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rChildRegionStatusParam, new FileHeader(65, 4), new ChildRegionStatusParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rChildRegionStatusParamList, new FileHeader(65, 4), new ChildRegionStatusParamListTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCustomSkillData, new FileHeader(3, 4), new CustomSkillDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCycleContentsSortieInfo, new FileHeader(1, 4), new CycleContentsSortieInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rDungeonMarker, new FileHeader("DMI\0", 1, 4), new DungeonMarkerDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmBaseInfoSv, new FileHeader(21, 4), new EmBaseInfoSvDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmLvUpParam, new FileHeader(7, 4), new EmLvUpParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmWarpParam, new FileHeader(3, 4), new EmWarpParamTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmWorkRateTable, new FileHeader(258, 4), new EmWorkRateTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEndContentsSortieInfo, new FileHeader(4, 4), new EndContentsSortieInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEventParam, new FileHeader(19, 4), new EventParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFieldAreaAdjoinList, new FileHeader("FAA\0", 2, 4), new FieldAreaAdjoinListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFieldAreaList, new FileHeader("FAl\0", 2, 4), new FieldAreaListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFieldAreaMarkerInfo, new FileHeader("FMI\0", 1, 4), new FieldAreaMarkerInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFieldMapData, new FileHeader("fmd\0", 18, 4), new FieldMapDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFurnitureData, new FileHeader(5, 4), new FurnitureDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFurnitureGroup, new FileHeader(1, 4), new FurnitureGroupDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFurnitureItem, new FileHeader(1, 4), new FurnitureItemDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rFurnitureLayout, new FileHeader(1, 4), new FurnitureLayoutDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rGUIMapSetting, new FileHeader("GMP\0", 6, 4), new GUIMapSettingDeserializer()));
        ItemListResourceFile = new ClientResourceFile<>(rItemList, new FileHeader("ipa\0", 68, 4), new ItemListDeserializer());
        clientResourceFileSet.add((ClientResourceFile<T>) ItemListResourceFile);
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJobBaseParam, new FileHeader(263, 4), new JobBaseParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJumpParamTbl, new FileHeader(4, 4), new JumpParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rKeyConfigTextTable, new FileHeader(1, 4), new KeyConfigTextTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLandInfo, new FileHeader("LAI\0", 4, 4), new LandInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLayout, new FileHeader("lot\0", 138, 4), new LayoutDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLocationData, new FileHeader("lcd\0", 16, 4), new LocationDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMapSpotData, new FileHeader("msd\0", 0, 4), new MapSpotDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMapSpotStageList, new FileHeader("msl\0", 0, 4), new MapSpotStageListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMyRoomActParam, new FileHeader(15, 4), new MyRoomActParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcIsNoSetPS3, new FileHeader(1, 4), new NpcIsNoSetPS3TblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcIsUseJobParamEx, new FileHeader(1, 4), new NpcIsUseJobParamExDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOcdImmuneParamRes, new FileHeader(37, 4), new OcdImmuneParamResTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOcdStatusParamRes, new FileHeader(37, 4), new OcdStatusParamResListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOmKey, new FileHeader("XFS\0", 15, 4), new OmKeyDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOmParamPart, new FileHeader("OMPP", 69, 4), new OmParamPartDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPackageQuestInfo, new FileHeader("PQI\0", 2, 4), new PackageQuestInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rParentRegionStatusParam, new FileHeader(65, 4), new ParentRegionStatusParamTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPartnerPawnTalk, new FileHeader("ppt\0", 1, 4), new PartnerPawnTalkDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPartnerReactParam, new FileHeader(4, 4), new PartnerReactParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPawnQuestTalk, new FileHeader("PQT\0", 1, 4), new PawnQuestTalkDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestList, new FileHeader("XFS\0", 9043983, 4), new QuestListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rRoomWearParam, new FileHeader(2, 4), new RoomWearParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShotReqInfo2, new FileHeader(9, 4), new ShotReqInfo2TblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rSituationMsgCtrl, new FileHeader("SMC\0", 3, 4), new SituationMsgCtrlDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageAdjoinList, new FileHeader("SAL\0", 4, 4), new StageAdjoinListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageAdjoinList2, new FileHeader("SAL2", 1, 4), new StageAdjoinList2Deserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageConnect, new FileHeader("scc\0", 7, 4), new StageConnectDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageCustom, new FileHeader("sca\0", 9, 4), new StageCustomDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageCustomPartsEx, new FileHeader("scpx", 5, 4), new StageCustomPartsExDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageInfo, new FileHeader("sti\0", 265, 4), new StageInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageJoint, new FileHeader("sja\0", 19, 4), new StageJointDeserializer()));
        StageListInfoResourceFile = new ClientResourceFile<>(rStageList, new FileHeader("slt\0", 34, 4), new StageListDeserializer());
        clientResourceFileSet.add((ClientResourceFile<T>) StageListInfoResourceFile);
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStaminaDecTbl, new FileHeader("sdt\0", 7, 4), new StaminaDecTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStartPos, new FileHeader("XFS\0", 196623, 4), new StartPosDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rScenario, new FileHeader("XFS\0", 458767, 4), new ScenarioDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTexDetailEdit, new FileHeader("XFS\0", 393231, 4), new TexDetailEditDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTutorialList, new FileHeader("TLT\0", 6, 4), new TutorialListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWarpLocation, new FileHeader(353, 4), new WarpLocationDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWaypoint2, new FileHeader("WP2\0", 1, 4), new WaypointDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeaponResTable, new FileHeader(11, 4), new WeaponResTableDeserializer()));
        NpcLedgerListResourceFile = new ClientResourceFile<>(rNpcLedgerList, new FileHeader("nll\0", 6, 4), new NpcLedgerListDeserializer());
        clientResourceFileSet.add((ClientResourceFile<T>) NpcLedgerListResourceFile);

        return clientResourceFileSet;
    }
}
