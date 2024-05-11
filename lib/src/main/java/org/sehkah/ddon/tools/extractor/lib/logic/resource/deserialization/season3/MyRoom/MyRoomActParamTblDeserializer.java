package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.MyRoomActParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.MyRoomActParamTbl;

public class MyRoomActParamTblDeserializer extends ClientResourceFileDeserializer {

    public MyRoomActParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MyRoomActParam readMyRoomActParam(FileReader fileReader) {
        return new MyRoomActParam(
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected MyRoomActParamTbl parseClientResourceFile(FileReader fileReader) {
        return new MyRoomActParamTbl(fileReader.readArray(MyRoomActParamTblDeserializer::readMyRoomActParam));
    }
}
