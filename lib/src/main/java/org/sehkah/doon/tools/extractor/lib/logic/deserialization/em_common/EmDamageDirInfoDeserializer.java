package org.sehkah.doon.tools.extractor.lib.logic.deserialization.em_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.em_common.EmDamageDirInfo;

import java.util.List;

public class EmDamageDirInfoDeserializer extends FileDeserializer<List<EmDamageDirInfo>> {
    public EmDamageDirInfoDeserializer() {
        super(ClientResourceFile.rEmDamageDirInfo);
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
    protected List<EmDamageDirInfo> readObject(FileReader fileReader) {
        return fileReader.readArray(EmDamageDirInfoDeserializer::readEntity);
    }
}
