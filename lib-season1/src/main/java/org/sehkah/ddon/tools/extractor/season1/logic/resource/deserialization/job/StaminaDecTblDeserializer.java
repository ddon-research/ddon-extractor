package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.StaminaDecList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.StaminaDecParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.StaminaDecTbl;

public class StaminaDecTblDeserializer extends ClientResourceFileDeserializer {
    public StaminaDecTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StaminaDecParam readStaminaDecParam(BufferReader bufferReader) {
        return new StaminaDecParam(bufferReader.readFloat());
    }

    private static StaminaDecList readStaminaDecList(BufferReader bufferReader) {
        return new StaminaDecList(
                bufferReader.readArray(StaminaDecTblDeserializer::readStaminaDecParam),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StaminaDecTbl parseClientResourceFile(BufferReader bufferReader) {
        return new StaminaDecTbl(bufferReader.readArray(StaminaDecTblDeserializer::readStaminaDecList));
    }
}
