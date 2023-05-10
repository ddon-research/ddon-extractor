package org.sehkah.doon.tools.extractor.lib.logic.deserialization.npc;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.npc.SituationData;

import java.util.List;

public class SituationMsgCtrlDeserializer extends FileDeserializer<List<SituationData>> {
    public SituationMsgCtrlDeserializer() {
        super(ClientResourceFile.rSituationMsgCtrl);
    }

    private static SituationData readEntity(FileReader fileReader) {
        return new SituationData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<SituationData> readObject(FileReader fileReader) {
        return fileReader.readArray(SituationMsgCtrlDeserializer::readEntity);
    }
}
