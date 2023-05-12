package org.sehkah.doon.tools.extractor.lib.logic.deserialization.job;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.job.StaminaDecList;
import org.sehkah.doon.tools.extractor.lib.logic.entity.job.StaminaDecParam;

import java.util.List;

public class StaminaDecTblDeserializer extends FileDeserializer<List<StaminaDecList>> {
    public StaminaDecTblDeserializer() {
        super(ClientResourceFile.rStaminaDecTbl);
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
    protected List<StaminaDecList> readObject(FileReader fileReader) {
        return fileReader.readArray(StaminaDecTblDeserializer::readEntity);
    }
}
