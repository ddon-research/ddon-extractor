package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CalcDamageLvAdj;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CalcDamageLvAdjTbl;

public class CalcDamageLvAdjTblDeserializer extends ClientResourceFileDeserializer {
    public CalcDamageLvAdjTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CalcDamageLvAdj readCalcDamageLvAdj(FileReader fileReader) {
        return new CalcDamageLvAdj(
                fileReader.readSignedShort(),
                fileReader.readFixedLengthArray(6, FileReader::readFloat)
        );
    }

    @Override
    protected CalcDamageLvAdjTbl parseClientResourceFile(FileReader fileReader) {
        return new CalcDamageLvAdjTbl(fileReader.readArray(CalcDamageLvAdjTblDeserializer::readCalcDamageLvAdj));
    }
}
