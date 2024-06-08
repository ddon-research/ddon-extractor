package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.job;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.job.StaminaDecList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.job.StaminaDecParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.job.StaminaDecTbl;

import java.nio.file.Path;

public class StaminaDecTblDeserializer extends ClientResourceFileDeserializer<StaminaDecTbl> {


    private static StaminaDecParam readStaminaDecParam(BufferReader bufferReader) {
        return new StaminaDecParam(bufferReader.readFloat());
    }

    private static StaminaDecList readStaminaDecList(BufferReader bufferReader) {
        return new StaminaDecList(
                bufferReader.readArray(StaminaDecTblDeserializer::readStaminaDecParam),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StaminaDecTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StaminaDecTbl(bufferReader.readArray(StaminaDecTblDeserializer::readStaminaDecList));
    }
}
