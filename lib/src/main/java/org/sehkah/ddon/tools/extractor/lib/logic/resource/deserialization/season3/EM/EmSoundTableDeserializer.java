package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EmSound;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EmSoundTable;

public class EmSoundTableDeserializer extends ClientResourceFileDeserializer {
    public EmSoundTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmSound readEmSoundData(FileReader fileReader) {
        return new EmSound(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected EmSoundTable parseClientResourceFile(FileReader fileReader) {
        return new EmSoundTable(fileReader.readArray(EmSoundTableDeserializer::readEmSoundData));
    }
}
