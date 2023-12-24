package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.CalcDamageAtdmAdj;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.CalcDamageAtdmAdjTbl;

public class CalcDamageAtdmAdjTblDeserializer extends ClientResourceFileDeserializer {
    public CalcDamageAtdmAdjTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CalcDamageAtdmAdj readCalcDamageAtdmAdj(FileReader fileReader) {
        return new CalcDamageAtdmAdj(
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected CalcDamageAtdmAdjTbl parseClientResourceFile(FileReader fileReader) {
        return new CalcDamageAtdmAdjTbl(fileReader.readArray(CalcDamageAtdmAdjTblDeserializer::readCalcDamageAtdmAdj));
    }
}
