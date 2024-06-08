package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.CalcDamageAtdmAdj;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.CalcDamageAtdmAdjTbl;

public class CalcDamageAtdmAdjTblDeserializer extends ClientResourceFileDeserializer<CalcDamageAtdmAdjTbl> {


    private static CalcDamageAtdmAdj readCalcDamageAtdmAdj(BufferReader bufferReader) {
        return new CalcDamageAtdmAdj(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected CalcDamageAtdmAdjTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CalcDamageAtdmAdjTbl(bufferReader.readArray(CalcDamageAtdmAdjTblDeserializer::readCalcDamageAtdmAdj));
    }
}
