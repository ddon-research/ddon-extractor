package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common.NpcIsUseJobParamEx;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common.NpcIsUseJobParamExList;

public class NpcIsUseJobParamExDeserializer extends ClientResourceFileDeserializer {
    public NpcIsUseJobParamExDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcIsUseJobParamEx readNpcIsUseJobParamEx(FileReader fileReader) {
        return new NpcIsUseJobParamEx(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcIsUseJobParamExList parseClientResourceFile(FileReader fileReader) {
        return new NpcIsUseJobParamExList(fileReader.readArray(NpcIsUseJobParamExDeserializer::readNpcIsUseJobParamEx));
    }
}