package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmLvUpParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmLvUpParamList;

import java.nio.file.Path;

public class EmLvUpParamDeserializer extends ClientResourceFileDeserializer<EmLvUpParamList> {


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
    protected EmLvUpParamList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmLvUpParamList(bufferReader.readArray(EmLvUpParamDeserializer::readEmLvUpParam));
    }
}
