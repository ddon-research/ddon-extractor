package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.npc;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc.SituationData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc.SituationMsgCtrl;

public class SituationMsgCtrlDeserializer extends ClientResourceFileDeserializer {


    private static SituationData readSituationData(BufferReader bufferReader) {
        return new SituationData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected SituationMsgCtrl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new SituationMsgCtrl(bufferReader.readArray(SituationMsgCtrlDeserializer::readSituationData));
    }
}
