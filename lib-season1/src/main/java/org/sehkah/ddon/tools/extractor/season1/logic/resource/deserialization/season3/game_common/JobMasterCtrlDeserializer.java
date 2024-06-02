package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.JobMasterCtrl;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.JobMasterCtrlList;

public class JobMasterCtrlDeserializer extends ClientResourceFileDeserializer {
    public JobMasterCtrlDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected JobMasterCtrlList parseClientResourceFile(BufferReader bufferReader) {
        return new JobMasterCtrlList(bufferReader.readArray(JobMasterCtrlDeserializer::readJobMasterCtrl));
    }
}
