package org.sehkah.ddon.tools.extractor.lib.test.logic.resource.deserialization;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.Archive;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.ResourceInfo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptedArchiveDeserializerTest {

    @Test
    void deserializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/sg300000.arc";
        byte[] input = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));

        ClientResourceFileManager clientResourceFileManager = ClientResourceFileManager.get(null, SerializationFormat.json, false);
        FileReader fileReader = new BinaryFileReader(input);
        ClientResourceDeserializer<TopLevelClientResource> deserializer = clientResourceFileManager.getDeserializer(inputFile, fileReader);
        Archive deserialized = (Archive) deserializer.deserialize(fileReader);

        ResourceInfo goods_general = deserialized.getResource().get(0);
        assertEquals(7, deserialized.getResourceNum());
        assertEquals("etc\\goods_general", goods_general.Path());
        assertEquals("d51b16bb39ae54dadc280c48a63de956c307f468", DigestUtils.sha1Hex(deserialized.getResourceFiles().get("etc\\goods_general.spg_tbl")));
    }
}
