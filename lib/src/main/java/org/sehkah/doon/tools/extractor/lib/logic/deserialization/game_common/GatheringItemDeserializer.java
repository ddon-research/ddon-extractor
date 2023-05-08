package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.GatheringItem;

import java.util.List;

public class GatheringItemDeserializer extends FileDeserializer<List<GatheringItem>> {
    public GatheringItemDeserializer() {
        super(ClientResourceFile.rGatheringItem);
    }

    private static GatheringItem readEntity(FileReader fileReader) {
        return new GatheringItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<GatheringItem> readObject(FileReader fileReader) {
        return fileReader.readArray(GatheringItemDeserializer::readEntity);
    }
}
