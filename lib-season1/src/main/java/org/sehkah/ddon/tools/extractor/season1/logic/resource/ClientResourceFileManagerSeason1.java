package org.sehkah.ddon.tools.extractor.season1.logic.resource;

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
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM.*;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.Human.CatchInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.Human.CaughtInfoParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.base.AbilityListDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.base.AreaInfoDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.base.LayoutPresetDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.base.TexDetailEditDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.em_common.EmBaseInfoSvDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.em_common.OcdStatusParamResListDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common.*;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.gui_cmn.ReplaceWardGmdListDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.job.StaminaDecTblDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.marker.StageAdjoinListDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.npc.SituationMsgCtrlDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.sg300000.ShopGoodsDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.skill.CustomSkillDataDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.stage.StageCustomPartsDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.stage.StartPosDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.tutorial_guide.TutorialListDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.ui.history.QuestHistoryDataDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.ui.uGUIAreaMaster.AreaMasterRankDataDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.wep_res_table.WeaponResTableDeserializer;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFileExtension.*;


@Slf4j
public class ClientResourceFileManagerSeason1 extends ClientResourceFileManager {
    public ClientResourceFileManagerSeason1(Path clientRootFolder, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        super(clientRootFolder, preferredSerializationType, shouldSerializeMetaInformation);
    }

    @Override
    public ResourceMetadataLookupUtil setupResourceLookupUtil(Path clientRootFolder, ClientResourceFile<GUIMessage> GUIMessageResourceFile, ClientResourceFile<NpcLedgerList> npcLedgerListResourceFile) {
        return new ResourceMetadataLookupUtilSeason1(clientRootFolder, GUIMessageResourceFile, npcLedgerListResourceFile);
    }

    @Override
    public <T extends Resource> Set<ClientResourceFile<T>> setupResourceMapping() {
        Set<ClientResourceFile<T>> clientResourceFileSet = HashSet.newHashSet(128);
        // COMMON
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTexDetailEdit, new FileHeader("XFS\0", 393231, 4), new TexDetailEditDeserializer()));

        //SPECIFIC
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAbilityList, new FileHeader("abl0", 8, 4), new AbilityListDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rAIPawnAutoWordTbl, new FileHeader(3, 4), new AIPawnAutoWordTblDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rAIPawnEmParam, new FileHeader(12, 4), new AIPawnEmParamDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rAIPawnOrder, new FileHeader(13, 4), new AIPawnOrderDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaMasterRankData, new FileHeader(2, 4), new AreaMasterRankDataDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rAreaMasterSpotData, new FileHeader(6, 4), new AreaMasterSpotDataDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rAreaMasterSpotDetailData, new FileHeader(3, 4), new AreaMasterSpotDetailDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCatchInfoParam, new FileHeader(17, 4), new CatchInfoParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtInfoParam, new FileHeader(13, 4), new CaughtInfoParamTblDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rCharParamEnemy, new FileHeader("cpe\0", 3, 4), new CharParamEnemyTableDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rChildRegionStatusParam, new FileHeader(50, 4), new ChildRegionStatusParamDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rChildRegionStatusParamList, new FileHeader(50, 4), new ChildRegionStatusParamListTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCustomSkillData, new FileHeader(1, 4), new CustomSkillDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmBaseInfoSv, new FileHeader(3, 4), new EmBaseInfoSvDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmLvUpParam, new FileHeader(6, 4), new EmLvUpParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmWorkRateTable, new FileHeader(257, 4), new EmWorkRateTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyReactResEx, new FileHeader(3, 4), new EnemyReactResExTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyReactResEx, new FileHeader(6, 4), new EnemyReactResExTableDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rEventParam, new FileHeader(9, 4), new EventParamDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rFieldMapData, new FileHeader("fmd\0", 9, 4), new FieldMapDataDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rItemList, new FileHeader("ipa\0", 47, 4), new ItemListDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rJobBaseParam, new FileHeader(262, 4), new JobBaseParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJointInfo, new FileHeader(6, 4), new JointInfoTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJointInfo, new FileHeader(259, 4), new JointInfoTableDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rJumpParamTbl, new FileHeader(1, 4), new JumpParamTblDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rLayout, new FileHeader("lot\0", 82, 4), new LayoutDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLayoutPreset, new FileHeader(5, 4), new LayoutPresetDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rLocationData, new FileHeader("lcd\0", 5, 4), new LocationDataDeserializer()));
        NpcLedgerListResourceFile = new ClientResourceFile<>(rNpcLedgerList, new FileHeader("nll\0", 4, 4), new NpcLedgerListDeserializer());
        clientResourceFileSet.add((ClientResourceFile<T>) NpcLedgerListResourceFile);
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOcdImmuneParamRes, new FileHeader(18, 4), new OcdImmuneParamResTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOcdStatusParamRes, new FileHeader(18, 4), new OcdStatusParamResListDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rOmParam, new FileHeader("TBL\0", 54, 4), new OmParamDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rParentRegionStatusParam, new FileHeader(50, 4), new ParentRegionStatusParamTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPlayerExpTable, new FileHeader(2, 4), new PlayerExpTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestHistoryData, new FileHeader(1, 4), new QuestHistoryDataDeserializer()));
        // TODO: clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestList, new FileHeader("XFS\0", 393231, 4), new QuestListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rReplaceWardGmdList, new FileHeader(1, 4), new ReplaceWardGmdListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShopGoods, new FileHeader("TBL\0", 259, 4), new ShopGoodsDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShotReqInfo, new FileHeader(9, 4), new ShotReqInfoTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShrinkBlowValue, new FileHeader(2, 4), new ShrinkBlowValueDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rSituationMsgCtrl, new FileHeader("SMC\0", 2, 4), new SituationMsgCtrlDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rStageCustom, new FileHeader("sca\0", 7, 4), new StageCustomDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rStageInfo, new FileHeader("sti\0", 74, 4), new StageInfoDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rStageJoint, new FileHeader("sja\0", 13, 4), new StageJointDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rStageList, new FileHeader("slt\0", 26, 4), new StageListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStaminaDecTbl, new FileHeader("sdt\0", 5, 4), new StaminaDecTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStartPos, new FileHeader("XFS\0", 131087, 4), new StartPosDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTutorialList, new FileHeader("TLT\0", 3, 4), new TutorialListDeserializer()));
        // TODO: clientResourceFileSet.add(new ClientResourceFile(rWarpLocation, new FileHeader(304, 4), new WarpLocationDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeaponResTable, new FileHeader(9, 4), new WeaponResTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaInfo, new FileHeader("ARI\0", 2, 4), new AreaInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageAdjoinList, new FileHeader("SAL\0", 2, 4), new StageAdjoinListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageCustomParts, new FileHeader("scp\0", 16, 4), new StageCustomPartsDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftWepQualityParam, new FileHeader(2, 4), new CraftWepQualityParamTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftArmQualityParam, new FileHeader(3, 4), new CraftArmQualityParamTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftRecipe, new FileHeader("RCP\0", 6, 4), new CraftRecipeDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillGain, new FileHeader(2, 4), new CraftSkillGainTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillStr, new FileHeader(4, 4), new CraftSkillStrTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillBurst, new FileHeader(2, 4), new CraftSkillBurstTableDeserializer()));

        return clientResourceFileSet;
    }
}
