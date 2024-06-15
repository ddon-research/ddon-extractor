package org.sehkah.ddon.tools.extractor.lib.test.logic.resource.deserialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.api.util.DigestUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Archive;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ResourceInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ClientResourceFileManagerSeason3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptedArchiveDeserializerTest {

    @Test
    void deserializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/sg300000.arc";
        Path inputFilePath = Paths.get(getClass().getClassLoader().getResource(inputFile).toURI());
        byte[] input = Files.readAllBytes(inputFilePath);

        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, null, SerializationFormat.json, false);
        BufferReader bufferReader = new BinaryReader(input);
        Archive deserialized = clientResourceFileManager.deserialize(inputFilePath, bufferReader);

        ResourceInfo goods_general = deserialized.getResource().get(0);
        assertEquals(7, deserialized.getResourceNum());
        assertEquals("etc\\goods_general", goods_general.getPath());
        assertEquals("d51b16bb39ae54dadc280c48a63de956c307f468", DigestUtil.sha1Hex(deserialized.getResourceFiles().get("etc\\goods_general.spg_tbl")));
    }
}
