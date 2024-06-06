package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.EmBaseInfoSv;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.EmBaseInfoSvList;

import java.util.ArrayList;
import java.util.List;

public class EmBaseInfoSvDeserializer extends ClientResourceFileDeserializer {


    private static EmBaseInfoSv readEmBaseInfoSv(BufferReader bufferReader, int num) {
        return new EmBaseInfoSv(
                num,
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected EmBaseInfoSvList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long length = bufferReader.readUnsignedInteger();
        List<EmBaseInfoSv> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readEmBaseInfoSv(bufferReader, i));
        }
        return new EmBaseInfoSvList(entities);
    }
}
