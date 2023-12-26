package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.MyRoom.MyRoomActParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.MyRoom.MyRoomActParamTbl;

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
                fileReader.readUnsignedInteger(),
                fileReader.readSignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedShort(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected MyRoomActParamTbl parseClientResourceFile(FileReader fileReader) {
        return new MyRoomActParamTbl(fileReader.readArray(MyRoomActParamTblDeserializer::readMyRoomActParam));
    }
}
