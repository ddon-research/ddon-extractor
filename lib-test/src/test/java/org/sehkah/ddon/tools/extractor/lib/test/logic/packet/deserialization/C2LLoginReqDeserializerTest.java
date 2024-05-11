package org.sehkah.ddon.tools.extractor.lib.test.logic.packet.deserialization;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketManager;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.c2l.C2LLoginReq;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.c2l.meta.PlatformType;

import java.nio.ByteOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class C2LLoginReqDeserializerTest {
    @Test
    void testSeasonThreePacketDeserializes() {
        FileReader input = new BinaryFileReader(new byte[]{
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

        PacketManager packetManager = PacketManager.get();
        PacketDeserializer<Packet> deserializer = packetManager.getDeserializer(input);
        C2LLoginReq deserialized = (C2LLoginReq) deserializer.deserialize(input);

        assertEquals("bd0ax76btfcwwcwo00gg", deserialized.getOneTimeToken());
        assertEquals(PlatformType.PLATFORM_TYPE_PC, deserialized.getPlatformTypeName());
    }
}
