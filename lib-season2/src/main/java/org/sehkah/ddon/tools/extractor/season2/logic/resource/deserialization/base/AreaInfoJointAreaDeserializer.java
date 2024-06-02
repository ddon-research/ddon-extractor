package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.AreaInfoJointArea;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.AreaInfoJointAreaList;

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
