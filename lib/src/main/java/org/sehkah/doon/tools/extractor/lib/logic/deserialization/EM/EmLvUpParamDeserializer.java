package org.sehkah.doon.tools.extractor.lib.logic.deserialization.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.EM.EmLvUpParam;

import java.util.List;

public class EmLvUpParamDeserializer extends FileDeserializer<List<EmLvUpParam>> {
    public EmLvUpParamDeserializer() {
        super(ClientResourceFile.rEmLvUpParam);
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
    protected List<EmLvUpParam> readObject(FileReader fileReader) {
        return fileReader.readArray(EmLvUpParamDeserializer::readEntity);
    }
}
