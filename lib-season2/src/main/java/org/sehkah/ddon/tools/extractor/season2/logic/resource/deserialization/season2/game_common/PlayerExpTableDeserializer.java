package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season2.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.game_common.PlayerExpTable;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.game_common.PlayerExpTableList;

import java.util.ArrayList;
import java.util.List;

public class PlayerExpTableDeserializer extends ClientResourceFileDeserializer {
    public PlayerExpTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PlayerExpTable readPlayerExpTable(BufferReader bufferReader, int level) {
        return new PlayerExpTable(level,
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected PlayerExpTableList parseClientResourceFile(BufferReader bufferReader) {
        long length = bufferReader.readUnsignedInteger();
        List<PlayerExpTable> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readPlayerExpTable(bufferReader, i));
        }
        return new PlayerExpTableList(entities);
    }
}
