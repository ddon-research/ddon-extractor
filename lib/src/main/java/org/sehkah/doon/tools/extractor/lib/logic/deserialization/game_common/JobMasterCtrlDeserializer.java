package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.JobMasterCtrl;

import java.util.List;

public class JobMasterCtrlDeserializer extends FileDeserializer<List<JobMasterCtrl>> {
    public JobMasterCtrlDeserializer() {
        super(ClientResourceFile.rJobMasterCtrl);
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
    protected List<JobMasterCtrl> readObject(FileReader fileReader) {
        return fileReader.readArray(JobMasterCtrlDeserializer::readEntity);
    }
}
