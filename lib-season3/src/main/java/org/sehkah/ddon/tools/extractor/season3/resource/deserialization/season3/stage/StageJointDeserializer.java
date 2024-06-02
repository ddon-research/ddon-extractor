package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.StageJoint;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.StageJointInfo;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.StageJointParam;

import java.util.List;
import java.util.stream.IntStream;

public class StageJointDeserializer extends ClientResourceFileDeserializer {
    public StageJointDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }


    private static StageJointInfo readStageJointInfo(BufferReader bufferReader) {
        return new StageJointInfo(
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
                bufferReader.readFixedLengthArray(16, BufferReader::readSignedByte),
                bufferReader.readColor(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readFixedLengthArray(3, BufferReader::readUnsignedLong),
                bufferReader.readUnsignedLong(),
                bufferReader.readNullTerminatedString()
        );
    }

    private static StageJointParam readStageJointParam(BufferReader bufferReader) {
        float StartX = bufferReader.readFloat();
        float StartZ = bufferReader.readFloat();
        float DeltaX = bufferReader.readFloat();
        float DeltaZ = bufferReader.readFloat();
        int AreaNumX = (int) bufferReader.readUnsignedInteger();
        int AreaNumZ = (int) bufferReader.readUnsignedInteger();

        List<List<Byte>> Area = IntStream.range(0, AreaNumX)
                .mapToObj(i -> bufferReader.readFixedLengthArray(AreaNumZ, BufferReader::readSignedByte))
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
    protected StageJoint parseClientResourceFile(BufferReader bufferReader) {
        return new StageJoint(
                readStageJointParam(bufferReader),
                bufferReader.readArray(StageJointDeserializer::readStageJointInfo),
                readStageJointInfo(bufferReader)
        );
    }
}
