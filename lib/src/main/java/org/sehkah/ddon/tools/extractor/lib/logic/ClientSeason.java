package org.sehkah.ddon.tools.extractor.lib.logic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.ClientResourceSerializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.StringSerializer;

import java.util.EnumMap;
import java.util.Map;

@Slf4j
@Getter
public abstract class ClientSeason {
    protected final Map<ClientResourceFileExtension, ClientResourceFile> clientResourceFileMap;
    private final Map<ClientResourceFileExtension, ClientResourceSerializer<? extends TopLevelClientResource>> serializerMap;
    private final Map<ClientResourceFileExtension, ClientResourceDeserializer<TopLevelClientResource>> deserializerMap;
    private final Serializer<TopLevelClientResource> stringSerializer;

    protected ClientSeason(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        clientResourceFileMap = new EnumMap<>(ClientResourceFileExtension.class);
        deserializerMap = new EnumMap<>(ClientResourceFileExtension.class);
        serializerMap = new EnumMap<>(ClientResourceFileExtension.class);
        stringSerializer = StringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
        setupClientResourceFiles(clientResourceFileMap);
        setupDeserializers(deserializerMap);
        setupSerializers(serializerMap);
    }

    public static ClientSeason get(ClientSeasonType clientSeasonType, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        return switch (clientSeasonType) {
            case TWO -> new ClientSeasonTwo(preferredSerializationType, shouldSerializeMetaInformation);
            case THREE -> new ClientSeasonThree(preferredSerializationType, shouldSerializeMetaInformation);
        };
    }

    public ClientResourceDeserializer<TopLevelClientResource> getDeserializer(String fileName) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));
        ClientResourceDeserializer<TopLevelClientResource> clientResourceDeserializer = deserializerMap.getOrDefault(ClientResourceFileExtension.of(fileNameExtension), null);
        if (clientResourceDeserializer != null) {
            log.debug("File extension '{}' matches deserializer {}.", fileNameExtension, clientResourceDeserializer.getClass().getSimpleName());
        } else {
            log.debug("No deserializer found for file extension '{}'.", fileNameExtension);
        }
        return clientResourceDeserializer;
    }

    public ClientResourceSerializer<TopLevelClientResource> getSerializer(String fileName) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.')).replace(".json", "").replace(".yaml", "");
        ClientResourceSerializer<? extends TopLevelClientResource> clientResourceSerializer = serializerMap.getOrDefault(ClientResourceFileExtension.of(fileNameExtension), null);
        if (clientResourceSerializer != null) {
            log.debug("File extension '{}' matches serializer {}.", fileNameExtension, clientResourceSerializer.getClass().getSimpleName());
        } else {
            log.debug("No serializer found for file extension '{}'.", fileNameExtension);
        }
        return (ClientResourceSerializer<TopLevelClientResource>) clientResourceSerializer;
    }

    protected abstract void setupClientResourceFiles(Map<ClientResourceFileExtension, ClientResourceFile> clientResourceFileMap);

    protected abstract void setupDeserializers(Map<ClientResourceFileExtension, ClientResourceDeserializer<TopLevelClientResource>> deserializerMap);

    protected abstract void setupSerializers(Map<ClientResourceFileExtension, ClientResourceSerializer<? extends TopLevelClientResource>> serializerMap);
}
