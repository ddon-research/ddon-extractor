package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageCustomParts;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageCustomPartsFilter;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageCustomPartsInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageCustomPartsParam;

public class StageCustomPartsDeserializer extends ClientResourceFileDeserializer {
    public StageCustomPartsDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected StageCustomParts parseClientResourceFile(BufferReader bufferReader) {
        return new StageCustomParts(
                readStageCustomPartsParam(bufferReader),
                bufferReader.readArray(StageCustomPartsDeserializer::readStageCustomPartsInfo),
                bufferReader.readArray(StageCustomPartsDeserializer::readStageCustomPartsFilter)
        );
    }
}
