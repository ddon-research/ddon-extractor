package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.IncreaseParam;

import java.util.List;

public class JobLevelUpTableDeserializer extends FileDeserializer<List<IncreaseParam>> {
    public JobLevelUpTableDeserializer() {
        super(ClientResourceFile.rJobLevelUpTbl2);
    }

    private static IncreaseParam readEntity(FileReader fileReader) {
        return new IncreaseParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<IncreaseParam> readObject(FileReader fileReader) {
        return fileReader.readArray(JobLevelUpTableDeserializer::readEntity);
    }
}
