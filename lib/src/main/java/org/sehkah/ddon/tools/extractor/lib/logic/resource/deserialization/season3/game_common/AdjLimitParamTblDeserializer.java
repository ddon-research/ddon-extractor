package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AdjLimitParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AdjLimitParamTbl;

public class AdjLimitParamTblDeserializer extends ClientResourceFileDeserializer {
    public AdjLimitParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AdjLimitParam readAdjLimitParam(FileReader fileReader) {
        return new AdjLimitParam(
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(7, FileReader::readFloat),
                fileReader.readFixedLengthArray(7, FileReader::readFloat),
                fileReader.readFixedLengthArray(7, FileReader::readFloat),
                fileReader.readFixedLengthArray(7, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readFixedLengthArray(5, FileReader::readFloat),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected AdjLimitParamTbl parseClientResourceFile(FileReader fileReader) {
        return new AdjLimitParamTbl(fileReader.readArray(AdjLimitParamTblDeserializer::readAdjLimitParam));
    }
}
