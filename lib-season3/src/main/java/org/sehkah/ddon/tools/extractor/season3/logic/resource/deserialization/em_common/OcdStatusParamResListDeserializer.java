package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.em_common.OcdStatusParamRes;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.em_common.OcdStatusParamResList;

public class OcdStatusParamResListDeserializer extends ClientResourceFileDeserializer {


    private static OcdStatusParamRes readOcdStatusParamRes(BufferReader bufferReader) {
        return new OcdStatusParamRes(
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected OcdStatusParamResList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new OcdStatusParamResList(bufferReader.readArray(OcdStatusParamResListDeserializer::readOcdStatusParamRes));
    }
}
