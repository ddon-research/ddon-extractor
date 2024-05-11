package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.clankyoten.FurnitureItem;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.clankyoten.FurnitureItemList;

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
