package org.sehkah.ddon.tools.extractor.lib.logic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.Deserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.StringSerializer;

import java.util.EnumMap;
import java.util.Map;

@Slf4j
public abstract class ClientSeason {
    protected final Map<ClientResourceFileExtension, Deserializer<TopLevelClientResource>> deserializerMap;
    protected final Map<ClientResourceFileExtension, ClientResourceFile> clientResourceFileMap;
    @Getter
    private final Serializer<TopLevelClientResource> stringSerializer;

    protected ClientSeason(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        deserializerMap = new EnumMap<>(ClientResourceFileExtension.class);
        clientResourceFileMap = new EnumMap<>(ClientResourceFileExtension.class);
        stringSerializer = StringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
    }

    public static ClientSeason get(ClientSeasonType clientSeasonType, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        return switch (clientSeasonType) {
            case TWO -> new ClientSeasonTwo(preferredSerializationType, shouldSerializeMetaInformation);
            case THREE -> new ClientSeasonThree(preferredSerializationType, shouldSerializeMetaInformation);
        };
    }

    public Deserializer<TopLevelClientResource> getDeserializer(String fileName) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));
        Deserializer<TopLevelClientResource> deserializer = deserializerMap.getOrDefault(ClientResourceFileExtension.of(fileNameExtension), null);
        if (deserializer != null) {
            log.debug("File extension '{}' matches deserializer {}.", fileNameExtension, deserializer.getClass().getSimpleName());
        } else {
            log.debug("No deserializer found for file extension '{}'.", fileNameExtension);
        }
        return deserializer;
    }
}
