package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.OcdStatusParamRes;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.OcdStatusParamResList;

import java.nio.file.Path;

public class OcdStatusParamResListDeserializer extends ClientResourceFileDeserializer<OcdStatusParamResList> {
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
    protected OcdStatusParamResList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new OcdStatusParamResList(bufferReader.readArray(OcdStatusParamResListDeserializer::readOcdStatusParamRes));
    }
}
