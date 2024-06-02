package org.sehkah.ddon.tools.extractor.season3.packet.deserialization.l2c;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacket;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketFileBufferDeserializer;
import org.sehkah.ddon.tools.extractor.season3.packet.entity.l2c.L2CLoginRes;

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
