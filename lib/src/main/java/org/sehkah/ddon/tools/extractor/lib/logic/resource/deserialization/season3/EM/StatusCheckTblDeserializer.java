package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.StatusCheck;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.StatusCheckTbl;

public class StatusCheckTblDeserializer extends ClientResourceFileDeserializer {
    public StatusCheckTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StatusCheck readStatusCheck(BufferReader bufferReader) {
        return new StatusCheck(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(3, BufferReader::readFloat),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected StatusCheckTbl parseClientResourceFile(BufferReader bufferReader) {
        return new StatusCheckTbl(bufferReader.readArray(StatusCheckTblDeserializer::readStatusCheck));
    }
}
