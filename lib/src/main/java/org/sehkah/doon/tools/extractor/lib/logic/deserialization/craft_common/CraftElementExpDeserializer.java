package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftElementExpData;

import java.util.ArrayList;
import java.util.List;

public class CraftElementExpDeserializer extends FileDeserializer {
    public CraftElementExpDeserializer() {
        super(ClientResourceFile.rCraftElementExp);
    }

    private static List<CraftElementExpData> readEntity(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<CraftElementExpData> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(new CraftElementExpData(
                    i,
                    fileReader.readUnsignedLong(),
                    fileReader.readUnsignedInteger()
            ));
        }
        return entities;
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
