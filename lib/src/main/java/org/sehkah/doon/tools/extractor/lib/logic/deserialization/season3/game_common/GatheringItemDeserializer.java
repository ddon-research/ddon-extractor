package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.GatheringItem;

import java.util.List;

public class GatheringItemDeserializer extends ClientResourceFileDeserializer<List<GatheringItem>> {
    public GatheringItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static GatheringItem readEntity(FileReader fileReader) {
        return new GatheringItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<GatheringItem> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(GatheringItemDeserializer::readEntity);
    }
}
