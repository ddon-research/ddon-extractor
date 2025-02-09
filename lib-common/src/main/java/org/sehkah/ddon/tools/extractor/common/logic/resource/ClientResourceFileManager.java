package org.sehkah.ddon.tools.extractor.common.logic.resource;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFileExtension;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.ClientResourceSerializer;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.ClientStringSerializer;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.api.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EncryptedArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.Human.BakeJointTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.Human.WeaponOffsetTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ReferenceArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.character_edit.EditStageParamDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.collision_common.PushRateListDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.craft_common.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.effect_common.VfxLightInfluenceListDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common.EmDamageDirInfoDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common.EvaluationTableDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.equip.EquipPresetDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.job.MagicChantParamTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.job.MagicCommandListTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.job.MagicCommandWordTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.launcher.ArchiveListArrayDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common.NpcConstItemDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common.NpcCustomSkillListDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common.NpcMeetingPlaceDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.pawn.AIPawnActNoSwitchTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.pawn.AISensorDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.quest.QuestMarkerInfoDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.quest.QuestTextDataDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.shop.ShopGoodsDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.skill.NormalSkillDataDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.sound.SoundBossBgmDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.sound.SoundOptDataTableDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.stage.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.tutorial_guide.TutorialDialogMessageDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.wep_res_table.WepCateResTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.AreaInfoStageList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroupList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.MsgSet;
import org.sehkah.ddon.tools.extractor.common.logic.resource.serialization.game_common.EnemyGroupSerializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.serialization.game_common.GUIMessageSerializer;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFileExtension.*;

/**
 * A season-specific client resource file manager is responsible for associating supported client resources in
 * various versions with their appropriate deserializers and serializers.
 * To accomplish this season-specific knowledge and logic is required, thus it is expected that
 * a season-specific manager take care of setting up such associations.
 * <p>
 * The super class takes care of caching mechanism, file header identification and retrieval of the correct
 * client resource given a file and its buffer via {@link ClientResourceFileManager#deserialize(Path, BufferReader)}.
 * <p>
 * Regarding initialization:
 * It is mandatory that the season-specific resources are initialized before the resource cache and lookup util
 * can be provided.
 * Thus it is ensured that {@link ClientResourceFileManager#setupResourceMapping()} is called before {@link ClientResourceFileManager#setupResourceLookupUtil(Path, Path, ClientResourceFile, ClientResourceFile, ClientResourceFile, ClientResourceFile)}.
 */
@Slf4j
@Getter
public abstract class ClientResourceFileManager {
    protected final Set<ClientResourceFile<Resource>> clientResourceFileSet;
    protected final Map<Pair<ClientResourceFileExtension, FileHeader>, ClientResourceFile<Resource>> clientResourceFileMap;
    protected final Serializer<Resource> stringSerializer;
    protected final ResourceMetadataLookupUtil lookupUtil;
    protected ClientResourceFile<MsgSet> MsgSetResourceFile;
    protected ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile;
    protected ClientResourceFile<EnemyGroupList> EnemyGroupListResourceFile;
    protected ClientResourceFile<AreaInfoStageList> AreaInfoStageListResourceFile;

