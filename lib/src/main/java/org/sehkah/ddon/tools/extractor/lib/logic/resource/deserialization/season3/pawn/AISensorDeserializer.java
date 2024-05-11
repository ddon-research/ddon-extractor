package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.pawn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.pawn.AISensor;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.pawn.AISensorNodeRes;

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
