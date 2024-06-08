package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CaughtDamageRateRef;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CaughtDamageRateRefTbl;

import java.nio.file.Path;

public class CaughtDamageRateRefTblDeserializer extends ClientResourceFileDeserializer<CaughtDamageRateRefTbl> {


    private static CaughtDamageRateRef readCaughtDamageRateRef(BufferReader bufferReader) {
        return new CaughtDamageRateRef(bufferReader.readUnsignedInteger());
    }

    @Override
    protected CaughtDamageRateRefTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CaughtDamageRateRefTbl(bufferReader.readArray(CaughtDamageRateRefTblDeserializer::readCaughtDamageRateRef));
    }
}
