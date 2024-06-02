package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.OcdElectricParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.OcdElectricParamList;

public class OcdElectricParamListDeserializer extends ClientResourceFileDeserializer {
    public OcdElectricParamListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static OcdElectricParam readOcdElectricParam(BufferReader bufferReader) {
        return new OcdElectricParam(
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected OcdElectricParamList parseClientResourceFile(BufferReader bufferReader) {
        return new OcdElectricParamList(bufferReader.readArray(OcdElectricParamListDeserializer::readOcdElectricParam));
    }
}
