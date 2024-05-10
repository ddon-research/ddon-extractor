package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.OcdImmuneParamRes;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.OcdImmuneParamResTable;

public class OcdImmuneParamResTableDeserializer extends ClientResourceFileDeserializer {
    public OcdImmuneParamResTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static OcdImmuneParamRes readOcdImmuneParamRes(FileReader fileReader) {
        return new OcdImmuneParamRes(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected OcdImmuneParamResTable parseClientResourceFile(FileReader fileReader) {
        return new OcdImmuneParamResTable(fileReader.readArray(OcdImmuneParamResTableDeserializer::readOcdImmuneParamRes));
    }
}
