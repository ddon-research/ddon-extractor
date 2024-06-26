package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.EventParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.EventParamList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.OmList;

import java.nio.file.Path;

public class EventParamDeserializer extends ClientResourceFileDeserializer<EventParamList> {


    private static OmList readOmList(BufferReader bufferReader) {
        return new OmList(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort()
        );
    }

    private static EventParam readEventParam(BufferReader bufferReader) {
        return new EventParam(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readFloat(),
                bufferReader.readArray(EventParamDeserializer::readOmList)
        );
    }

    @Override
    protected EventParamList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EventParamList(bufferReader.readArray(EventParamDeserializer::readEventParam));
    }
}
