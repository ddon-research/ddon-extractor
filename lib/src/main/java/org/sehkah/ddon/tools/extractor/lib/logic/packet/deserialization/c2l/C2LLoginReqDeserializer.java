package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.c2l;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacket;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.c2l.C2LLoginReq;

public class C2LLoginReqDeserializer extends PacketFileDeserializer {
    public C2LLoginReqDeserializer(GamePacket gamePacket) {
        super(gamePacket);
    }

    @Override
    protected Packet parse(FileReader fileReader) {

        int strLen = fileReader.readUnsignedShort();
        String oneTimeToken = fileReader.readString(strLen);
        int platform = fileReader.readUnsignedByte();

        return new C2LLoginReq(
                oneTimeToken,
                platform
        );
    }
}
