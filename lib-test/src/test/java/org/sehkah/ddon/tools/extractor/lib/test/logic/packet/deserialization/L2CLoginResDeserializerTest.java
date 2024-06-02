package org.sehkah.ddon.tools.extractor.lib.test.logic.packet.deserialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketBufferDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketManager;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.PacketManagerSeason3;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.l2c.L2CLoginRes;

import java.nio.ByteOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L2CLoginResDeserializerTest {
    @Test
    void testSeasonThreePacketDeserializes() {
        BufferReader input = new BinaryReader(new byte[]{
                //header
                0x00,
                0x00, 0x01,
                0x02,
                0x34,
                0x00, 0x00, 0x00, 0x00,
                //data
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x1F,
                0x38, 0x32, 0x36, 0x45, 0x30, 0x44, 0x30, 0x32, 0x38, 0x35, 0x45, 0x32, 0x34, 0x45, 0x37, 0x46, 0x42, 0x31, 0x46, 0x41, 0x32, 0x37, 0x33, 0x42, 0x45, 0x35, 0x36, 0x32, 0x34, 0x32, 0x37,
                0x34, 0x32, 0x00, 0x00, 0x00, 0x01, 0x00, 0x74, (byte) 0x93, (byte) 0x82, 0x00, 0x00, 0x00, 0x00
        }, ByteOrder.BIG_ENDIAN);

        PacketManager packetManager = new PacketManagerSeason3(null, SerializationFormat.json, false);
        PacketBufferDeserializer<Packet> deserializer = packetManager.getDeserializer(input);
        L2CLoginRes deserialized = (L2CLoginRes) deserializer.deserialize(input);

        assertEquals("826E0D0285E24E7FB1FA273BE562427", deserialized.getOnetimeToken());
    }
}
