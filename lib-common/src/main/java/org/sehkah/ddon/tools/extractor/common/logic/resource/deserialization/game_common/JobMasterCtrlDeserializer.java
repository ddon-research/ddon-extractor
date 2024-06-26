package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.JobMasterCtrl;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.JobMasterCtrlList;

import java.nio.file.Path;

public class JobMasterCtrlDeserializer extends ClientResourceFileDeserializer<JobMasterCtrlList> {
    private static JobMasterCtrl readJobMasterCtrl(BufferReader bufferReader) {
        return new JobMasterCtrl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected JobMasterCtrlList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JobMasterCtrlList(bufferReader.readArray(JobMasterCtrlDeserializer::readJobMasterCtrl));
    }
}
