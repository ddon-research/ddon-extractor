package org.sehkah.ddon.tools.extractor.season3.logic.packet.deserialization.c2l;

import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.packet.GamePacket;
import org.sehkah.ddon.tools.extractor.api.logic.packet.deserialization.PacketFileBufferDeserializer;
import org.sehkah.ddon.tools.extractor.api.packet.Packet;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2l.C2LLoginReq;

public class C2LLoginReqBufferDeserializer extends PacketFileBufferDeserializer {
    public C2LLoginReqBufferDeserializer(GamePacket gamePacket) {
        super(gamePacket);
    }

    @Override
    protected Packet parse(BufferReader bufferReader) {

        int strLen = bufferReader.readUnsignedShort();
        String oneTimeToken = bufferReader.readString(strLen);
        int platform = bufferReader.readUnsignedByte();

        return new C2LLoginReq(
                oneTimeToken,
                platform
        );
    }
}
