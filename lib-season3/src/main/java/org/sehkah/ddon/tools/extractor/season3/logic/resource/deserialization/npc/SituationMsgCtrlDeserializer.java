package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc.SituationData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc.SituationMsgCtrl;

import java.nio.file.Path;

public class SituationMsgCtrlDeserializer extends ClientResourceFileDeserializer<SituationMsgCtrl> {


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
    protected SituationMsgCtrl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new SituationMsgCtrl(bufferReader.readArray(SituationMsgCtrlDeserializer::readSituationData));
    }
}
