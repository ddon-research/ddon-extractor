package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.ShrinkBlowValue;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.ShrinkBlowValueList;

import java.nio.file.Path;

public class ShrinkBlowValueDeserializer extends ClientResourceFileDeserializer<ShrinkBlowValueList> {
    private static ShrinkBlowValue readShrinkBlowValue(BufferReader bufferReader) {
        return new ShrinkBlowValue(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected ShrinkBlowValueList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ShrinkBlowValueList(bufferReader.readArray(ShrinkBlowValueDeserializer::readShrinkBlowValue));
    }
}
