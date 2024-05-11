package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.StatusCheck;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.StatusCheckTbl;

public class StatusCheckTblDeserializer extends ClientResourceFileDeserializer {
    public StatusCheckTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StatusCheck readStatusCheck(FileReader fileReader) {
        return new StatusCheck(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(3, FileReader::readFloat),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected StatusCheckTbl parseClientResourceFile(FileReader fileReader) {
        return new StatusCheckTbl(fileReader.readArray(StatusCheckTblDeserializer::readStatusCheck));
    }
}
