package org.sehkah.ddon.tools.extractor.lib.test.logic.packet.deserialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketBufferDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketManager;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.PacketManagerSeason3;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2l.C2LLoginReq;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2l.meta.PlatformType;

import java.nio.ByteOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class C2LLoginReqDeserializerTest {
    @Test
    void testSeasonThreePacketDeserializes() {
        BufferReader input = new BinaryReader(new byte[]{
                //header
                0x00,
                0x00, 0x01,
                0x01,
                0x00,
                0x00, 0x00, 0x00, 0x01,
                //data
                0x00, 0x14,
                0x62, 0x64, 0x30, 0x61, 0x78, 0x37, 0x36, 0x62, 0x74, 0x66, 0x63, 0x77, 0x77, 0x63, 0x77, 0x6F, 0x30, 0x30, 0x67, 0x67,
                0x01
        }, ByteOrder.BIG_ENDIAN);

        PacketManager packetManager = new PacketManagerSeason3(null, SerializationFormat.json, true);
        PacketBufferDeserializer<Packet> deserializer = packetManager.getDeserializer(input);
        C2LLoginReq deserialized = (C2LLoginReq) deserializer.deserialize(input);
        Serializer<Packet> stringSerializer = packetManager.getStringSerializer();
        String serialized = stringSerializer.serialize(deserialized);

        assertEquals("bd0ax76btfcwwcwo00gg", deserialized.getOneTimeToken());
        assertEquals(PlatformType.PLATFORM_TYPE_PC, deserialized.getPlatformTypeName());
        assertTrue(serialized.contains("PLATFORM_TYPE_PC"));
    }
}
