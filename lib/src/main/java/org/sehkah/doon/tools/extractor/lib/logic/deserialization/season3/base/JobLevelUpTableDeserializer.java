package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.IncreaseParam;

import java.util.List;

public class JobLevelUpTableDeserializer extends ClientResourceFileDeserializer<List<IncreaseParam>> {
    public JobLevelUpTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<IncreaseParam> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(JobLevelUpTableDeserializer::readEntity);
    }
}
