package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.CalcDamageLvAdj;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.CalcDamageLvAdjTbl;

public class CalcDamageLvAdjTblDeserializer extends ClientResourceFileDeserializer {
    public CalcDamageLvAdjTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CalcDamageLvAdj readCalcDamageLvAdj(BufferReader bufferReader) {
        return new CalcDamageLvAdj(
                bufferReader.readSignedShort(),
                bufferReader.readFixedLengthArray(6, BufferReader::readFloat)
        );
    }

    @Override
    protected CalcDamageLvAdjTbl parseClientResourceFile(BufferReader bufferReader) {
        return new CalcDamageLvAdjTbl(bufferReader.readArray(CalcDamageLvAdjTblDeserializer::readCalcDamageLvAdj));
    }
}
