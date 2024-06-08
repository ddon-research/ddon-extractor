package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ChildRegionStatusParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ChildRegionStatusParamTable;

import java.nio.file.Path;

public class ChildRegionStatusParamDeserializer extends ClientResourceFileDeserializer<ChildRegionStatusParamTable> {


    protected static ChildRegionStatusParam readChildRegionStatusParam(BufferReader bufferReader) {
        return new ChildRegionStatusParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(2, BufferReader::readUnsignedInteger),
                bufferReader.readFixedLengthArray(4, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFixedLengthArray(4, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFixedLengthArray(4, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(4, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(4, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readFixedLengthArray(4, BufferReader::readUnsignedInteger),
                bufferReader.readFixedLengthArray(6, BufferReader::readBoolean)
        );
    }

    @Override
    protected ChildRegionStatusParamTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ChildRegionStatusParamTable(bufferReader.readArray(ChildRegionStatusParamDeserializer::readChildRegionStatusParam));
    }
}
