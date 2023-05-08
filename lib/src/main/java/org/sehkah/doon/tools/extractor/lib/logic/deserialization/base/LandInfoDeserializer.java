package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LandAreaInfo;

public class LandInfoDeserializer extends FileDeserializer {
    public LandInfoDeserializer(FileReader fileReader) {
        super(ExtensionMap.rLandInfo, fileReader);
    }

    private static LandAreaInfo readEntity(FileReader fileReader) {
        return new LandAreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedByte(),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(LandInfoDeserializer::readEntity);
    }
}
