package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.JobMasterCtrl;

public class JobMasterCtrlDeserializer extends FileDeserializer {
    public JobMasterCtrlDeserializer(FileReader fileReader) {
        super(ExtensionMap.rJobMasterCtrl, fileReader);
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
    protected Object readObject() {
        return fileReader.readArray(JobMasterCtrlDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
