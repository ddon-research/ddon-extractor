package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.RoomWearParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.RoomWearParamTbl;

public class RoomWearParamTblDeserializer extends ClientResourceFileDeserializer {

    public RoomWearParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static RoomWearParam readRoomWearParam(FileReader fileReader) {
        return new RoomWearParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected RoomWearParamTbl parseClientResourceFile(FileReader fileReader) {
        return new RoomWearParamTbl(fileReader.readArray(RoomWearParamTblDeserializer::readRoomWearParam));
    }
}
