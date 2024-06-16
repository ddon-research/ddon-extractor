package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.LandAreaInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.LandInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.LandInfoList;

import java.nio.file.Path;
import java.util.List;

public class LandInfoDeserializer extends ClientResourceFileDeserializer<LandInfoList> {
    private static LandAreaInfo readLandAreaInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long AreaId = bufferReader.readUnsignedInteger();
        Translation AreaName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getAreaName((int) AreaId);
        }
        return new LandAreaInfo(AreaId, AreaName);
    }

    private static LandInfo readLandInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long LandId = bufferReader.readUnsignedInteger();
        Translation LandName = null;
        if (lookupUtil != null) {
            LandName = lookupUtil.getLandName((int) LandId);
        }
        List<LandAreaInfo> AreaArray = bufferReader.readArray(LandInfoDeserializer::readLandAreaInfo, lookupUtil);

        return new LandInfo(LandId, LandName, AreaArray);
    }

    @Override
    protected LandInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new LandInfoList(bufferReader.readArray(LandInfoDeserializer::readLandInfo, lookupUtil));
    }
}
