package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.EmSound;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.EmSoundTable;

import java.nio.file.Path;

public class EmSoundTableDeserializer extends ClientResourceFileDeserializer<EmSoundTable> {


    private static EmSound readEmSoundData(BufferReader bufferReader) {
        return new EmSound(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EmSoundTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmSoundTable(bufferReader.readArray(EmSoundTableDeserializer::readEmSoundData));
    }
}
