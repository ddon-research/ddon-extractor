package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.PlayerExpTable;

import java.util.ArrayList;
import java.util.List;

public class PlayerExpTableDeserializer extends FileDeserializer {
    public PlayerExpTableDeserializer() {
        super(ClientResourceFile.rPlayerExpTable);
    }

    private static List<PlayerExpTable> readEntity(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<PlayerExpTable> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(new PlayerExpTable(i,
                    fileReader.readUnsignedInteger(),
                    fileReader.readUnsignedInteger()
            ));
        }
        return entities;
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
