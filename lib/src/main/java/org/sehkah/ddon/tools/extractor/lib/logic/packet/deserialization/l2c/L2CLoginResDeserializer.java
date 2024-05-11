package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.l2c;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacketFile;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.l2c.L2CLoginRes;

public class L2CLoginResDeserializer extends PacketFileDeserializer {
    public L2CLoginResDeserializer(GamePacketFile gamePacketFile) {
        super(gamePacketFile);
    }

    @Override
    protected Packet parse(FileReader fileReader) {
        long Error = fileReader.readUnsignedInteger();
        long Result = fileReader.readUnsignedInteger();
        String OnetimeToken = fileReader.readString(fileReader.readUnsignedShort());
        long Unknown1 = fileReader.readUnsignedInteger();
        int Unknown2 = fileReader.readUnsignedShort();
        long Unknown3 = fileReader.readUnsignedInteger();
        long Unknown4 = fileReader.readUnsignedInteger();

        return new L2CLoginRes(
                Error,
                Result,
                OnetimeToken,
                Unknown1,
                Unknown2,
                Unknown3,
                Unknown4
        );
    }
}
