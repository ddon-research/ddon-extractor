package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CalcDamageAtdmAdj;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CalcDamageAtdmAdjTbl;

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
