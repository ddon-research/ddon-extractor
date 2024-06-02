package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.CalcDamageAtdmAdj;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.CalcDamageAtdmAdjTbl;

public class CalcDamageAtdmAdjTblDeserializer extends ClientResourceFileDeserializer {
    public CalcDamageAtdmAdjTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CalcDamageAtdmAdj readCalcDamageAtdmAdj(BufferReader bufferReader) {
        return new CalcDamageAtdmAdj(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected CalcDamageAtdmAdjTbl parseClientResourceFile(BufferReader bufferReader) {
        return new CalcDamageAtdmAdjTbl(bufferReader.readArray(CalcDamageAtdmAdjTblDeserializer::readCalcDamageAtdmAdj));
    }
}
