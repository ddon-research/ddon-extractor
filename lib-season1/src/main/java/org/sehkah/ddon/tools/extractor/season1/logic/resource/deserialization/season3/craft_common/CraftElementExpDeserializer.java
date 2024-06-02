package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.craft_common.CraftElementExpData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.craft_common.CraftElementExpList;

import java.util.ArrayList;
import java.util.List;

public class CraftElementExpDeserializer extends ClientResourceFileDeserializer {
    public CraftElementExpDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftElementExpData readCraftElementExpData(BufferReader bufferReader, int level) {
        return new CraftElementExpData(
                level,
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftElementExpList parseClientResourceFile(BufferReader bufferReader) {
        long length = bufferReader.readUnsignedInteger();
        List<CraftElementExpData> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readCraftElementExpData(bufferReader, i));
        }
        return new CraftElementExpList(entities);
    }
}
