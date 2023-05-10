package org.sehkah.doon.tools.extractor.lib.logic.deserialization.npc_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.npc_common.NpcConstItem;

import java.util.List;

public class NpcConstItemDeserializer extends FileDeserializer<List<NpcConstItem>> {
    public NpcConstItemDeserializer() {
        super(ClientResourceFile.rNpcConstItem);
    }

    private static NpcConstItem readEntity(FileReader fileReader) {
        return new NpcConstItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<NpcConstItem> readObject(FileReader fileReader) {
        return fileReader.readArray(NpcConstItemDeserializer::readEntity);
    }
}
