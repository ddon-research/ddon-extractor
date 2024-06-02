package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.npc;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.npc.SituationData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.npc.SituationMsgCtrl;

public class SituationMsgCtrlDeserializer extends ClientResourceFileDeserializer {
    public SituationMsgCtrlDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static SituationData readSituationData(BufferReader bufferReader) {
        return new SituationData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected SituationMsgCtrl parseClientResourceFile(BufferReader bufferReader) {
        return new SituationMsgCtrl(bufferReader.readArray(SituationMsgCtrlDeserializer::readSituationData));
    }
}
