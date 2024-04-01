package org.sehkah.ddon.tools.extractor.lib.logic;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
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
 */
@Slf4j
public class MessageLookupUtil {
    private static final GUIMessageDeserializer guiMessageDeserializer = new GUIMessageDeserializer(new ClientResourceFile(rGUIMessage, new FileHeader("GMD\0", 66306, 4), GUIMessageDeserializer.class, GUIMessageSerializer.class));
    private static final Map<MessageFileLookupType, GUIMessage> MESSAGE_LOOKUP_TABLE = HashMap.newHashMap(128);
    private static Path clientResourceBasePath;

    private MessageLookupUtil() {

    }

    public static void initialize(Path clientResourceBasePath) {
        MessageLookupUtil.clientResourceBasePath = clientResourceBasePath;
    }

    private static GUIMessage loadMessage(Path folderPath, String fileName) {
        byte[] input;
        try {
            input = Files.readAllBytes(folderPath.resolve(fileName + ".gmd"));
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
        return (GUIMessage) guiMessageDeserializer.deserialize(new BinaryFileReader(input));
    }

    public static String getMessage(MessageFileLookupType messageFileLookupType, long messageIndex) {
        MESSAGE_LOOKUP_TABLE.putIfAbsent(messageFileLookupType, loadMessage(clientResourceBasePath.resolve(messageFileLookupType.folderPath), messageFileLookupType.fileName));
        return MESSAGE_LOOKUP_TABLE.get(messageFileLookupType).getMessageByIndex(messageIndex);
    }

    public static String getMessage(MessageFileLookupType messageFileLookupType, String key) {
        MESSAGE_LOOKUP_TABLE.putIfAbsent(messageFileLookupType, loadMessage(clientResourceBasePath.resolve(messageFileLookupType.folderPath), messageFileLookupType.fileName));
        return MESSAGE_LOOKUP_TABLE.get(messageFileLookupType).getMessageByKey(key);
    }
}
