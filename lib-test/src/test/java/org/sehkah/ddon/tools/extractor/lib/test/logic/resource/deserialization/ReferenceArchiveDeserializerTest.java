package org.sehkah.ddon.tools.extractor.lib.test.logic.resource.deserialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.ArchiveS;
import org.sehkah.ddon.tools.extractor.season3.resource.ClientResourceFileManagerSeason3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReferenceArchiveDeserializerTest {

    @Test
    void deserializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/eye0_fedt_jntpreset.arc";
        byte[] input = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));

        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, SerializationFormat.json, false);
        BufferReader bufferReader = new BinaryReader(input);
        ClientResourceDeserializer<TopLevelClientResource> deserializer = clientResourceFileManager.getDeserializer(inputFile, bufferReader);
        ArchiveS deserialized = (ArchiveS) deserializer.deserialize(bufferReader);

        assertEquals(1, deserialized.getResourceNum());
        assertEquals("rFacialEditJointPreset", deserialized.getResourceReference().get(0).TypeName());
    }
}
