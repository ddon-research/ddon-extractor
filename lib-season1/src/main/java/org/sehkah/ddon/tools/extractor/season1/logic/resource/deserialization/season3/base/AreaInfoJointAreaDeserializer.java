package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.AreaInfoJointArea;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.AreaInfoJointAreaList;

public class AreaInfoJointAreaDeserializer extends ClientResourceFileDeserializer {
    public AreaInfoJointAreaDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfoJointArea readAreaInfoJointArea(BufferReader bufferReader) {
        return new AreaInfoJointArea(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected AreaInfoJointAreaList parseClientResourceFile(BufferReader bufferReader) {
        return new AreaInfoJointAreaList(bufferReader.readArray(AreaInfoJointAreaDeserializer::readAreaInfoJointArea));
    }
}
