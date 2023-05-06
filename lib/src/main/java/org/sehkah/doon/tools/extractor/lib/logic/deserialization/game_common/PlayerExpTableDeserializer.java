package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.PlayerExpTable;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.meta.PlayerExpTableWithMetaInformation;

import java.util.ArrayList;
import java.util.List;

public class PlayerExpTableDeserializer extends FileDeserializer {
    public PlayerExpTableDeserializer(FileReader fileReader) {
        super(ExtensionMap.rPlayerExpTable, fileReader);
    }

    private static PlayerExpTable readEntity(FileReader fileReader) {
        return new PlayerExpTable(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static List<PlayerExpTableWithMetaInformation> readEntityWithMetaInformation(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<PlayerExpTableWithMetaInformation> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(new PlayerExpTableWithMetaInformation(i, readEntity(fileReader)));
        }
        return entities;
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(PlayerExpTableDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readEntityWithMetaInformation(fileReader);
    }
}
