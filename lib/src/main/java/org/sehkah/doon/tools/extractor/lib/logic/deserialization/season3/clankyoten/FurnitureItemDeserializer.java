package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureItem;

import java.util.List;

public class FurnitureItemDeserializer extends ClientResourceFileDeserializer<List<FurnitureItem>> {
    public FurnitureItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureItem readEntity(FileReader fileReader) {
        return new FurnitureItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<FurnitureItem> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(FurnitureItemDeserializer::readEntity);
    }
}
