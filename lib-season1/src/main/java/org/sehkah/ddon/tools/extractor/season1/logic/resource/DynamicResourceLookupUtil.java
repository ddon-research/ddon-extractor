package org.sehkah.ddon.tools.extractor.season1.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common.GUIMessageDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.GUIMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFileExtension.rGUIMessage;

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
    private static final GUIMessageDeserializer GUI_MESSAGE_DESERIALIZER = new GUIMessageDeserializer(new ClientResourceFile(rGUIMessage, new FileHeader("GMD\0", 66306, 4), GUIMessageDeserializer.class));
    private static final Map<ResourceFileLookupType, TopLevelClientResource> DYNAMIC_RESOURCE_CACHE = HashMap.newHashMap(128);
    private static Path clientResourceFolder;

    private DynamicResourceLookupUtil() {

    }

    public static void initialize(Path clientRootFolder) {
        if (clientRootFolder != null) {
            DynamicResourceLookupUtil.clientResourceFolder = clientRootFolder.resolve("nativePC").resolve("rom");
        } else {
            log.warn("The client root folder is not configured, dynamic look ups will fail.");
        }
    }

    private static TopLevelClientResource loadResource(ClientResourceFileDeserializer deserializer, Path folderPath, String fileName) {
        byte[] input;
        try {
            input = Files.readAllBytes(folderPath.resolve(fileName));
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
        return deserializer.deserialize(new BinaryReader(input));
    }

    public static TopLevelClientResource getResource(ResourceFileLookupType resourceFileLookupType, ClientResourceFileDeserializer deserializer) {
        DYNAMIC_RESOURCE_CACHE.putIfAbsent(resourceFileLookupType, loadResource(deserializer, clientResourceFolder.resolve(resourceFileLookupType.getFolderPath()), resourceFileLookupType.getFileName()));
        return DYNAMIC_RESOURCE_CACHE.get(resourceFileLookupType);
    }

    public static String getMessage(ResourceFileLookupType resourceFileLookupType, long messageIndex) {
        TopLevelClientResource resource = getResource(resourceFileLookupType, GUI_MESSAGE_DESERIALIZER);
        if (resource == null) {
            return null;
        }
        return ((GUIMessage) DYNAMIC_RESOURCE_CACHE.putIfAbsent(resourceFileLookupType, resource)).getMessageByIndex(messageIndex);
    }

    public static String getMessageKey(ResourceFileLookupType resourceFileLookupType, long messageIndex) {
        TopLevelClientResource resource = getResource(resourceFileLookupType, GUI_MESSAGE_DESERIALIZER);
        if (resource == null) {
            return null;
        }
        return ((GUIMessage) DYNAMIC_RESOURCE_CACHE.putIfAbsent(resourceFileLookupType, resource)).getMessageKeyByIndex(messageIndex);
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
