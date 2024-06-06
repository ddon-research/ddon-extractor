package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.craft_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.craft_common.CraftUpGradeExpData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.craft_common.CraftUpGradeExpList;

import java.util.ArrayList;
import java.util.List;

public class CraftUpGradeExpDeserializer extends ClientResourceFileDeserializer {


    private static CraftUpGradeExpData readCraftUpGradeExpData(BufferReader bufferReader, int level) {
        return new CraftUpGradeExpData(
                level,
                bufferReader.readUnsignedLong()
        );
    }

    @Override
    protected CraftUpGradeExpList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long length = bufferReader.readUnsignedInteger();
        List<CraftUpGradeExpData> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readCraftUpGradeExpData(bufferReader, i));
        }
        return new CraftUpGradeExpList(entities);
    }
}
