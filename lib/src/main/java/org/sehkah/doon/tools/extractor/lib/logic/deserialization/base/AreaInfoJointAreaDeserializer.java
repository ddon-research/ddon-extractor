package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfoJointArea;

import java.util.List;

public class AreaInfoJointAreaDeserializer extends FileDeserializer<List<AreaInfoJointArea>> {
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
    protected List<AreaInfoJointArea> readObject(FileReader fileReader) {
        return fileReader.readArray(AreaInfoJointAreaDeserializer::readEntity);
    }
}
