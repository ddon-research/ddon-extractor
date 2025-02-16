package org.sehkah.ddon.tools.extractor.lib.test.logic.resource.serialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.ClientResourceSerializer;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.api.util.DigestUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DirectDrawSurface;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.Texture;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ClientResourceFileManagerSeason3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextureSerializerTest {

    @Test
    void serialize_B4G4R4A4_UNORM() throws URISyntaxException, IOException {
        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, null, SerializationFormat.json, false);

        String inputJsonFile = "season3/fontjpn00_NOMIP.tex.json";
        String inputJson = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputJsonFile).toURI()));
        Resource deserializedTextureFromJson = clientResourceFileManager.getStringSerializer().deserialize(inputJson);
        ClientResourceSerializer<Resource> serializer = clientResourceFileManager.getSerializer(inputJsonFile, deserializedTextureFromJson);
        byte[] bytes = serializer.serializeResource(deserializedTextureFromJson);
//        Files.write(Paths.get("fontjpn00_NOMIP.tex"), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals("5c2c955e7bd7fb9742543f3d1959bc9a74149eec", DigestUtil.sha1Hex(bytes));

        String inputBinaryFile = "season3/fontjpn00_NOMIP.tex";
        Path filePath = Paths.get(getClass().getClassLoader().getResource(inputBinaryFile).toURI());
        BufferReader bufferReader = new BinaryReader(filePath);
        Texture deserializedEntityFromBinary = clientResourceFileManager.deserialize(filePath, bufferReader);
        String serializedJsonFromEntity = clientResourceFileManager.getStringSerializer().serialize(deserializedEntityFromBinary);
//        Files.writeString(Paths.get("fontjpn00_NOMIP.tex.json"), serializedJsonFromEntity, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals(serializedJsonFromEntity, inputJson);

        String ddsFile = "fontjpn00_NOMIP.tex.dds";
        DirectDrawSurface dds = deserializedEntityFromBinary.toDirectDrawSurface();
        byte[] bytesDds = clientResourceFileManager.getSerializer(ddsFile, dds).serializeResource(dds);
//        Files.write(Paths.get(ddsFile), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @Test
    void serialize_BC1_UNORM_SRGB() throws URISyntaxException, IOException {
        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, null, SerializationFormat.json, false);

        String inputJsonFile = "season3/om500000_01_BM.tex.json";
        String inputJson = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputJsonFile).toURI()));
        Resource deserializedTextureFromJson = clientResourceFileManager.getStringSerializer().deserialize(inputJson);
        ClientResourceSerializer<Resource> serializer = clientResourceFileManager.getSerializer(inputJsonFile, deserializedTextureFromJson);
        byte[] bytes = serializer.serializeResource(deserializedTextureFromJson);
//        Files.write(Paths.get("om500000_01_BM.tex"), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals("27d40e84f1d1a3e5500039aed2785c10b9a5ba02", DigestUtil.sha1Hex(bytes));

        String inputBinaryFile = "season3/om500000_01_BM.tex";
        Path filePath = Paths.get(getClass().getClassLoader().getResource(inputBinaryFile).toURI());
        BufferReader bufferReader = new BinaryReader(filePath);
        Texture deserializedEntityFromBinary = clientResourceFileManager.deserialize(filePath, bufferReader);
        String serializedJsonFromEntity = clientResourceFileManager.getStringSerializer().serialize(deserializedEntityFromBinary);
//        Files.writeString(Paths.get("om500000_01_BM.tex.json"), serializedJsonFromEntity, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals(serializedJsonFromEntity, inputJson);

        String ddsFile = "om500000_01_BM.tex.dds";
        DirectDrawSurface dds = deserializedEntityFromBinary.toDirectDrawSurface();
        byte[] bytesDds = clientResourceFileManager.getSerializer(ddsFile, dds).serializeResource(dds);
//        Files.write(Paths.get(ddsFile), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @Test
    void serialize_FORMAT_BCX_NM2() throws URISyntaxException, IOException {
        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, null, SerializationFormat.json, false);

        String inputJsonFile = "season3/om500000_01_NM.tex.json";
        String inputJson = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputJsonFile).toURI()));
        Resource deserializedTextureFromJson = clientResourceFileManager.getStringSerializer().deserialize(inputJson);
        ClientResourceSerializer<Resource> serializer = clientResourceFileManager.getSerializer(inputJsonFile, deserializedTextureFromJson);
        byte[] bytes = serializer.serializeResource(deserializedTextureFromJson);
