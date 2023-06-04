package org.sehkah.ddon.tools.extractor.lib.test.logic.deserialization;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientSeason;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientSeasonType;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.Archive;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.ResourceInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.SerializationFormat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArchiveDeserializerTest {

    @Test
    void deserializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/sg300000.arc";
        byte[] input = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));

        ClientSeason clientSeasonThree = ClientSeason.get(ClientSeasonType.THREE, SerializationFormat.json, false);
        ClientResourceDeserializer<TopLevelClientResource> deserializer = clientSeasonThree.getDeserializer(inputFile);
        Archive deserialized = (Archive) deserializer.deserialize(new BinaryFileReader(input));

        ResourceInfo goods_general = deserialized.getResource().get(0);
        assertEquals(7, deserialized.getResourceNum());
        assertEquals("etc\\goods_general", goods_general.Path());
        assertEquals("d51b16bb39ae54dadc280c48a63de956c307f468", DigestUtils.sha1Hex(deserialized.getResourceFiles().get("etc\\goods_general.spg_tbl")));
    }
}
