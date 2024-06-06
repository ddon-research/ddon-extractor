package org.sehkah.ddon.tools.extractor.common.logic.resource;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;
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
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EncryptedArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ReferenceArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base.AreaInfoJointAreaDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base.AreaInfoStageDeserializer;

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
 * client resource given a file and its buffer via {@link ClientResourceFileManager#getDeserializer(String, BufferReader)}.
 * <p>
 * Regarding initialization:
 * It is mandatory that the season-specific resources are initialized before the resource cache and lookup util
 * can be provided.
 * Thus it is ensured that {@link ClientResourceFileManager#setupResourceMapping()} is called before {@link ClientResourceFileManager#setupResourceLookupUtil(Path)}.
 */
@Slf4j
@Getter
public abstract class ClientResourceFileManager {
    protected final Set<ClientResourceFile<TopLevelClientResource>> clientResourceFileSet;
    protected final Map<Pair<ClientResourceFileExtension, FileHeader>, ClientResourceFile<TopLevelClientResource>> clientResourceFileMap;
    protected final Serializer<TopLevelClientResource> stringSerializer;
    protected final ResourceMetadataLookupUtil lookupUtil;

    protected ClientResourceFileManager(Path clientRootFolder, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        stringSerializer = ClientStringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
        clientResourceFileSet = setupResourceMapping();

        addCommonResourceMapping(clientResourceFileSet);

        if (shouldSerializeMetaInformation) {
            lookupUtil = setupResourceLookupUtil(clientRootFolder);
        } else {
            lookupUtil = null;
        }

        clientResourceFileMap = HashMap.newHashMap(clientResourceFileSet.size());
        for (ClientResourceFile<TopLevelClientResource> clientResourceFile : clientResourceFileSet) {
            clientResourceFileMap.put(clientResourceFile.getIdentifier(), clientResourceFile);
        }
    }

    private <T extends TopLevelClientResource> void addCommonResourceMapping(Set<ClientResourceFile<T>> clientResourceFileSet) {
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchive, new FileHeader("ARCC", 7, 2), new EncryptedArchiveDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rArchive, new FileHeader("ARCS", 7, 2), new ReferenceArchiveDeserializer()));

        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaInfoJointArea, new FileHeader("ARJ\0", 2, 4), new AreaInfoJointAreaDeserializer()));
        clientResourceFileSet.add((ClientResourceFile<T>) new ClientResourceFile<>(rAreaInfoStage, new FileHeader("ARS\0", 2, 4), new AreaInfoStageDeserializer()));
    }

    /**
     * Initializes a {@link ResourceMetadataLookupUtil}.
     * To accomplish this, a client root folder is required as well as a season-specific resource setup stored in {@link ClientResourceFileManager#clientResourceFileSet}.
     *
     * @param clientRootFolder root installation folder, e.g. C:\DDON
     * @return an initialized lookup util
     */
    public abstract ResourceMetadataLookupUtil setupResourceLookupUtil(Path clientRootFolder);

    /**
     * Initializes the season-specific resource file setup in {@link ClientResourceFileManager#clientResourceFileSet}.
     *
     * @return a unique set of season-specific resource files associated with their serializers and deserializers.
     */
    public abstract <T extends TopLevelClientResource> Set<ClientResourceFile<T>> setupResourceMapping();

    public <T extends TopLevelClientResource> T deserialize(String fileName, BufferReader bufferReader) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));

        if (fileNameExtension.isBlank()) {
            log.warn("File '%s' has no extension, unable to look up deserializer.".formatted(fileName));
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
                clientResourceDeserializer.deserialize(clientResourceFile, bufferReader, lookupUtil);
            }
        }
        log.debug("No deserializer found for file '%s'.".formatted(fileName));
        return null;
    }

    public <T extends TopLevelClientResource> ClientResourceSerializer<T> getSerializer(String fileName, T deserialized) {
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
