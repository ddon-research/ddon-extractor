package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.NpcConstItem;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.NpcConstItemList;

public class NpcConstItemDeserializer extends ClientResourceFileDeserializer {
    public NpcConstItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcConstItem readNpcConstItem(FileReader fileReader) {
        return new NpcConstItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcConstItemList parseClientResourceFile(FileReader fileReader) {
        return new NpcConstItemList(fileReader.readArray(NpcConstItemDeserializer::readNpcConstItem));
    }
}
