package org.sehkah.ddon.tools.extractor.lib.test.logic.resource.deserialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ReferenceArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ArchiveS;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ClientResourceFileManagerSeason3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFileExtension.rArchive;

class ReferenceArchiveDeserializerTest {

    @Test
    void deserializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/eye0_fedt_jntpreset.arc";
        byte[] input = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));

        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, SerializationFormat.json, false);
        BufferReader bufferReader = new BinaryReader(input);
        ClientResourceDeserializer<ArchiveS> deserializer = clientResourceFileManager.getDeserializer(inputFile, bufferReader);
        ClientResourceFile<ArchiveS> archiveClientResourceFile = new ClientResourceFile<>(rArchive, new FileHeader("ARCS", 7, 2), new ReferenceArchiveDeserializer());
        ArchiveS deserialized = deserializer.deserialize(archiveClientResourceFile, bufferReader, null);

        assertEquals(1, deserialized.getResourceNum());
        assertEquals("rFacialEditJointPreset", deserialized.getResourceReference().getFirst().getTypeName());
    }
}
