package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.IncreaseParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.JobLevelUpTable;

public class JobLevelUpTableDeserializer extends ClientResourceFileDeserializer {
    public JobLevelUpTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static IncreaseParam readIncreaseParam(FileReader fileReader) {
        return new IncreaseParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected JobLevelUpTable parseClientResourceFile(FileReader fileReader) {
        return new JobLevelUpTable(fileReader.readArray(JobLevelUpTableDeserializer::readIncreaseParam));
    }
}
