package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.GatheringItem;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.GatheringItemList;

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
