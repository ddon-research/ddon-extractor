package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.npc;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc.SituationData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc.SituationMsgCtrl;

public class SituationMsgCtrlDeserializer extends ClientResourceFileDeserializer {
    public SituationMsgCtrlDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static SituationData readSituationData(FileReader fileReader) {
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
    protected SituationMsgCtrl parseClientResourceFile(FileReader fileReader) {
        return new SituationMsgCtrl(fileReader.readArray(SituationMsgCtrlDeserializer::readSituationData));
    }
}
