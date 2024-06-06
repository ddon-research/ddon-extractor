package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.CalcDamageLvAdj;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.CalcDamageLvAdjTbl;

public class CalcDamageLvAdjTblDeserializer extends ClientResourceFileDeserializer {


    private static CalcDamageLvAdj readCalcDamageLvAdj(BufferReader bufferReader) {
        return new CalcDamageLvAdj(
                bufferReader.readSignedShort(),
                bufferReader.readFixedLengthArray(6, BufferReader::readFloat)
        );
    }

    @Override
    protected CalcDamageLvAdjTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CalcDamageLvAdjTbl(bufferReader.readArray(CalcDamageLvAdjTblDeserializer::readCalcDamageLvAdj));
    }
}
