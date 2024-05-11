package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.l2c;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacket;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.l2c.L2CLoginRes;

@Slf4j
public class L2CLoginResDeserializer extends PacketFileDeserializer {
    public L2CLoginResDeserializer(GamePacket gamePacket) {
        super(gamePacket);
    }

    @Override
    protected Packet parse(FileReader fileReader) {
        long Error = fileReader.readUnsignedInteger();
        long Result = fileReader.readUnsignedInteger();
        String OnetimeToken = fileReader.readString(fileReader.readUnsignedShort());

        return new L2CLoginRes(
                Error,
                Result,
                OnetimeToken
        );
    }
}
