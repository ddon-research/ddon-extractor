package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season2.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.clankyoten.FurnitureData;

import java.util.List;

public class FurnitureDataDeserializer extends ClientResourceFileDeserializer<List<FurnitureData>> {
    public FurnitureDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureData readEntity(FileReader fileReader) {
        return new FurnitureData(
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<FurnitureData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(FurnitureDataDeserializer::readEntity);
    }
}
