package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.CaughtDamageRateRef;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.CaughtDamageRateRefTbl;

public class CaughtDamageRateRefTblDeserializer extends ClientResourceFileDeserializer {
    public CaughtDamageRateRefTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CaughtDamageRateRef readCaughtDamageRateRef(BufferReader bufferReader) {
        return new CaughtDamageRateRef(bufferReader.readUnsignedInteger());
    }

    @Override
    protected CaughtDamageRateRefTbl parseClientResourceFile(BufferReader bufferReader) {
        return new CaughtDamageRateRefTbl(bufferReader.readArray(CaughtDamageRateRefTblDeserializer::readCaughtDamageRateRef));
    }
}
