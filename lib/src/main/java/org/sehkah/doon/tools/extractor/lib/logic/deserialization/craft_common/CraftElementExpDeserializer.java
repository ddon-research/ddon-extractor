package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftElementExpData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.meta.CraftElementExpDataWithMetaInformation;

import java.util.ArrayList;
import java.util.List;

public class CraftElementExpDeserializer extends FileDeserializer {
    public CraftElementExpDeserializer(FileReader fileReader) {
        super(ExtensionMap.rCraftElementExp, fileReader);
    }

    private static CraftElementExpData readEntity(FileReader fileReader) {
        return new CraftElementExpData(
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedInteger()
        );
    }

    private static List<CraftElementExpDataWithMetaInformation> readEntityWithMetaInformation(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<CraftElementExpDataWithMetaInformation> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(new CraftElementExpDataWithMetaInformation(i, readEntity(fileReader)));
        }
        return entities;
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(CraftElementExpDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readEntityWithMetaInformation(fileReader);
    }
}
