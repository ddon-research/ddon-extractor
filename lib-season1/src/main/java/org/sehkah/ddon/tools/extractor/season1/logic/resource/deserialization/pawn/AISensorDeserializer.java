package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.pawn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.pawn.AISensor;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.pawn.AISensorNodeRes;

// FIXME: Unsure about the order of parameters
public class AISensorDeserializer extends ClientResourceFileDeserializer {


    private static AISensorNodeRes readAISensorNodeRes(BufferReader bufferReader) {
        return new AISensorNodeRes(
                bufferReader.readSphere(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected AISensor parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AISensor(bufferReader.readArray(AISensorDeserializer::readAISensorNodeRes));
    }
}
