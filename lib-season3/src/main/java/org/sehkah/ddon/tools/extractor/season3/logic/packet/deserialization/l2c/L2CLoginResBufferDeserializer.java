package org.sehkah.ddon.tools.extractor.season3.logic.packet.deserialization.l2c;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.packet.GamePacket;
import org.sehkah.ddon.tools.extractor.api.logic.packet.deserialization.PacketFileBufferDeserializer;
import org.sehkah.ddon.tools.extractor.api.packet.Packet;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.l2c.L2CLoginRes;

@Slf4j
public class L2CLoginResBufferDeserializer extends PacketFileBufferDeserializer {
    public L2CLoginResBufferDeserializer(GamePacket gamePacket) {
        super(gamePacket);
    }

    @Override
    protected Packet parse(BufferReader bufferReader) {
        long Error = bufferReader.readUnsignedInteger();
        long Result = bufferReader.readUnsignedInteger();
        String OnetimeToken = bufferReader.readString(bufferReader.readUnsignedShort());

        return new L2CLoginRes(
                Error,
                Result,
                OnetimeToken
        );
    }
}
