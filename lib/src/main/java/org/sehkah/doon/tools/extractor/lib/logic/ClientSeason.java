package org.sehkah.doon.tools.extractor.lib.logic;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.doon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;
import java.util.Map;

public abstract class ClientSeason {
    private static final Logger logger = LoggerFactory.getLogger(ClientSeason.class);
    public final Map<ClientResourceFileExtension, Deserializer<TopLevelClientResource>> deserializerMap;
    public final Map<ClientResourceFileExtension, ClientResourceFile> clientResourceFileMap;

    protected ClientSeason() {
        deserializerMap = new EnumMap<>(ClientResourceFileExtension.class);
        clientResourceFileMap = new EnumMap<>(ClientResourceFileExtension.class);
    }

    public static ClientSeason get(ClientSeasonType clientSeasonType) {
        return switch (clientSeasonType) {
            case TWO -> new ClientSeasonTwo();
            case THREE -> new ClientSeasonThree();
            default -> throw new TechnicalException("Unknown season!");
        };
    }

    public Deserializer<TopLevelClientResource> getDeserializer(String fileName) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));
        Deserializer<TopLevelClientResource> deserializer = deserializerMap.getOrDefault(ClientResourceFileExtension.of(fileNameExtension), null);
        if (deserializer != null) {
            logger.debug("File extension '{}' matches deserializer {}.", fileNameExtension, deserializer.getClass().getSimpleName());
        } else {
            logger.debug("No deserializer found for file extension '{}'.", fileNameExtension);
        }
        return deserializer;
    }
}
