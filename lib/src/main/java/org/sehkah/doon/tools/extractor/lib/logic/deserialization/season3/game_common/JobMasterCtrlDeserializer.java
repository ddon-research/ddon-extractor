package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.JobMasterCtrl;

import java.util.List;

public class JobMasterCtrlDeserializer extends ClientResourceFileDeserializer<List<JobMasterCtrl>> {
    public JobMasterCtrlDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JobMasterCtrl readEntity(FileReader fileReader) {
        return new JobMasterCtrl(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<JobMasterCtrl> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(JobMasterCtrlDeserializer::readEntity);
    }
}
