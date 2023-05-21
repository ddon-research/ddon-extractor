package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.EM.EmLvUpParam;

import java.util.List;

public class EmLvUpParamDeserializer extends ClientResourceFileDeserializer<List<EmLvUpParam>> {
    public EmLvUpParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmLvUpParam readEntity(FileReader fileReader) {
        return new EmLvUpParam(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(10),
                fileReader.readFloat(10),
                fileReader.readFloat(10),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected List<EmLvUpParam> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(EmLvUpParamDeserializer::readEntity);
    }
}
