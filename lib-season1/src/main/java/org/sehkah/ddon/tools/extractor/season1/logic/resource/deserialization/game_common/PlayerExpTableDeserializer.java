package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.PlayerExpTable;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.PlayerExpTableList;

import java.util.ArrayList;
import java.util.List;

public class PlayerExpTableDeserializer extends ClientResourceFileDeserializer<PlayerExpTableList> {


    private static PlayerExpTable readPlayerExpTable(BufferReader bufferReader, int level) {
        return new PlayerExpTable(level,
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected PlayerExpTableList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long length = bufferReader.readUnsignedInteger();
        List<PlayerExpTable> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readPlayerExpTable(bufferReader, i));
        }
        return new PlayerExpTableList(entities);
    }
}
