package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.ChildRegionStatusParam;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.ChildRegionStatusParamTable;

public class ChildRegionStatusParamDeserializer extends ClientResourceFileDeserializer {
    public ChildRegionStatusParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
                bufferReader.readFixedLengthArray(33, BufferReader::readFloat),
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
    protected ChildRegionStatusParamTable parseClientResourceFile(BufferReader bufferReader) {
        return new ChildRegionStatusParamTable(bufferReader.readArray(ChildRegionStatusParamDeserializer::readChildRegionStatusParam));
    }
}
