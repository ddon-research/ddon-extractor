package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;


public class DeserializerFactory {
    private final Logger logger = LogManager.getLogger(DeserializerFactory.class);

    public Deserializer forFilePath(FileReader fileReader, Path filePath) {
        String sanitizedFilePath = filePath.toString().replace('\\', '/');
        ExtensionMap extensionMap = ExtensionMap.findByFileExtension(sanitizedFilePath);
        if (extensionMap == ExtensionMap.UNSUPPORTED) {
            logger.warn("The provided file path '{}' has an unknown file extension.", filePath);
            return null;
        }
        if (extensionMap.deserializer == null) {
            logger.warn("The provided file path '{}' has a known file extension which is not supported yet.", filePath);
            return null;
        }
        Deserializer instance = null;
        try {
            instance = extensionMap.deserializer.getConstructor(FileReader.class).newInstance(fileReader);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            logger.error("Failed to instantiate deserializer.");
            if (logger.isDebugEnabled()) {
                logger.error(e);
            }
        }
        String extractionName = extensionMap.name();
        if (instance != null) {
            logger.info("The provided file path '{}' matches extraction type '{}'.", filePath, extractionName);
        } else {
            logger.info("Could not find a suitable implementation for extraction type '{}'.", extractionName);
        }
        return instance;
    }
}
