package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CalcDamageAtdmAdj;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CalcDamageAtdmAdjTbl;

import java.nio.file.Path;

public class CalcDamageAtdmAdjTblDeserializer extends ClientResourceFileDeserializer<CalcDamageAtdmAdjTbl> {


    private static CalcDamageAtdmAdj readCalcDamageAtdmAdj(BufferReader bufferReader) {
        return new CalcDamageAtdmAdj(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected CalcDamageAtdmAdjTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CalcDamageAtdmAdjTbl(bufferReader.readArray(CalcDamageAtdmAdjTblDeserializer::readCalcDamageAtdmAdj));
    }
}
