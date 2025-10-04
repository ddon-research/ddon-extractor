package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.MandraActionParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.MandraActionParamTable;

import java.nio.file.Path;

public class MandraActionParamTableDeserializer extends ClientResourceFileDeserializer<MandraActionParamTable> {
    private static MandraActionParam readMandraActionParam(BufferReader bufferReader) {
        return new MandraActionParam(
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected MandraActionParamTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new MandraActionParamTable(bufferReader.readArray(MandraActionParamTableDeserializer::readMandraActionParam));
    }
}
