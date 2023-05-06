package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftUpGradeExpData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.meta.CraftUpGradeExpDataWithMetaInformation;

import java.util.ArrayList;
import java.util.List;

public class CraftUpGradeExpDeserializer extends FileDeserializer {
    public CraftUpGradeExpDeserializer(FileReader fileReader) {
        super(ExtensionMap.rCraftUpGradeExp, fileReader);
    }

    private static CraftUpGradeExpData readEntity(FileReader fileReader) {
        return new CraftUpGradeExpData(
                fileReader.readUnsignedLong()
        );
    }

    private static List<CraftUpGradeExpDataWithMetaInformation> readEntityWithMetaInformation(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<CraftUpGradeExpDataWithMetaInformation> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(new CraftUpGradeExpDataWithMetaInformation(i, readEntity(fileReader)));
        }
        return entities;
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(CraftUpGradeExpDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readEntityWithMetaInformation(fileReader);
    }
}
