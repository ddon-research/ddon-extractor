package org.sehkah.ddon.tools.extractor.lib.logic;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common.GUIMessageDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.season3.game_common.GUIMessageSerializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFileExtension.rGUIMessage;

/**
 * This is a util class which supports looking up message-related meta information via entity classes.
 * Must be initialized before usage.
 * <p>
 * TODO: Rework how deserializers are initialized/retrieved and use the client manager in some way
 * TODO: Replace existing manual message lookups with framework resources
 * Idea: Get rid of records and use class inheritance with the ability to look up file-relative resources?
 */
@Slf4j
public class DynamicResourceLookupUtil {
    private static final GUIMessageDeserializer GUI_MESSAGE_DESERIALIZER = new GUIMessageDeserializer(new ClientResourceFile(rGUIMessage, new FileHeader("GMD\0", 66306, 4), GUIMessageDeserializer.class, GUIMessageSerializer.class));
    private static final Map<ResourceFileLookupType, TopLevelClientResource> DYNAMIC_RESOURCE_CACHE = HashMap.newHashMap(128);
    private static Path clientResourceBasePath;

    private DynamicResourceLookupUtil() {

    }

    public static void initialize(Path clientResourceBasePath) {
        DynamicResourceLookupUtil.clientResourceBasePath = clientResourceBasePath;
    }

    private static TopLevelClientResource loadResource(ClientResourceFileDeserializer deserializer, Path folderPath, String fileName) {
        byte[] input;
        try {
            input = Files.readAllBytes(folderPath.resolve(fileName));
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
        return deserializer.deserialize(new BinaryFileReader(input));
    }

    public static TopLevelClientResource getResource(ResourceFileLookupType resourceFileLookupType, ClientResourceFileDeserializer deserializer) {
        DYNAMIC_RESOURCE_CACHE.putIfAbsent(resourceFileLookupType, loadResource(deserializer, clientResourceBasePath.resolve(resourceFileLookupType.folderPath), resourceFileLookupType.fileName));
        return DYNAMIC_RESOURCE_CACHE.get(resourceFileLookupType);
    }

    public static String getMessage(ResourceFileLookupType resourceFileLookupType, long messageIndex) {
        TopLevelClientResource resource = getResource(resourceFileLookupType, GUI_MESSAGE_DESERIALIZER);
        if (resource == null) {
            return null;
        }
        return ((GUIMessage) DYNAMIC_RESOURCE_CACHE.putIfAbsent(resourceFileLookupType, resource)).getMessageByIndex(messageIndex);
    }

    public static String getMessage(ResourceFileLookupType resourceFileLookupType, String key) {
        TopLevelClientResource resource = getResource(resourceFileLookupType, GUI_MESSAGE_DESERIALIZER);
        if (resource == null) {
            return null;
        }
        return ((GUIMessage) DYNAMIC_RESOURCE_CACHE.putIfAbsent(resourceFileLookupType, resource)).getMessageByKey(key);
    }

    public static String getFurnitureLayoutName(String key) {
        TopLevelClientResource resource = getResource(ResourceFileLookupType.FURNITURE_LAYOUT_NAME, GUI_MESSAGE_DESERIALIZER);
        String message = ((GUIMessage) DYNAMIC_RESOURCE_CACHE.putIfAbsent(ResourceFileLookupType.FURNITURE_LAYOUT_NAME, resource)).getMessageByKey(key);
        if (message == null) {
            resource = getResource(ResourceFileLookupType.CLAN_FURNITURE_LAYOUT_NAME, GUI_MESSAGE_DESERIALIZER);
            message = ((GUIMessage) DYNAMIC_RESOURCE_CACHE.putIfAbsent(ResourceFileLookupType.CLAN_FURNITURE_LAYOUT_NAME, resource)).getMessageByKey(key);
        }
        return message;
    }
}
