package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.GatheringItem;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.GatheringItemList;

public class GatheringItemDeserializer extends ClientResourceFileDeserializer {
    public GatheringItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static GatheringItem readGatheringItem(BufferReader bufferReader) {
        return new GatheringItem(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected GatheringItemList parseClientResourceFile(BufferReader bufferReader) {
        return new GatheringItemList(bufferReader.readArray(GatheringItemDeserializer::readGatheringItem));
    }
}
