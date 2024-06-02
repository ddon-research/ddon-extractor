package org.sehkah.ddon.tools.extractor.lib.logic.resource;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization.ClientResourceSerializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization.ClientStringSerializer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Getter
public abstract class ClientResourceFileManager {
    protected final Set<ClientResourceFile> clientResourceFileSet;
    protected final Map<Pair<ClientResourceFileExtension, FileHeader>, ClientResourceFile> clientResourceFileMap;
    protected final Serializer<TopLevelClientResource> stringSerializer;

    protected ClientResourceFileManager(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        stringSerializer = ClientStringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
        clientResourceFileSet = HashSet.newHashSet(128);
        clientResourceFileMap = HashMap.newHashMap(128);

        setup(clientResourceFileSet);

        for (ClientResourceFile clientResourceFile : clientResourceFileSet) {
            clientResourceFileMap.put(clientResourceFile.getIdentifier(), clientResourceFile);
        }
    }

    public abstract void setup(Set<ClientResourceFile> clientResourceFileSet);

    public ClientResourceDeserializer<TopLevelClientResource> getDeserializer(String fileName, BufferReader bufferReader) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));

        if (fileNameExtension.isBlank()) {
            log.warn("File '%s' has no extension, unable to look up deserializer.".formatted(fileName));
            return null;
        }

        ClientResourceFileExtension clientResourceFileExtension = ClientResourceFileExtension.of(fileNameExtension);
        ClientResourceDeserializer<TopLevelClientResource> clientResourceDeserializer;
        Set<FileHeader> fileHeaderCandidates = ClientResourceFileDeserializer.identifyFileHeaderCandidates(bufferReader);
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
