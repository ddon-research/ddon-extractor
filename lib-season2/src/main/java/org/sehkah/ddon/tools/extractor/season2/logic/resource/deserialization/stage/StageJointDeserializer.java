package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageJoint;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageJointInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageJointParam;

import java.util.List;
import java.util.stream.IntStream;

public class StageJointDeserializer extends ClientResourceFileDeserializer {


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
    protected StageJoint parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageJoint(
                readStageJointParam(bufferReader),
                bufferReader.readArray(StageJointDeserializer::readStageJointInfo),
                readStageJointInfo(bufferReader)
        );
    }
}
