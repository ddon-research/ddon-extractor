package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.em_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.em_common.EmDamageDirInfo;

import java.util.List;

public class EmDamageDirInfoDeserializer extends ClientResourceFileDeserializer<List<EmDamageDirInfo>> {
    public EmDamageDirInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmDamageDirInfo readEntity(FileReader fileReader) {
        return new EmDamageDirInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected List<EmDamageDirInfo> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(EmDamageDirInfoDeserializer::readEntity);
    }
}
