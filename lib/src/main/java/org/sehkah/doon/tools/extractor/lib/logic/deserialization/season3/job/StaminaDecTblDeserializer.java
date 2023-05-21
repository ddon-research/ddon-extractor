package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.job;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.job.StaminaDecList;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.job.StaminaDecParam;

import java.util.List;

public class StaminaDecTblDeserializer extends ClientResourceFileDeserializer<List<StaminaDecList>> {
    public StaminaDecTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StaminaDecParam readStaminaDecParam(FileReader fileReader) {
        return new StaminaDecParam(fileReader.readFloat());
    }

    private static StaminaDecList readEntity(FileReader fileReader) {
        return new StaminaDecList(
                fileReader.readArray(StaminaDecTblDeserializer::readStaminaDecParam),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<StaminaDecList> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(StaminaDecTblDeserializer::readEntity);
    }
}
