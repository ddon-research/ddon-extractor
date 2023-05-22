package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.game_common.PlayerExpTable;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.game_common.PlayerExpTableList;

import java.util.ArrayList;
import java.util.List;

public class PlayerExpTableDeserializer extends ClientResourceFileDeserializer {
    public PlayerExpTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PlayerExpTable readPlayerExpTable(FileReader fileReader, int level) {
        return new PlayerExpTable(level,
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected PlayerExpTableList parseClientResourceFile(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<PlayerExpTable> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readPlayerExpTable(fileReader, i));
        }
        return new PlayerExpTableList(entities);
    }
}
