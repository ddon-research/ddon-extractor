package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.OcdImmuneParamRes;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.OcdImmuneParamResTable;

import java.nio.file.Path;

public class OcdImmuneParamResTableDeserializer extends ClientResourceFileDeserializer<OcdImmuneParamResTable> {


    private static OcdImmuneParamRes readOcdImmuneParamRes(BufferReader bufferReader) {
        return new OcdImmuneParamRes(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected OcdImmuneParamResTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new OcdImmuneParamResTable(bufferReader.readArray(OcdImmuneParamResTableDeserializer::readOcdImmuneParamRes));
    }
}
