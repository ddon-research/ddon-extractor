package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.GatheringItem;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.GatheringItemList;

public class GatheringItemDeserializer extends ClientResourceFileDeserializer {
    public GatheringItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static GatheringItem readGatheringItem(FileReader fileReader) {
        return new GatheringItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected GatheringItemList parseClientResourceFile(FileReader fileReader) {
        return new GatheringItemList(fileReader.readArray(GatheringItemDeserializer::readGatheringItem));
    }
}
