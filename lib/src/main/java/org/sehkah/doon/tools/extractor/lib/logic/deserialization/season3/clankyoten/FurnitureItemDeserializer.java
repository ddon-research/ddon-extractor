package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureItem;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureItemList;

public class FurnitureItemDeserializer extends ClientResourceFileDeserializer {
    public FurnitureItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureItem readFurnitureItem(FileReader fileReader) {
        return new FurnitureItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureItemList parseClientResourceFile(FileReader fileReader) {
        return new FurnitureItemList(fileReader.readArray(FurnitureItemDeserializer::readFurnitureItem));
    }
}
