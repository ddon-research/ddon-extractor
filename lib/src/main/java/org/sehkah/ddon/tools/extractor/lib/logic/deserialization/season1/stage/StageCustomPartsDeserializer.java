package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season1.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season1.stage.StageCustomParts;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season1.stage.StageCustomPartsFilter;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season1.stage.StageCustomPartsInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season1.stage.StageCustomPartsParam;

public class StageCustomPartsDeserializer extends ClientResourceFileDeserializer {
    public StageCustomPartsDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageCustomPartsInfo readStageCustomPartsInfo(FileReader fileReader) {
        return new StageCustomPartsInfo(
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),

                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readColor(),

                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readFixedLengthArray(3, FileReader::readUnsignedLong),
                fileReader.readUnsignedLong(),

                fileReader.readJapaneseNullTerminatedString()
        );
    }

    private static StageCustomPartsFilter readStageCustomPartsFilter(FileReader fileReader) {
        return new StageCustomPartsFilter(
                fileReader.readNullTerminatedString()
        );
    }

    private static StageCustomPartsParam readStageCustomPartsParam(FileReader fileReader) {
        return new StageCustomPartsParam(
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected StageCustomParts parseClientResourceFile(FileReader fileReader) {
        return new StageCustomParts(
                readStageCustomPartsParam(fileReader),
                fileReader.readArray(StageCustomPartsDeserializer::readStageCustomPartsInfo),
                fileReader.readArray(StageCustomPartsDeserializer::readStageCustomPartsFilter)
        );
    }
}
