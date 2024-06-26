package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.EmDamageDirInfo;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.EmDamageDirInfoList;

import java.nio.file.Path;

public class EmDamageDirInfoDeserializer extends ClientResourceFileDeserializer<EmDamageDirInfoList> {


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
    protected EmDamageDirInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmDamageDirInfoList(bufferReader.readArray(EmDamageDirInfoDeserializer::readEmDamageDirInfo));
    }
}
