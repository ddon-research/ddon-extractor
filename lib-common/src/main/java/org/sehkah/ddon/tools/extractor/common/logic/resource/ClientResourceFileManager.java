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
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ReferenceArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base.AreaInfoJointAreaDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base.AreaInfoStageDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base.JobAdjustParamDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.character_edit.EditStageParamDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.craft_common.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common.EmDamageDirInfoDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn.AbilityDataDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn.AchievementDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.launcher.ArchiveListArrayDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.pawn.AIPawnActNoSwitchTblDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.pawn.AISensorDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.tutorial_guide.TutorialDialogMessageDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui.MsgSetDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui.uGUIArisenCard.AchievementHeaderDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui.uGUISkill.AbilityAddDataDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;
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
 * Thus it is ensured that {@link ClientResourceFileManager#setupResourceMapping()} is called before {@link ClientResourceFileManager#setupResourceLookupUtil(Path, ClientResourceFile, ClientResourceFile)}.
 */
@Slf4j
@Getter
public abstract class ClientResourceFileManager {
    protected final Set<ClientResourceFile<Resource>> clientResourceFileSet;
    protected final Map<Pair<ClientResourceFileExtension, FileHeader>, ClientResourceFile<Resource>> clientResourceFileMap;
    protected final Serializer<Resource> stringSerializer;
    protected final ResourceMetadataLookupUtil lookupUtil;
    protected ClientResourceFile<GUIMessage> GUIMessageResourceFile;
    protected ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile;

    protected ClientResourceFileManager(Path clientRootFolder, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        stringSerializer = ClientStringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
        clientResourceFileSet = setupResourceMapping();
        addCommonResourceMapping(clientResourceFileSet);

        if (shouldSerializeMetaInformation) {
            lookupUtil = setupResourceLookupUtil(clientRootFolder, GUIMessageResourceFile, NpcLedgerListResourceFile);
        } else {
            lookupUtil = null;
        }

        clientResourceFileMap = HashMap.newHashMap(clientResourceFileSet.size());
        for (ClientResourceFile<Resource> clientResourceFile : clientResourceFileSet) {
            clientResourceFileMap.put(clientResourceFile.getIdentifier(), clientResourceFile);
        }
    }

    private <T extends Resource> void addCommonResourceMapping(Set<ClientResourceFile<T>> clientResourceFileSet) {
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchive, new FileHeader("ARCC", 7, 2), new EncryptedArchiveDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchive, new FileHeader("ARCS", 7, 2), new ReferenceArchiveDeserializer()));

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaInfoJointArea, new FileHeader("ARJ\0", 2, 4), new AreaInfoJointAreaDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaInfoStage, new FileHeader("ARS\0", 2, 4), new AreaInfoStageDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyGroup, new FileHeader(1, 4), new EnemyGroupDeserializer(), new EnemyGroupSerializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rNamedParam, new FileHeader(5, 4), new NamedParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAbilityData, new FileHeader(3, 4), new AbilityDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAchievement, new FileHeader(2, 4), new AchievementDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rTutorialDialogMessage, new FileHeader("TDM\0", 2, 4), new TutorialDialogMessageDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rMsgSet, new FileHeader("mgst", 3, 2), new MsgSetDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAbilityAddData, new FileHeader(1, 4), new AbilityAddDataDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAchievementHeader, new FileHeader(3, 4), new AchievementHeaderDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAdjLimitParam, new FileHeader(5, 4), new AdjLimitParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAdjustParam, new FileHeader(256, 4), new JobAdjustParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnActNoSwitch, new FileHeader(5, 4), new AIPawnActNoSwitchTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnAutoMotionTbl, new FileHeader(6, 4), new AIPawnAutoMotionTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAIPawnSkillParamTbl, new FileHeader(6, 4), new AIPawnSkillParamTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAISensor, new FileHeader("SNR2", 1, 4), new AISensorDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchiveListArray, new FileHeader(11, 4), new ArchiveListArrayDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rBakeJoint, new FileHeader(3, 4), new BakeJointTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rBitTable, new FileHeader(2, 4), new BitTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageAtdmAdj, new FileHeader(1, 4), new CalcDamageAtdmAdjTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageAtdmAdjRate, new FileHeader(1, 4), new CalcDamageAtdmAdjRateTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCalcDamageLvAdj, new FileHeader(17, 4), new CalcDamageLvAdjTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtDamageRateRefTbl, new FileHeader(1, 4), new CaughtDamageRateRefTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCaughtDamageRateTbl, new FileHeader(1, 4), new CaughtDamageRateTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftCapPass, new FileHeader(2, 4), new CraftCapPassDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftElementExp, new FileHeader(1, 4), new CraftElementExpDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillCost, new FileHeader(2, 4), new CraftSkillCostDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftSkillSpd, new FileHeader(3, 4), new CraftSkillSpeedDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftUpGradeExp, new FileHeader(1, 4), new CraftUpGradeExpDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCraftQuality, new FileHeader(1, 4), new CraftQualityDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rCycleQuestInfo, new FileHeader("CQI\0", 2, 4), new CycleQuestInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEditStageParam, new FileHeader("esp\0", 12, 4), new EditStageParamDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmDamageDirInfo, new FileHeader(2, 4), new EmDamageDirInfoDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmDmgTimerTbl, new FileHeader(2, 4), new EmDmgTimerTblDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmScaleTable, new FileHeader(257, 4), new EmScaleTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEmSoundTable, new FileHeader(261, 4), new EmSoundTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyLocalEst, new FileHeader(259, 4), new EnemyLocalEstTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyMaterialTable, new FileHeader(260, 4), new EnemyMaterialTableDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rEnemyStatusChange, new FileHeader(9, 4), new EnemyStatusChangeTableDeserializer()));

        GUIMessageResourceFile = new ClientResourceFile<>(rGUIMessage, new FileHeader("GMD\0", 66306, 4), new GUIMessageDeserializer(), new GUIMessageSerializer());
        clientResourceFileSet.add((ClientResourceFile<T>) GUIMessageResourceFile);
    }

    /**
     * Initializes a {@link ResourceMetadataLookupUtil}.
     * To accomplish this, a client root folder is required as well as a season-specific resource setup stored in {@link ClientResourceFileManager#clientResourceFileSet}.
     *
     * @param clientRootFolder          root installation folder, e.g. C:\DDON
     * @param GUIMessageResourceFile
     * @param npcLedgerListResourceFile
     * @return an initialized lookup util
     */
    public abstract ResourceMetadataLookupUtil setupResourceLookupUtil(Path clientRootFolder, ClientResourceFile<GUIMessage> GUIMessageResourceFile, ClientResourceFile<NpcLedgerList> npcLedgerListResourceFile);

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
            log.debug("Attempting to match candidate file header '%s'.".formatted(candidateKey));
            if (clientResourceFileMap.containsKey(candidateKey)) {
                ClientResourceFile<T> clientResourceFile = (ClientResourceFile<T>) clientResourceFileMap.get(candidateKey);
                clientResourceDeserializer = clientResourceFile.getDeserializer();
                log.debug("File matches deserializer {}.", clientResourceDeserializer.getClass().getSimpleName());
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
