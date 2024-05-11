package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.MyRoom.MyRoomActParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.MyRoom.MyRoomActParamTbl;

public class MyRoomActParamTblDeserializer extends ClientResourceFileDeserializer {

    public MyRoomActParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MyRoomActParam readMyRoomActParam(BufferReader bufferReader) {
        return new MyRoomActParam(
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected MyRoomActParamTbl parseClientResourceFile(BufferReader bufferReader) {
        return new MyRoomActParamTbl(bufferReader.readArray(MyRoomActParamTblDeserializer::readMyRoomActParam));
    }
}
