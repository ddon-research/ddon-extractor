package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.CaughtDamageRateRef;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.CaughtDamageRateRefTbl;

public class CaughtDamageRateRefTblDeserializer extends ClientResourceFileDeserializer {
    public CaughtDamageRateRefTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CaughtDamageRateRef readCaughtDamageRateRef(FileReader fileReader) {
        return new CaughtDamageRateRef(fileReader.readUnsignedInteger());
    }

    @Override
    protected CaughtDamageRateRefTbl parseClientResourceFile(FileReader fileReader) {
        return new CaughtDamageRateRefTbl(fileReader.readArray(CaughtDamageRateRefTblDeserializer::readCaughtDamageRateRef));
    }
}
