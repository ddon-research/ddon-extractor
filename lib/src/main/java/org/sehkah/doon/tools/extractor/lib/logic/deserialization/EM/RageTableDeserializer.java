package org.sehkah.doon.tools.extractor.lib.logic.deserialization.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.EM.Rage;
import org.sehkah.doon.tools.extractor.lib.logic.entity.EM.meta.RageWithMetaInformation;

public class RageTableDeserializer extends FileDeserializer {
    public RageTableDeserializer(FileReader fileReader) {
        super(ExtensionMap.rRageTable, fileReader);
    }

    private static Rage readEntity(FileReader fileReader) {
        return new Rage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat()
        );
    }

    private static RageWithMetaInformation readEntityWithMetaInformation(FileReader fileReader) {
        return new RageWithMetaInformation(RageTableDeserializer.readEntity(fileReader));
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(RageTableDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return fileReader.readArray(RageTableDeserializer::readEntityWithMetaInformation);
    }
}
