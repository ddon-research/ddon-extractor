package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.npc_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc_common.NpcConstItem;

import java.util.List;

public class NpcConstItemDeserializer extends ClientResourceFileDeserializer<List<NpcConstItem>> {
    public NpcConstItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcConstItem readEntity(FileReader fileReader) {
        return new NpcConstItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<NpcConstItem> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(NpcConstItemDeserializer::readEntity);
    }
}
