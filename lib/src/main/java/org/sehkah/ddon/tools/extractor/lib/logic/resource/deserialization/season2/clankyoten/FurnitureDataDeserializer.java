package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.clankyoten.FurnitureData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.clankyoten.FurnitureDataList;

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
