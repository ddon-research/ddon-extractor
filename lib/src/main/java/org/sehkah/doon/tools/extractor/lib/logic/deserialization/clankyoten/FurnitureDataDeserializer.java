package org.sehkah.doon.tools.extractor.lib.logic.deserialization.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten.FurnitureData;

import java.util.List;

public class FurnitureDataDeserializer extends FileDeserializer<List<FurnitureData>> {
    public FurnitureDataDeserializer() {
        super(ClientResourceFile.rFurnitureData);
    }

    private static FurnitureData readEntity(FileReader fileReader) {
        return new FurnitureData(
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readVector3f()
        );
    }

    @Override
    protected List<FurnitureData> readObject(FileReader fileReader) {
        return fileReader.readArray(FurnitureDataDeserializer::readEntity);
    }
}
