package org.sehkah.ddon.tools.extractor.lib.test.logic.serialization;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientSeason;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientSeasonType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.ClientResourceSerializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.SerializationFormat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyGroupSerializerTest {

    @Test
    void serializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/game_common/param/enemy_group.emg.json";
        String input = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));

        ClientSeason clientSeasonThree = ClientSeason.get(ClientSeasonType.THREE, SerializationFormat.json, false);
        ClientResourceSerializer<TopLevelClientResource> serializer = clientSeasonThree.getSerializer(inputFile);
        TopLevelClientResource deserialized = clientSeasonThree.getStringSerializer().deserialize(input);
        byte[] bytes = serializer.serializeResource(deserialized);

        assertEquals("bdb9b87f3126706640f823e9d85c88338c7c99f1", DigestUtils.sha1Hex(bytes));
    }
}
