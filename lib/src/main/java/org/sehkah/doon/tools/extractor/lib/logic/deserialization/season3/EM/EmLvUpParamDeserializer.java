package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.EM.EmLvUpParam;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.EM.EmLvUpParamList;

public class EmLvUpParamDeserializer extends ClientResourceFileDeserializer {
    public EmLvUpParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmLvUpParam readEmLvUpParam(FileReader fileReader) {
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
    protected EmLvUpParamList parseClientResourceFile(FileReader fileReader) {
        return new EmLvUpParamList(fileReader.readArray(EmLvUpParamDeserializer::readEmLvUpParam));
    }
}
