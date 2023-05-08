package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;


public class DeserializerFactory {
    private final Logger logger = LogManager.getLogger(DeserializerFactory.class);

    public Deserializer forFilePath(Path filePath) {
        String sanitizedFilePath = filePath.toString().replace('\\', '/');
        ClientResourceFile clientResourceFile = ClientResourceFile.findByFileExtension(sanitizedFilePath);
        if (clientResourceFile == null) {
            logger.warn("The provided file path '{}' has an extension which is not supported yet.", filePath);
            return null;
        }
        Deserializer<?> instance = null;
        try {
            instance = clientResourceFile.deserializer.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            logger.error("Failed to instantiate deserializer.");
            if (logger.isDebugEnabled()) {
                logger.error(e);
            }
        }
        String extractionName = clientResourceFile.name();
        if (instance != null) {
            logger.info("The provided file path '{}' matches extraction type '{}'.", filePath, extractionName);
        } else {
            logger.info("Could not find a suitable implementation for extraction type '{}'.", extractionName);
        }
        return instance;
    }
}
