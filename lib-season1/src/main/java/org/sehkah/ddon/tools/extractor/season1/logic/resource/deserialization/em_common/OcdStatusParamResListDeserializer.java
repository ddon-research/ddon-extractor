package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.OcdStatusParamRes;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.OcdStatusParamResList;

public class OcdStatusParamResListDeserializer extends ClientResourceFileDeserializer {
    public OcdStatusParamResListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected OcdStatusParamResList parseClientResourceFile(BufferReader bufferReader) {
        return new OcdStatusParamResList(bufferReader.readArray(OcdStatusParamResListDeserializer::readOcdStatusParamRes));
    }
}
