package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.OcdElectricParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.OcdElectricParamList;

import java.nio.file.Path;

public class OcdElectricParamListDeserializer extends ClientResourceFileDeserializer<OcdElectricParamList> {


    private static OcdElectricParam readOcdElectricParam(BufferReader bufferReader) {
        return new OcdElectricParam(
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected OcdElectricParamList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new OcdElectricParamList(bufferReader.readArray(OcdElectricParamListDeserializer::readOcdElectricParam));
    }
}
