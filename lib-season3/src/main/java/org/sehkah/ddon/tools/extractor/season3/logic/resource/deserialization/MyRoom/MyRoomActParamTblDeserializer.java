package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.MyRoomActParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.MyRoomActParamTbl;

public class MyRoomActParamTblDeserializer extends ClientResourceFileDeserializer {


    private static MyRoomActParam readMyRoomActParam(BufferReader bufferReader) {
        return new MyRoomActParam(
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected MyRoomActParamTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new MyRoomActParamTbl(bufferReader.readArray(MyRoomActParamTblDeserializer::readMyRoomActParam));
    }
}
