package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.em_common.EmDamageDirInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.em_common.EmDamageDirInfoList;

public class EmDamageDirInfoDeserializer extends ClientResourceFileDeserializer {
    public EmDamageDirInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmDamageDirInfo readEmDamageDirInfo(BufferReader bufferReader) {
        return new EmDamageDirInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EmDamageDirInfoList parseClientResourceFile(BufferReader bufferReader) {
        return new EmDamageDirInfoList(bufferReader.readArray(EmDamageDirInfoDeserializer::readEmDamageDirInfo));
    }
}
