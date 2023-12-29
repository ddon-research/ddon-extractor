package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.CaughtDamageRate;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.CaughtDamageRateTbl;

public class CaughtDamageRateTblDeserializer extends ClientResourceFileDeserializer {
    public CaughtDamageRateTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CaughtDamageRate readCaughtDamageRate(FileReader fileReader) {
        return new CaughtDamageRate(fileReader.readFloat());
    }

    @Override
    protected CaughtDamageRateTbl parseClientResourceFile(FileReader fileReader) {
        return new CaughtDamageRateTbl(fileReader.readArray(CaughtDamageRateTblDeserializer::readCaughtDamageRate));
    }
}
