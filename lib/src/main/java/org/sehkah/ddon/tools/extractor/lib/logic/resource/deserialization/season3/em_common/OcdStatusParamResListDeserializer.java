package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.OcdStatusParamRes;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.OcdStatusParamResList;

public class OcdStatusParamResListDeserializer extends ClientResourceFileDeserializer {
    public OcdStatusParamResListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static OcdStatusParamRes readOcdStatusParamRes(FileReader fileReader) {
        return new OcdStatusParamRes(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected OcdStatusParamResList parseClientResourceFile(FileReader fileReader) {
        return new OcdStatusParamResList(fileReader.readArray(OcdStatusParamResListDeserializer::readOcdStatusParamRes));
    }
}