//        Files.write(Paths.get("om500000_01_NM.tex"), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals("3ac7c4b60241623616174cbfd4dcdfef7787333c", DigestUtil.sha1Hex(bytes));

        String inputBinaryFile = "season3/om500000_01_NM.tex";
        Path filePath = Paths.get(getClass().getClassLoader().getResource(inputBinaryFile).toURI());
        BufferReader bufferReader = new BinaryReader(filePath);
        Texture deserializedEntityFromBinary = clientResourceFileManager.deserialize(filePath, bufferReader);
        String serializedJsonFromEntity = clientResourceFileManager.getStringSerializer().serialize(deserializedEntityFromBinary);
//        Files.writeString(Paths.get("om500000_01_NM.tex.json"), serializedJsonFromEntity, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals(serializedJsonFromEntity, inputJson);

        String ddsFile = "om500000_01_NM.tex.dds";
        DirectDrawSurface dds = deserializedEntityFromBinary.toDirectDrawSurface();
        byte[] bytesDds = clientResourceFileManager.getSerializer(ddsFile, dds).serializeResource(dds);
//        Files.write(Paths.get(ddsFile), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @Test
    void serialize_CUBE_MAP() throws URISyntaxException, IOException {
        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, null, SerializationFormat.json, false);

        String inputJsonFile = "season3/DDBaseCube4_CM.tex.json";
        String inputJson = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputJsonFile).toURI()));
        Resource deserializedTextureFromJson = clientResourceFileManager.getStringSerializer().deserialize(inputJson);
        ClientResourceSerializer<Resource> serializer = clientResourceFileManager.getSerializer(inputJsonFile, deserializedTextureFromJson);
        byte[] bytes = serializer.serializeResource(deserializedTextureFromJson);
//        Files.write(Paths.get("DDBaseCube4_CM.tex"), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals("6f8fb44835ef1c3309ca3b2300a6e73fd58e9063", DigestUtil.sha1Hex(bytes));

        String inputBinaryFile = "season3/DDBaseCube4_CM.tex";
        Path filePath = Paths.get(getClass().getClassLoader().getResource(inputBinaryFile).toURI());
        BufferReader bufferReader = new BinaryReader(filePath);
        Texture deserializedEntityFromBinary = clientResourceFileManager.deserialize(filePath, bufferReader);
        String serializedJsonFromEntity = clientResourceFileManager.getStringSerializer().serialize(deserializedEntityFromBinary);
//        Files.writeString(Paths.get("DDBaseCube4_CM.tex.json"), serializedJsonFromEntity, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals(serializedJsonFromEntity, inputJson);

        String ddsFile = "DDBaseCube4_CM.tex.dds";
        DirectDrawSurface dds = deserializedEntityFromBinary.toDirectDrawSurface();
        byte[] bytesDds = clientResourceFileManager.getSerializer(ddsFile, dds).serializeResource(dds);
//        Files.write(Paths.get(ddsFile), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @Test
    void serialize_BCX_GRAYSCALE() throws URISyntaxException, IOException {
        ClientResourceFileManager clientResourceFileManager = new ClientResourceFileManagerSeason3(null, null, SerializationFormat.json, false);

        String inputJsonFile = "season3/em021000_burn_e_MM.tex.json";
        String inputJson = Files.readString(Paths.get(getClass().getClassLoader().getResource(inputJsonFile).toURI()));
        Resource deserializedTextureFromJson = clientResourceFileManager.getStringSerializer().deserialize(inputJson);
        ClientResourceSerializer<Resource> serializer = clientResourceFileManager.getSerializer(inputJsonFile, deserializedTextureFromJson);
        byte[] bytes = serializer.serializeResource(deserializedTextureFromJson);
//        Files.write(Paths.get("em021000_burn_e_MM.tex"), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals("de842af412a813832207e5baa748635c61de2d0c", DigestUtil.sha1Hex(bytes));

        String inputBinaryFile = "season3/em021000_burn_e_MM.tex";
        Path filePath = Paths.get(getClass().getClassLoader().getResource(inputBinaryFile).toURI());
        BufferReader bufferReader = new BinaryReader(filePath);
        Texture deserializedEntityFromBinary = clientResourceFileManager.deserialize(filePath, bufferReader);
        String serializedJsonFromEntity = clientResourceFileManager.getStringSerializer().serialize(deserializedEntityFromBinary);
//        Files.writeString(Paths.get("em021000_burn_e_MM.tex.json"), serializedJsonFromEntity, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        assertEquals(serializedJsonFromEntity, inputJson);

        String ddsFile = "em021000_burn_e_MM.tex.dds";
        DirectDrawSurface dds = deserializedEntityFromBinary.toDirectDrawSurface();
        byte[] bytesDds = clientResourceFileManager.getSerializer(ddsFile, dds).serializeResource(dds);
//        Files.write(Paths.get(ddsFile), bytesDds, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
