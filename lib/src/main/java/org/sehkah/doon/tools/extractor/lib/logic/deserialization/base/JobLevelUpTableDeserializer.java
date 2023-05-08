package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.IncreaseParam;

public class JobLevelUpTableDeserializer extends FileDeserializer {
    public JobLevelUpTableDeserializer(FileReader fileReader) {
        super(ExtensionMap.rJobLevelUpTbl2, fileReader);
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
    protected Object readObject() {
        return fileReader.readArray(JobLevelUpTableDeserializer::readEntity);
    }
}
