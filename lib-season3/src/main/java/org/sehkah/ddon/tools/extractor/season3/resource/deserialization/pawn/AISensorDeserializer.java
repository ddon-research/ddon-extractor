package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.pawn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.pawn.AISensor;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.pawn.AISensorNodeRes;

// FIXME: Unsure about the order of parameters
public class AISensorDeserializer extends ClientResourceFileDeserializer {
    public AISensorDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected AISensor parseClientResourceFile(BufferReader bufferReader) {
        return new AISensor(bufferReader.readArray(AISensorDeserializer::readAISensorNodeRes));
    }
}
