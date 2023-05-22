package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.clankyoten.FurnitureData;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.clankyoten.FurnitureDataList;

public class FurnitureDataDeserializer extends ClientResourceFileDeserializer {
    public FurnitureDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureData readFurnitureData(FileReader fileReader) {
        return new FurnitureData(
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureDataList parseClientResourceFile(FileReader fileReader) {
        return new FurnitureDataList(fileReader.readArray(FurnitureDataDeserializer::readFurnitureData));
    }
}
