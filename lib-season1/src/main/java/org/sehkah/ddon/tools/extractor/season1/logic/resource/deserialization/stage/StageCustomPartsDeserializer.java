package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageCustomParts;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageCustomPartsFilter;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageCustomPartsInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageCustomPartsParam;

import java.nio.file.Path;

public class StageCustomPartsDeserializer extends ClientResourceFileDeserializer<StageCustomParts> {


    private static StageCustomPartsInfo readStageCustomPartsInfo(BufferReader bufferReader) {
        return new StageCustomPartsInfo(
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),

                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readColor(),

                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readFixedLengthArray(3, BufferReader::readUnsignedLong),
                bufferReader.readUnsignedLong(),

                bufferReader.readJapaneseNullTerminatedString()
        );
    }

    private static StageCustomPartsFilter readStageCustomPartsFilter(BufferReader bufferReader) {
        return new StageCustomPartsFilter(
                bufferReader.readNullTerminatedString()
        );
    }

    private static StageCustomPartsParam readStageCustomPartsParam(BufferReader bufferReader) {
        return new StageCustomPartsParam(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected StageCustomParts parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageCustomParts(
                readStageCustomPartsParam(bufferReader),
                bufferReader.readArray(StageCustomPartsDeserializer::readStageCustomPartsInfo),
                bufferReader.readArray(StageCustomPartsDeserializer::readStageCustomPartsFilter)
        );
    }
}
