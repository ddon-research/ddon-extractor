package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.AreaInfoJointArea;

import java.util.List;

public class AreaInfoJointAreaDeserializer extends ClientResourceFileDeserializer<List<AreaInfoJointArea>> {
    public AreaInfoJointAreaDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfoJointArea readEntity(FileReader fileReader) {
        return new AreaInfoJointArea(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<AreaInfoJointArea> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AreaInfoJointAreaDeserializer::readEntity);
    }
}
