package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.AdjLimitParam;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.AdjLimitParamTbl;

import java.nio.file.Path;

public class AdjLimitParamTblDeserializer extends ClientResourceFileDeserializer<AdjLimitParamTbl> {
    private static AdjLimitParam readAdjLimitParam(BufferReader bufferReader) {
        return new AdjLimitParam(
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(7, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected AdjLimitParamTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AdjLimitParamTbl(bufferReader.readArray(AdjLimitParamTblDeserializer::readAdjLimitParam));
    }
}
