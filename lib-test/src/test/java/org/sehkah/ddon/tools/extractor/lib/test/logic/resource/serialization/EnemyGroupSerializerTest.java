package org.sehkah.ddon.tools.extractor.lib.test.logic.resource.serialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.common.util.DigestUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization.ClientResourceSerializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ClientResourceFileManagerSeason3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

class EnemyGroupSerializerTest {

    @Test
    void serializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/game_common/param/enemy_group.emg.json";
        String input = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));

        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, SerializationFormat.json, false);

        TopLevelClientResource deserialized = clientResourceFileManager.getStringSerializer().deserialize(input);
        ClientResourceSerializer<TopLevelClientResource> serializer = clientResourceFileManager.getSerializer(inputFile, deserialized);
        byte[] bytes = serializer.serializeResource(deserialized);

        assertEquals("bdb9b87f3126706640f823e9d85c88338c7c99f1", DigestUtil.sha1Hex(bytes));
    }
}
