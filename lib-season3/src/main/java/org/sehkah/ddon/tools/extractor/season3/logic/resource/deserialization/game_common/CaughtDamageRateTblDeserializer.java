package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CaughtDamageRate;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CaughtDamageRateTbl;

public class CaughtDamageRateTblDeserializer extends ClientResourceFileDeserializer<CaughtDamageRateTbl> {


    private static CaughtDamageRate readCaughtDamageRate(BufferReader bufferReader) {
        return new CaughtDamageRate(bufferReader.readFloat());
    }

    @Override
    protected CaughtDamageRateTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CaughtDamageRateTbl(bufferReader.readArray(CaughtDamageRateTblDeserializer::readCaughtDamageRate));
    }
}
