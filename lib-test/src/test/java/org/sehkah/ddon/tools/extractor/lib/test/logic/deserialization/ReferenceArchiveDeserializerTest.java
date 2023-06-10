package org.sehkah.ddon.tools.extractor.lib.test.logic.deserialization;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientSeason;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientSeasonType;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ReferenceArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.Archive;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.ArchiveS;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.ResourceInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.SerializationFormat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFileExtension.rArchive;

class ReferenceArchiveDeserializerTest {

    @Test
    void deserializeResourceSeasonThree() throws URISyntaxException, IOException {
        String inputFile = "season3/eye0_fedt_jntpreset.arc";
        byte[] input = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(inputFile).toURI()));

        ClientSeason clientSeasonThree = ClientSeason.get(ClientSeasonType.THREE, SerializationFormat.json, false);
        ClientResourceDeserializer<TopLevelClientResource> deserializer = clientSeasonThree.getDeserializer(inputFile);
        ArchiveS deserialized = (ArchiveS) deserializer.deserialize(new BinaryFileReader(input));

        assertEquals(1, deserialized.getResourceNum());
        assertEquals("rFacialEditJointPreset", deserialized.getResourceReference().get(0).TypeName());
    }
}