    protected ClientResourceFileManager(Path clientRootFolder, Path clientTranslationFile, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        stringSerializer = ClientStringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
        clientResourceFileSet = setupResourceMapping();
        addCommonResourceMapping(clientResourceFileSet);

        if (shouldSerializeMetaInformation) {
            lookupUtil = setupResourceLookupUtil(clientRootFolder, clientTranslationFile, MsgSetResourceFile, NpcLedgerListResourceFile, EnemyGroupListResourceFile, AreaInfoStageListResourceFile);
        } else {
            lookupUtil = null;
        }

        clientResourceFileMap = HashMap.newHashMap(clientResourceFileSet.size());
        for (ClientResourceFile<Resource> clientResourceFile : clientResourceFileSet) {
            clientResourceFileMap.put(clientResourceFile.getIdentifier(), clientResourceFile);
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Resource> void addCommonResourceMapping(Set<ClientResourceFile<T>> clientResourceFileSet) {
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rGUIMessage, new FileHeader("GMD\0", 66306, 4), new GUIMessageDeserializer(), new GUIMessageSerializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAbilityAddData, new FileHeader(1, 4), new AbilityAddDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAbilityData, new FileHeader(3, 4), new AbilityDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAchievement, new FileHeader(2, 4), new AchievementDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAchievementHeader, new FileHeader(3, 4), new AchievementHeaderDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAdjLimitParam, new FileHeader(5, 4), new AdjLimitParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAdjustParam, new FileHeader(256, 4), new JobAdjustParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnActNoSwitch, new FileHeader(5, 4), new AIPawnActNoSwitchTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnAutoMotionTbl, new FileHeader(6, 4), new AIPawnAutoMotionTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnSkillParamTbl, new FileHeader(6, 4), new AIPawnSkillParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAISensor, new FileHeader("SNR2", 1, 4), new AISensorDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchive, new FileHeader("ARCC", 7, 2), new EncryptedArchiveDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchive, new FileHeader("ARCS", 7, 2), new ReferenceArchiveDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchiveListArray, new FileHeader(11, 4), new ArchiveListArrayDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaInfoJointArea, new FileHeader("ARJ\0", 2, 4), new AreaInfoJointAreaDeserializer()));
        AreaInfoStageListResourceFile = new ClientResourceFile<>(rAreaInfoStage, new FileHeader("ARS\0", 2, 4), new AreaInfoStageDeserializer());
        clientResourceFileSet.add((ClientResourceFile<T>) AreaInfoStageListResourceFile);

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rBakeJoint, new FileHeader(3, 4), new BakeJointTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rBitTable, new FileHeader(2, 4), new BitTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageAtdmAdj, new FileHeader(1, 4), new CalcDamageAtdmAdjTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageAtdmAdjRate, new FileHeader(1, 4), new CalcDamageAtdmAdjRateTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageLvAdj, new FileHeader(17, 4), new CalcDamageLvAdjTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtDamageRateRefTbl, new FileHeader(1, 4), new CaughtDamageRateRefTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtDamageRateTbl, new FileHeader(1, 4), new CaughtDamageRateTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftCapPass, new FileHeader(2, 4), new CraftCapPassDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftElementExp, new FileHeader(1, 4), new CraftElementExpDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftQuality, new FileHeader(1, 4), new CraftQualityDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillCost, new FileHeader(2, 4), new CraftSkillCostDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillSpd, new FileHeader(3, 4), new CraftSkillSpeedDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftUpGradeExp, new FileHeader(1, 4), new CraftUpGradeExpDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCycleQuestInfo, new FileHeader("CQI\0", 2, 4), new CycleQuestInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEditStageParam, new FileHeader("esp\0", 12, 4), new EditStageParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmDamageDirInfo, new FileHeader(2, 4), new EmDamageDirInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmDmgTimerTbl, new FileHeader(2, 4), new EmDmgTimerTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmScaleTable, new FileHeader(257, 4), new EmScaleTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmSoundTable, new FileHeader(261, 4), new EmSoundTableDeserializer()));
        EnemyGroupListResourceFile = new ClientResourceFile<>(rEnemyGroup, new FileHeader(1, 4), new EnemyGroupDeserializer(), new EnemyGroupSerializer());
        clientResourceFileSet.add((ClientResourceFile<T>) EnemyGroupListResourceFile);
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyLocalEst, new FileHeader(259, 4), new EnemyLocalEstTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyMaterialTable, new FileHeader(260, 4), new EnemyMaterialTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyReactResEx, new FileHeader(6, 4), new EnemyReactResExTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyStatusChange, new FileHeader(9, 4), new EnemyStatusChangeTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEquipPreset, new FileHeader(7, 4), new EquipPresetDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEvaluationTable, new FileHeader(4, 4), new EvaluationTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rGatheringItem, new FileHeader(1, 4), new GatheringItemDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rGUIDogmaOrb, new FileHeader(1, 4), new GUIDogmaOrbDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rHumanEnemyCustomSkill, new FileHeader(3, 4), new HumanEnemyCustomSkillDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rHumanEnemyEquip, new FileHeader(3, 4), new HumanEnemyEquipDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJobLevelUpTbl2, new FileHeader(1, 4), new JobLevelUpTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJobMasterCtrl, new FileHeader(256, 4), new JobMasterCtrlDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJobTutorialQuestList, new FileHeader("JTQ\0", 1, 2), new JobTutorialQuestListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJointInfo, new FileHeader(259, 4), new JointInfoTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rJointOrder, new FileHeader(3, 4), new JointOrderTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rLayoutPreset, new FileHeader(5, 4), new LayoutPresetDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMagicChantParam, new FileHeader(17, 4), new MagicChantParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMagicCommandList, new FileHeader(27, 4), new MagicCommandListTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMagicCommandWord, new FileHeader(1, 4), new MagicCommandWordTblDeserializer()));
        MsgSetResourceFile = new ClientResourceFile<>(rMsgSet, new FileHeader("mgst", 3, 2), new MsgSetDeserializer());
        clientResourceFileSet.add((ClientResourceFile<T>) MsgSetResourceFile);

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNamedParam, new FileHeader(5, 4), new NamedParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNormalSkillData, new FileHeader(5, 4), new NormalSkillDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcConstItem, new FileHeader(2, 4), new NpcConstItemDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcCustomSkill, new FileHeader(5, 4), new NpcCustomSkillListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNpcMeetingPlace, new FileHeader(0, 4), new NpcMeetingPlaceDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rOcdElectricParam, new FileHeader(1, 4), new OcdElectricParamListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPartsCtrlTable, new FileHeader(256, 4), new PartsCtrlTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPlPartsInfo, new FileHeader("PSI\0", 1, 4), new PlPartsInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPrologueHmStatus, new FileHeader(0, 4), new PrologueHmStatusDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rPushRate, new FileHeader(256, 4), new PushRateListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestHistoryData, new FileHeader(1, 4), new QuestHistoryDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestMarkerInfo, new FileHeader("QMI\0", 1, 4), new QuestMarkerInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestSequenceList, new FileHeader(256, 4), new QuestSequenceListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rQuestTextData, new FileHeader("QTD\0", 2, 4), new QuestTextDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rRageTable, new FileHeader(257, 4), new RageTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rReplaceWardGmdList, new FileHeader(1, 4), new ReplaceWardGmdListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShopGoods, new FileHeader("TBL\0", 259, 4), new ShopGoodsDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShotReqInfo, new FileHeader(9, 4), new ShotReqInfoTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rShrinkBlowValue, new FileHeader(2, 4), new ShrinkBlowValueDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageMap, new FileHeader(1, 4), new StageMapDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStageToSpot, new FileHeader(0, 4), new StageToSpotDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStartPosArea, new FileHeader(0, 4), new StartPosAreaDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStatusCheck, new FileHeader(4, 4), new StatusCheckTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rStatusGainTable, new FileHeader(257, 4), new StatusGainTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTbl2ChatMacro, new FileHeader(256, 4), new Tbl2ChatMacroDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTutorialDialogMessage, new FileHeader("TDM\0", 2, 4), new TutorialDialogMessageDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTutorialQuestGroup, new FileHeader("TQG\0", 1, 2), new TutorialQuestGroupDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rVfxLightInfluence, new FileHeader(3, 4), new VfxLightInfluenceListDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWaypoint, new FileHeader("WPT\0", 2, 4), new WaypointDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeaponOffset, new FileHeader(3, 4), new WeaponOffsetTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeatherStageInfo, new FileHeader("WSI_", 7, 4), new WeatherStageInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWepCateResTbl, new FileHeader(1, 4), new WepCateResTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rSoundBossBgm, new FileHeader("SBB\0", 1, 4), new SoundBossBgmDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyBloodStain, new FileHeader(1, 4), new EnemyBloodStainTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rSoundOptData, new FileHeader(1, 4), new SoundOptDataTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTargetCursorOffset, new FileHeader(272, 4), new TargetCursorOffsetTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeatherFogInfo, new FileHeader(3, 4), new WeatherFogInfoTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rWeatherParamInfoTbl, new FileHeader(12, 4), new WeatherParamInfoTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNavigationMesh, new FileHeader("NAV\0", 33, 4), new NavigationMeshDeserializer()));
    }

    /**
     * Initializes a {@link ResourceMetadataLookupUtil}.
     * To accomplish this, a client root folder is required as well as a season-specific resource setup stored in {@link ClientResourceFileManager#clientResourceFileSet}.
     *
     * @param clientRootFolder              root installation folder, e.g. C:\DDON
     * @param clientTranslationFile
     * @param npcLedgerListResourceFile
     * @param areaInfoStageListResourceFile
     * @return an initialized lookup util
     */
    public abstract ResourceMetadataLookupUtil setupResourceLookupUtil(Path clientRootFolder, Path clientTranslationFile, ClientResourceFile<MsgSet> msgSetResourceFile, ClientResourceFile<NpcLedgerList> npcLedgerListResourceFile, ClientResourceFile<EnemyGroupList> enemyGroupListResourceFile, ClientResourceFile<AreaInfoStageList> areaInfoStageListResourceFile);

    /**
     * Initializes the season-specific resource file setup in {@link ClientResourceFileManager#clientResourceFileSet}.
     *
     * @return a unique set of season-specific resource files associated with their serializers and deserializers.
     */
    public abstract <T extends Resource> Set<ClientResourceFile<T>> setupResourceMapping();

    public <T extends Resource> T deserialize(Path filePath, BufferReader bufferReader) {
        String fileName = filePath.getFileName().toString();
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));

        if (fileNameExtension.isBlank()) {
            log.warn("File '%s' has no extension, unable to look up deserializer.".formatted(filePath));
            return null;
        }

        ClientResourceFileExtension clientResourceFileExtension = ClientResourceFileExtension.of(fileNameExtension);
        ClientResourceDeserializer<T> clientResourceDeserializer;
        Set<FileHeader> fileHeaderCandidates = ClientResourceFileDeserializer.identifyFileHeaderCandidates(bufferReader);
        for (FileHeader fileHeaderCandidate : fileHeaderCandidates) {
            Pair<ClientResourceFileExtension, FileHeader> candidateKey = Pair.of(clientResourceFileExtension, fileHeaderCandidate);
            log.debug("Attempting to match candidate file header {}.", candidateKey);
            if (clientResourceFileMap.containsKey(candidateKey)) {
                ClientResourceFile<T> clientResourceFile = (ClientResourceFile<T>) clientResourceFileMap.get(candidateKey);
                clientResourceDeserializer = clientResourceFile.getDeserializer();
                log.debug("File {} matches deserializer {}.", filePath, clientResourceDeserializer.getClass().getSimpleName());
                return clientResourceDeserializer.deserialize(filePath, clientResourceFile, bufferReader, lookupUtil);
            }
        }
        log.debug("No deserializer found for file '%s'.".formatted(filePath));
        return null;
    }

    public <T extends Resource> ClientResourceSerializer<T> getSerializer(String fileName, T deserialized) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.')).replace(".json", "").replace(".yaml", "");
        ClientResourceFileExtension clientResourceFileExtension = ClientResourceFileExtension.of(fileNameExtension);
        ClientResourceFile<T> clientResourceFile = (ClientResourceFile<T>) clientResourceFileMap.getOrDefault(Pair.of(clientResourceFileExtension, deserialized.getFileHeader()), null);
        if (clientResourceFile != null) {
            ClientResourceSerializer<T> serializer = clientResourceFile.getSerializer();
            log.debug("File matches serializer {}.", serializer.getClass().getSimpleName());
            return serializer;
        }
        log.debug("No serializer found for file.");
        return null;
    }
}
