package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.StageMap;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.StageMapList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.StageMapParam;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.StageFlag;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class StageMapDeserializer extends ClientResourceFileDeserializer<StageMapList> {
    private static StageMapParam readParam(BufferReader reader) {
        return new StageMapParam(
                reader.readUnsignedInteger(),
                reader.readFloat(),
                reader.readNullTerminatedString(),
                reader.readVector3f()
        );
    }

    private static StageMap readStageMap(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int StageNo = bufferReader.readUnsignedShort();
        int PartsNum = bufferReader.readUnsignedShort();
        float OffsetY = bufferReader.readFloat();
        long StageFlg = bufferReader.readUnsignedInteger();
        Set<StageFlag> StageFlgType = BitUtil.extractBitSetUnsignedIntegerFlag(StageFlag::of, i -> 1 << i, StageFlg);
        List<StageMapParam> ParamList = bufferReader.readArray(StageMapDeserializer::readParam);
        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
        }

        return new StageMap(StageNo, StageName, PartsNum, OffsetY, StageFlg, StageFlgType, ParamList);
    }

    @Override
    protected StageMapList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageMapList(bufferReader.readArray(StageMapDeserializer::readStageMap, lookupUtil));
    }
}
