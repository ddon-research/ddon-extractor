package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmWarpParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmWarpParamTable;

public class EmWarpParamTableDeserializer extends ClientResourceFileDeserializer<EmWarpParamTable> {


    private static EmWarpParam readEmWarpParam(BufferReader bufferReader) {
        return new EmWarpParam(
                bufferReader.readFixedLengthArray(3, BufferReader::readFloat),
                bufferReader.readFloat(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EmWarpParamTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmWarpParamTable(bufferReader.readArray(EmWarpParamTableDeserializer::readEmWarpParam));
    }
}
