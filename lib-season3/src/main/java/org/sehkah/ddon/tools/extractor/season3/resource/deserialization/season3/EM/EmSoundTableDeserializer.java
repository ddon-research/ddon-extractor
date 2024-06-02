package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.EmSound;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.EmSoundTable;

public class EmSoundTableDeserializer extends ClientResourceFileDeserializer {
    public EmSoundTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected EmSoundTable parseClientResourceFile(BufferReader bufferReader) {
        return new EmSoundTable(bufferReader.readArray(EmSoundTableDeserializer::readEmSoundData));
    }
}
