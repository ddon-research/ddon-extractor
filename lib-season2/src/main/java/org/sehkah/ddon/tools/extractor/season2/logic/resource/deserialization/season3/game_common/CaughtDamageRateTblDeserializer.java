package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.CaughtDamageRate;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.CaughtDamageRateTbl;

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
