package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CalcDamageAtdmAdjRate;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CalcDamageAtdmAdjRateTbl;

public class CalcDamageAtdmAdjRateTblDeserializer extends ClientResourceFileDeserializer<CalcDamageAtdmAdjRateTbl> {


    private static CalcDamageAtdmAdjRate readCalcDamageAtdmAdjRate(BufferReader bufferReader) {
        return new CalcDamageAtdmAdjRate(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected CalcDamageAtdmAdjRateTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CalcDamageAtdmAdjRateTbl(bufferReader.readArray(CalcDamageAtdmAdjRateTblDeserializer::readCalcDamageAtdmAdjRate));
    }
}
