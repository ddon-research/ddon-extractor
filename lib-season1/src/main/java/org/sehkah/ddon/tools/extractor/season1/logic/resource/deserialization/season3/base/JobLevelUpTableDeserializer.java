package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.IncreaseParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.JobLevelUpTable;

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
