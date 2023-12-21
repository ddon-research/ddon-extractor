package org.sehkah.ddon.tools.extractor.lib.test.logic.deserialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.ArchiveS;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.SerializationFormat;

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

        ClientResourceFileManager clientResourceFileManager = ClientResourceFileManager.get(SerializationFormat.json, false);
        FileReader fileReader = new BinaryFileReader(input);
        ClientResourceDeserializer<TopLevelClientResource> deserializer = clientResourceFileManager.getDeserializer(inputFile, fileReader);
        ArchiveS deserialized = (ArchiveS) deserializer.deserialize(fileReader);

        assertEquals(1, deserialized.getResourceNum());
        assertEquals("rFacialEditJointPreset", deserialized.getResourceReference().get(0).TypeName());
    }
}
