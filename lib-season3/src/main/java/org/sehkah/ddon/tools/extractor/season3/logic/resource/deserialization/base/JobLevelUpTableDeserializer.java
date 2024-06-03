package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.IncreaseParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.JobLevelUpTable;

public class JobLevelUpTableDeserializer extends ClientResourceFileDeserializer {
    public JobLevelUpTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static IncreaseParam readIncreaseParam(BufferReader bufferReader) {
        return new IncreaseParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected JobLevelUpTable parseClientResourceFile(BufferReader bufferReader) {
        return new JobLevelUpTable(bufferReader.readArray(JobLevelUpTableDeserializer::readIncreaseParam));
    }
}
