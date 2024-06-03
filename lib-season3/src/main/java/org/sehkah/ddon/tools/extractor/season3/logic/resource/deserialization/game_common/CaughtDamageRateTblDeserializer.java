package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CaughtDamageRate;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CaughtDamageRateTbl;

public class CaughtDamageRateTblDeserializer extends ClientResourceFileDeserializer {
    public CaughtDamageRateTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CaughtDamageRate readCaughtDamageRate(BufferReader bufferReader) {
        return new CaughtDamageRate(bufferReader.readFloat());
    }

    @Override
    protected CaughtDamageRateTbl parseClientResourceFile(BufferReader bufferReader) {
        return new CaughtDamageRateTbl(bufferReader.readArray(CaughtDamageRateTblDeserializer::readCaughtDamageRate));
    }
}
