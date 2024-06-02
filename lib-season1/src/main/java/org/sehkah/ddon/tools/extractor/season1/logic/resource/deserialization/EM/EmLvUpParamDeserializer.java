package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.EmLvUpParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.EmLvUpParamList;

public class EmLvUpParamDeserializer extends ClientResourceFileDeserializer {
    public EmLvUpParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmLvUpParam readEmLvUpParam(BufferReader bufferReader) {
        return new EmLvUpParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(10, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(10, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(10, BufferReader::readFloat),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected EmLvUpParamList parseClientResourceFile(BufferReader bufferReader) {
        return new EmLvUpParamList(bufferReader.readArray(EmLvUpParamDeserializer::readEmLvUpParam));
    }
}
