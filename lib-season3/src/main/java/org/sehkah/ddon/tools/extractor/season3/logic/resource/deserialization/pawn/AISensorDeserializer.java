package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.pawn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.pawn.AISensor;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.pawn.AISensorNodeRes;

import java.nio.file.Path;

// FIXME: Unsure about the order of parameters
public class AISensorDeserializer extends ClientResourceFileDeserializer<AISensor> {


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
    protected AISensor parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AISensor(bufferReader.readArray(AISensorDeserializer::readAISensorNodeRes));
    }
}
