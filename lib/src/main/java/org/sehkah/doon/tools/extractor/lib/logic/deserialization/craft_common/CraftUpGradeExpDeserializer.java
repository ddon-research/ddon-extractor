package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftUpGradeExpData;

import java.util.ArrayList;
import java.util.List;

public class CraftUpGradeExpDeserializer extends FileDeserializer {
    public CraftUpGradeExpDeserializer() {
        super(ClientResourceFile.rCraftUpGradeExp);
    }

    private static List<CraftUpGradeExpData> readEntity(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<CraftUpGradeExpData> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(new CraftUpGradeExpData(
                    i,
                    fileReader.readUnsignedLong()
            ));
        }
        return entities;
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
