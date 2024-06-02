package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.craft_common.CraftUpGradeExpData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.craft_common.CraftUpGradeExpList;

import java.util.ArrayList;
import java.util.List;

public class CraftUpGradeExpDeserializer extends ClientResourceFileDeserializer {
    public CraftUpGradeExpDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftUpGradeExpData readCraftUpGradeExpData(BufferReader bufferReader, int level) {
        return new CraftUpGradeExpData(
                level,
                bufferReader.readUnsignedLong()
        );
    }

    @Override
    protected CraftUpGradeExpList parseClientResourceFile(BufferReader bufferReader) {
        long length = bufferReader.readUnsignedInteger();
        List<CraftUpGradeExpData> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readCraftUpGradeExpData(bufferReader, i));
        }
        return new CraftUpGradeExpList(entities);
    }
}
