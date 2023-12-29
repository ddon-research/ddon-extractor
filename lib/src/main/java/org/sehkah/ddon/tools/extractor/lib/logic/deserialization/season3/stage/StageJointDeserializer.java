package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.StageJoint;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.StageJointInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.StageJointParam;

import java.util.List;
import java.util.stream.IntStream;

public class StageJointDeserializer extends ClientResourceFileDeserializer {
    public StageJointDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }


    private static StageJointInfo readStageJointInfo(FileReader fileReader) {
        return new StageJointInfo(
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
                fileReader.readFixedLengthArray(16, FileReader::readSignedByte),
                fileReader.readColor(),
                fileReader.readNullTerminatedString(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readFixedLengthArray(3, FileReader::readUnsignedLong),
                fileReader.readUnsignedLong(),
                fileReader.readNullTerminatedString()
        );
    }

    private static StageJointParam readStageJointParam(FileReader fileReader) {
        float StartX = fileReader.readFloat();
        float StartZ = fileReader.readFloat();
        float DeltaX = fileReader.readFloat();
        float DeltaZ = fileReader.readFloat();
        int AreaNumX = (int) fileReader.readUnsignedInteger();
        int AreaNumZ = (int) fileReader.readUnsignedInteger();

        List<List<Byte>> Area = IntStream.range(0, AreaNumX)
                .mapToObj(i -> fileReader.readFixedLengthArray(AreaNumZ, FileReader::readSignedByte))
                .toList();

        return new StageJointParam(
                StartX,
                StartZ,
                DeltaX,
                DeltaZ,
                AreaNumX,
                AreaNumZ,
                Area
        );
    }

    @Override
    protected StageJoint parseClientResourceFile(FileReader fileReader) {
        return new StageJoint(
                readStageJointParam(fileReader),
                fileReader.readArray(StageJointDeserializer::readStageJointInfo),
                readStageJointInfo(fileReader)
        );
    }
}
