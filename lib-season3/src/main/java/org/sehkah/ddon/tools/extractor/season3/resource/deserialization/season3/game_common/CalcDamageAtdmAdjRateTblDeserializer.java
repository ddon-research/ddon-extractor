package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.CalcDamageAtdmAdjRate;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.CalcDamageAtdmAdjRateTbl;

public class CalcDamageAtdmAdjRateTblDeserializer extends ClientResourceFileDeserializer {
    public CalcDamageAtdmAdjRateTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CalcDamageAtdmAdjRate readCalcDamageAtdmAdjRate(BufferReader bufferReader) {
        return new CalcDamageAtdmAdjRate(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected CalcDamageAtdmAdjRateTbl parseClientResourceFile(BufferReader bufferReader) {
        return new CalcDamageAtdmAdjRateTbl(bufferReader.readArray(CalcDamageAtdmAdjRateTblDeserializer::readCalcDamageAtdmAdjRate));
    }
}
