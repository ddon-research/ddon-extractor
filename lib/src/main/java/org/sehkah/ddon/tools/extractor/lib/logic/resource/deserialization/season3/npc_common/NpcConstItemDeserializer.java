package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common.NpcConstItem;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common.NpcConstItemList;

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
