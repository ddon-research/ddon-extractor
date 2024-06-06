package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.GatheringItem;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.GatheringItemList;

public class GatheringItemDeserializer extends ClientResourceFileDeserializer {


    private static GatheringItem readGatheringItem(BufferReader bufferReader) {
        return new GatheringItem(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected GatheringItemList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new GatheringItemList(bufferReader.readArray(GatheringItemDeserializer::readGatheringItem));
    }
}
