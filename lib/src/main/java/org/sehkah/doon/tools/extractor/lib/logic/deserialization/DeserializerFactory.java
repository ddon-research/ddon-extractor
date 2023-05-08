package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class DeserializerFactory {
    private static final Map<String, Deserializer<?>> DESERIALIZER_MAP = new HashMap<>(64);
    private final Logger logger = LogManager.getLogger(DeserializerFactory.class);

    // TODO get rid of reflection
    public Deserializer forFile(String fileName) {
        String fileNameExtension = fileName.substring(fileName.indexOf('.'));
        ClientResourceFile clientResourceFile = ClientResourceFile.findByFileExtension(fileNameExtension);
        if (clientResourceFile == null) {
            logger.warn("The provided file '{}' has an extension which is not supported yet.", fileName);
            return null;
        }
        Deserializer<?> instance = null;
        if (DESERIALIZER_MAP.containsKey(fileNameExtension)) {
            instance = DESERIALIZER_MAP.get(fileNameExtension);
        } else {
            try {
                instance = clientResourceFile.deserializer.getConstructor().newInstance();
                DESERIALIZER_MAP.put(fileNameExtension, instance);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                logger.error("Failed to instantiate deserializer.");
                if (logger.isDebugEnabled()) {
                    logger.error(e);
                }
            }
        }
        String extractionName = clientResourceFile.name();
        if (instance != null) {
            logger.info("The provided file '{}' matches extraction type '{}'.", fileName, extractionName);
        } else {
            logger.info("Could not find a suitable implementation for extraction type '{}'.", extractionName);
        }
        return instance;
    }
}
