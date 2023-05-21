package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season2.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.game_common.PlayerExpTable;

import java.util.ArrayList;
import java.util.List;

public class PlayerExpTableDeserializer extends ClientResourceFileDeserializer<List<PlayerExpTable>> {
    public PlayerExpTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<PlayerExpTable> parseClientResourceFile(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
