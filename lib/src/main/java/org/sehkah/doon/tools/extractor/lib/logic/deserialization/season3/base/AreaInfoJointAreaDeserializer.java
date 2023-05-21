package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.AreaInfoJointArea;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.AreaInfoJointAreaList;

public class AreaInfoJointAreaDeserializer extends ClientResourceFileDeserializer {
    public AreaInfoJointAreaDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfoJointArea readAreaInfoJointArea(FileReader fileReader) {
        return new AreaInfoJointArea(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected AreaInfoJointAreaList parseClientResourceFile(FileReader fileReader) {
        return new AreaInfoJointAreaList(fileReader.readArray(AreaInfoJointAreaDeserializer::readAreaInfoJointArea));
    }
}
