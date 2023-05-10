package org.sehkah.doon.tools.extractor.lib.logic.deserialization.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten.FurnitureItem;

import java.util.List;

public class FurnitureItemDeserializer extends FileDeserializer<List<FurnitureItem>> {
    public FurnitureItemDeserializer() {
        super(ClientResourceFile.rFurnitureItem);
    }

    private static FurnitureItem readEntity(FileReader fileReader) {
        return new FurnitureItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<FurnitureItem> readObject(FileReader fileReader) {
        return fileReader.readArray(FurnitureItemDeserializer::readEntity);
    }
}
