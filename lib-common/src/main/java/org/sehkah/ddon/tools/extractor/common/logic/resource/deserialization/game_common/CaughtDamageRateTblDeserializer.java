package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CaughtDamageRate;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CaughtDamageRateTbl;

import java.nio.file.Path;

public class CaughtDamageRateTblDeserializer extends ClientResourceFileDeserializer<CaughtDamageRateTbl> {


    private static CaughtDamageRate readCaughtDamageRate(BufferReader bufferReader) {
        return new CaughtDamageRate(bufferReader.readFloat());
    }

    @Override
    protected CaughtDamageRateTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CaughtDamageRateTbl(bufferReader.readArray(CaughtDamageRateTblDeserializer::readCaughtDamageRate));
    }
}
