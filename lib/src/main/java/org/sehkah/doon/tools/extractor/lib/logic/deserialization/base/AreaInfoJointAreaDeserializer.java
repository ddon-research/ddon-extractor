package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfoJointArea;

public class AreaInfoJointAreaDeserializer extends FileDeserializer {
    public AreaInfoJointAreaDeserializer() {
        super(ClientResourceFile.rAreaInfoJointArea);
    }

    private static AreaInfoJointArea readEntity(FileReader fileReader) {
        return new AreaInfoJointArea(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(AreaInfoJointAreaDeserializer::readEntity);
    }
}
