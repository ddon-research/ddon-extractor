package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftElementExpData;

import java.util.ArrayList;
import java.util.List;

public class CraftElementExpDeserializer extends ClientResourceFileDeserializer<List<CraftElementExpData>> {
    public CraftElementExpDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<CraftElementExpData> parseClientResourceFile(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
