package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.Human;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Human.CatchInfoParam;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Human.CatchInfoParamTbl;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Human.meta.CatchType;

import java.nio.file.Path;
import java.util.Set;

// Works for both v18 (season 2) + v19 (season 3)
public class CatchInfoParamTblDeserializer extends ClientResourceFileDeserializer<CatchInfoParamTbl> {
    private static CatchInfoParam readCatchInfoParam(BufferReader bufferReader) {
        long CatchInfoType = bufferReader.readUnsignedInteger();
        Set<CatchType> CatchTypes = BitUtil.extractBitSetUnsignedIntegerFlag(CatchType::of, i -> 1 << i, CatchInfoType);
        long CatchActionTblNo = bufferReader.readUnsignedInteger();
        boolean IsConst = bufferReader.readBoolean();
        boolean RevAdjust = bufferReader.readBoolean();
        boolean ConstScaleOff = bufferReader.readBoolean();
        long ConstJointNo = bufferReader.readUnsignedInteger();
        float LoopTimer = bufferReader.readFloat();
        int LeverGachaPoint = bufferReader.readSignedInteger();
        boolean IsCheckSlaveDist = bufferReader.readBoolean();
        float CheckSlaveDist = bufferReader.readFloat();

        return new CatchInfoParam(CatchInfoType, CatchTypes, CatchActionTblNo, IsConst, RevAdjust, ConstScaleOff, ConstJointNo, LoopTimer, LeverGachaPoint, IsCheckSlaveDist, CheckSlaveDist);
    }

    @Override
    protected CatchInfoParamTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CatchInfoParamTbl(bufferReader.readArray(CatchInfoParamTblDeserializer::readCatchInfoParam));
    }
}
