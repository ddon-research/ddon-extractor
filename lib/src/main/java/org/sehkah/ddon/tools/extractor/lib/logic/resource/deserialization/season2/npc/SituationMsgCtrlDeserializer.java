package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.npc;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.npc.SituationData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.npc.SituationMsgCtrl;

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
                fileReader.readBoolean()
        );
    }

    @Override
    protected SituationMsgCtrl parseClientResourceFile(FileReader fileReader) {
        return new SituationMsgCtrl(fileReader.readArray(SituationMsgCtrlDeserializer::readSituationData));
    }
}