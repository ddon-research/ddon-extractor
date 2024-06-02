package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.AdjLimitParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.AdjLimitParamTbl;

public class AdjLimitParamTblDeserializer extends ClientResourceFileDeserializer {
    public AdjLimitParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected AdjLimitParamTbl parseClientResourceFile(BufferReader bufferReader) {
        return new AdjLimitParamTbl(bufferReader.readArray(AdjLimitParamTblDeserializer::readAdjLimitParam));
    }
}
