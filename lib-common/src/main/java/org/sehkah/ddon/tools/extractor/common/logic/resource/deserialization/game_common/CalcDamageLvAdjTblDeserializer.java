package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CalcDamageLvAdj;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CalcDamageLvAdjTbl;

import java.nio.file.Path;

public class CalcDamageLvAdjTblDeserializer extends ClientResourceFileDeserializer<CalcDamageLvAdjTbl> {


    private static CalcDamageLvAdj readCalcDamageLvAdj(BufferReader bufferReader) {
        return new CalcDamageLvAdj(
                bufferReader.readSignedShort(),
                bufferReader.readFixedLengthArray(6, BufferReader::readFloat)
        );
    }

    @Override
    protected CalcDamageLvAdjTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CalcDamageLvAdjTbl(bufferReader.readArray(CalcDamageLvAdjTblDeserializer::readCalcDamageLvAdj));
    }
}
