package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common.CraftElementExpData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common.CraftElementExpList;

import java.util.ArrayList;
import java.util.List;

public class CraftElementExpDeserializer extends ClientResourceFileDeserializer {
    public CraftElementExpDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftElementExpData readCraftElementExpData(FileReader fileReader, int level) {
        return new CraftElementExpData(
                level,
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftElementExpList parseClientResourceFile(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<CraftElementExpData> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readCraftElementExpData(fileReader, i));
        }
        return new CraftElementExpList(entities);
    }
}
