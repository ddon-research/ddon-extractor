package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.OcdElectricParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.OcdElectricParamList;

public class OcdElectricParamListDeserializer extends ClientResourceFileDeserializer {
    public OcdElectricParamListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static OcdElectricParam readOcdElectricParam(FileReader fileReader) {
        return new OcdElectricParam(
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected OcdElectricParamList parseClientResourceFile(FileReader fileReader) {
        return new OcdElectricParamList(fileReader.readArray(OcdElectricParamListDeserializer::readOcdElectricParam));
    }
}
