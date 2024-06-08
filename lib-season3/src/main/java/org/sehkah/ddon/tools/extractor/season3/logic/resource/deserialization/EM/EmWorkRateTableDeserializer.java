package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmWorkRate;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmWorkRateTable;

import java.nio.file.Path;

public class EmWorkRateTableDeserializer extends ClientResourceFileDeserializer<EmWorkRateTable> {


    private static EmWorkRate readEmWorkRate(BufferReader bufferReader) {
        return new EmWorkRate(
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected EmWorkRateTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmWorkRateTable(bufferReader.readArray(EmWorkRateTableDeserializer::readEmWorkRate));
    }
}
