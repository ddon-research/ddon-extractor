package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.IncreaseParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.JobLevelUpTable;

import java.nio.file.Path;

public class JobLevelUpTableDeserializer extends ClientResourceFileDeserializer<JobLevelUpTable> {
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
    protected JobLevelUpTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JobLevelUpTable(bufferReader.readArray(JobLevelUpTableDeserializer::readIncreaseParam));
    }
}
