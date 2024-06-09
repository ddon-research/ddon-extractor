package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.pawn;

import org.sehkah.ddon.tools.extractor.api.datatype.Sphere;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.pawn.AISensor;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.pawn.AISensorNodeRes;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.pawn.meta.AISensorStatusFlagType;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class AISensorDeserializer extends ClientResourceFileDeserializer<AISensor> {
    private static AISensorNodeRes readAISensorNodeRes(BufferReader bufferReader) {
        Sphere Sphere = bufferReader.readSphere();
        Vector3f Dir = bufferReader.readVector3f();
        float EffectiveAngle = bufferReader.readFloat();
        List<Long> CategoryFlag = bufferReader.readArray(BufferReader::readUnsignedInteger);
        long GroupFlag = bufferReader.readUnsignedInteger();
        long UserFlag = bufferReader.readUnsignedInteger();
        long StatusFlag = bufferReader.readUnsignedInteger();
        //TODO: pull bitshift 1 << i into a top-level function
        Set<AISensorStatusFlagType> StatusFlagType = BitUtil.extractBitSetUnsignedIntegerFlag(AISensorStatusFlagType::of, i -> 1 << i, StatusFlag);
        int JntNo = bufferReader.readSignedInteger();

        return new AISensorNodeRes(Sphere, Dir, EffectiveAngle, CategoryFlag, GroupFlag, UserFlag, StatusFlag, StatusFlagType, JntNo);
    }

    @Override
    protected AISensor parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AISensor(bufferReader.readArray(AISensorDeserializer::readAISensorNodeRes));
    }
}
