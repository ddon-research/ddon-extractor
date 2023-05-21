package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season2.npc;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.npc.SituationData;

import java.util.List;

public class SituationMsgCtrlDeserializer extends ClientResourceFileDeserializer<List<SituationData>> {
    public SituationMsgCtrlDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static SituationData readEntity(FileReader fileReader) {
        return new SituationData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected List<SituationData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(SituationMsgCtrlDeserializer::readEntity);
    }
}
