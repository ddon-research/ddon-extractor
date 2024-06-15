package org.sehkah.ddon.tools.extractor.lib.test.logic.resource.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.ClientResourceSerializer;
import org.sehkah.ddon.tools.extractor.api.serialization.GenericStringSerializer;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.api.util.DigestUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ClientResourceFileManagerSeason3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GUIMessageSerializerTest {

    @Test
    void serializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/ui/uGUIOption/ui/00_message/ui/option_res_win.gmd.json";
        String input = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));

        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, null, SerializationFormat.json, false);
        GUIMessage deserialized = (GUIMessage) clientResourceFileManager.getStringSerializer().deserialize(input);
        ClientResourceSerializer<Resource> serializer = clientResourceFileManager.getSerializer(inputFile, deserialized);
        byte[] bytes = serializer.serializeResource(deserialized);

        assertEquals("2d77ba98862a92d3eb5f12167cd058e89b29e52a", DigestUtil.sha1Hex(bytes));
    }

    @Test
    void serializeResourceSeasonThreeEnglish() throws URISyntaxException, IOException {
        String inputFile = "season3/ui/uGUIOption/ui/00_message/ui/option_res_win.gmd.json";
        String input = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));
        String inputTranslationFile = "season3/ui/uGUIOption/ui/00_message/ui/option_res_win.en.yaml";
        String inputTranslation = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputTranslationFile).toURI()));

        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, null, SerializationFormat.json, false);
        GUIMessage deserialized = (GUIMessage) clientResourceFileManager.getStringSerializer().deserialize(input);
        ClientResourceSerializer<Resource> serializer = clientResourceFileManager.getSerializer(inputFile, deserialized);
        GenericStringSerializer genericStringSerializer = GenericStringSerializer.get(SerializationFormat.yaml);
        deserialized.updateMessages(genericStringSerializer.deserialize(inputTranslation, new TypeReference<>() {
        }));
        byte[] bytes = serializer.serializeResource(deserialized);

        assertEquals("7175255b5e9ea79f39267d7594956f8b55f357ce", DigestUtil.sha1Hex(bytes));
    }
}
