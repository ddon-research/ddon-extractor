package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.EmSound;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.EmSoundTable;

public class EmSoundTableDeserializer extends ClientResourceFileDeserializer {


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
    protected EmSoundTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmSoundTable(bufferReader.readArray(EmSoundTableDeserializer::readEmSoundData));
    }
}
