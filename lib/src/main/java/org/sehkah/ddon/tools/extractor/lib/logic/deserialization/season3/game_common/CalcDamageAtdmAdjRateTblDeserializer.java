package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.CalcDamageAtdmAdjRate;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.CalcDamageAtdmAdjRateTbl;

public class CalcDamageAtdmAdjRateTblDeserializer extends ClientResourceFileDeserializer {
    public CalcDamageAtdmAdjRateTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CalcDamageAtdmAdjRate readCalcDamageAtdmAdjRate(FileReader fileReader) {
        return new CalcDamageAtdmAdjRate(
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected CalcDamageAtdmAdjRateTbl parseClientResourceFile(FileReader fileReader) {
        return new CalcDamageAtdmAdjRateTbl(fileReader.readArray(CalcDamageAtdmAdjRateTblDeserializer::readCalcDamageAtdmAdjRate));
    }
}
