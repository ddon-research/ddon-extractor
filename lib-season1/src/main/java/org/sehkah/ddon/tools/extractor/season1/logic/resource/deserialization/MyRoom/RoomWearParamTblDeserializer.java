package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.MyRoom.RoomWearParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.MyRoom.RoomWearParamTbl;

public class RoomWearParamTblDeserializer extends ClientResourceFileDeserializer {

    public RoomWearParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static RoomWearParam readRoomWearParam(BufferReader bufferReader) {
        return new RoomWearParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected RoomWearParamTbl parseClientResourceFile(BufferReader bufferReader) {
        return new RoomWearParamTbl(bufferReader.readArray(RoomWearParamTblDeserializer::readRoomWearParam));
    }
}
