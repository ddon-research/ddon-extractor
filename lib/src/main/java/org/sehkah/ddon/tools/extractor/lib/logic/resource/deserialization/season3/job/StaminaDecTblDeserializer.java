package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job.StaminaDecList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job.StaminaDecParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job.StaminaDecTbl;

public class StaminaDecTblDeserializer extends ClientResourceFileDeserializer {
    public StaminaDecTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StaminaDecParam readStaminaDecParam(FileReader fileReader) {
        return new StaminaDecParam(fileReader.readFloat());
    }

    private static StaminaDecList readStaminaDecList(FileReader fileReader) {
        return new StaminaDecList(
                fileReader.readArray(StaminaDecTblDeserializer::readStaminaDecParam),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected StaminaDecTbl parseClientResourceFile(FileReader fileReader) {
        return new StaminaDecTbl(fileReader.readArray(StaminaDecTblDeserializer::readStaminaDecList));
    }
}
