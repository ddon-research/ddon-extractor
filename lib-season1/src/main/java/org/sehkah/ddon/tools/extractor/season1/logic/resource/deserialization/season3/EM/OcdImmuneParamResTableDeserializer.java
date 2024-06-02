package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM.OcdImmuneParamRes;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM.OcdImmuneParamResTable;

public class OcdImmuneParamResTableDeserializer extends ClientResourceFileDeserializer {
    public OcdImmuneParamResTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static OcdImmuneParamRes readOcdImmuneParamRes(BufferReader bufferReader) {
        return new OcdImmuneParamRes(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected OcdImmuneParamResTable parseClientResourceFile(BufferReader bufferReader) {
        return new OcdImmuneParamResTable(bufferReader.readArray(OcdImmuneParamResTableDeserializer::readOcdImmuneParamRes));
    }
}
