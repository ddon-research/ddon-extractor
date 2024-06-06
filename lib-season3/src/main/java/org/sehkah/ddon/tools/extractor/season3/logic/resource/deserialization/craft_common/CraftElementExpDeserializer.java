package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.craft_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.craft_common.CraftElementExpData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.craft_common.CraftElementExpList;

import java.util.ArrayList;
import java.util.List;

public class CraftElementExpDeserializer extends ClientResourceFileDeserializer {


    private static CraftElementExpData readCraftElementExpData(BufferReader bufferReader, int level) {
        return new CraftElementExpData(
                level,
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftElementExpList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long length = bufferReader.readUnsignedInteger();
        List<CraftElementExpData> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readCraftElementExpData(bufferReader, i));
        }
        return new CraftElementExpList(entities);
    }
}
