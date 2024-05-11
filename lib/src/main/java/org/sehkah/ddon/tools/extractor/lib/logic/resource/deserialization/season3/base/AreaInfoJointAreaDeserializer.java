package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.AreaInfoJointArea;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.AreaInfoJointAreaList;

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
