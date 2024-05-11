package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.JobMasterCtrl;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.JobMasterCtrlList;

public class JobMasterCtrlDeserializer extends ClientResourceFileDeserializer {
    public JobMasterCtrlDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JobMasterCtrl readJobMasterCtrl(FileReader fileReader) {
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
    protected JobMasterCtrlList parseClientResourceFile(FileReader fileReader) {
        return new JobMasterCtrlList(fileReader.readArray(JobMasterCtrlDeserializer::readJobMasterCtrl));
    }
}
