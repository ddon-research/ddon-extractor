package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.pawn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.pawn.AISensor;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.pawn.AISensorNodeRes;

// FIXME: Unsure about the order of parameters
public class AISensorDeserializer extends ClientResourceFileDeserializer {
    public AISensorDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AISensorNodeRes readAISensorNodeRes(FileReader fileReader) {
        return new AISensorNodeRes(
                fileReader.readSphere(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected AISensor parseClientResourceFile(FileReader fileReader) {
        return new AISensor(fileReader.readArray(AISensorDeserializer::readAISensorNodeRes));
    }
}
