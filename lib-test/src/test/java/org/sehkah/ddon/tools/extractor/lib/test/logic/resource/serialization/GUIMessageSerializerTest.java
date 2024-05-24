package org.sehkah.ddon.tools.extractor.lib.test.logic.resource.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.GenericStringSerializer;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization.ClientResourceSerializer;

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

        ClientResourceFileManager clientResourceFileManager = ClientResourceFileManager.get(null, SerializationFormat.json, false);
        GUIMessage deserialized = (GUIMessage) clientResourceFileManager.getStringSerializer().deserialize(input);
        ClientResourceSerializer<TopLevelClientResource> serializer = clientResourceFileManager.getSerializer(inputFile, deserialized);
        byte[] bytes = serializer.serializeResource(deserialized);

        assertEquals("b3fe63563340b8b070661b3b9a824acdffa971c2", DigestUtils.sha1Hex(bytes));
    }

    @Test
    void serializeResourceSeasonThreeEnglish() throws URISyntaxException, IOException {
        String inputFile = "season3/ui/uGUIOption/ui/00_message/ui/option_res_win.gmd.json";
        String input = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));
        String inputTranslationFile = "season3/ui/uGUIOption/ui/00_message/ui/option_res_win.en.yaml";
        String inputTranslation = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputTranslationFile).toURI()));

        ClientResourceFileManager clientResourceFileManager = ClientResourceFileManager.get(null, SerializationFormat.json, false);
        GUIMessage deserialized = (GUIMessage) clientResourceFileManager.getStringSerializer().deserialize(input);
        ClientResourceSerializer<TopLevelClientResource> serializer = clientResourceFileManager.getSerializer(inputFile, deserialized);
        serializer.setModdingAllowed(true);
        GenericStringSerializer genericStringSerializer = GenericStringSerializer.get(SerializationFormat.yaml);
        deserialized.updateMessages(genericStringSerializer.deserialize(inputTranslation, new TypeReference<>() {
        }));
        byte[] bytes = serializer.serializeResource(deserialized);

        assertEquals("67f549b487d0bac721a9d58bd2ba4b7bd241c25e", DigestUtils.sha1Hex(bytes));
    }
}
