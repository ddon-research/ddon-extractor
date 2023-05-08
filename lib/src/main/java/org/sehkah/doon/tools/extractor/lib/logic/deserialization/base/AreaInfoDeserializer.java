package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfo;

public class AreaInfoDeserializer extends FileDeserializer {
    public AreaInfoDeserializer() {
        super(ClientResourceFile.rAreaInfo);
    }

    private static AreaInfo readEntity(FileReader fileReader) {
        return new AreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(AreaInfoDeserializer::readEntity);
    }
}
