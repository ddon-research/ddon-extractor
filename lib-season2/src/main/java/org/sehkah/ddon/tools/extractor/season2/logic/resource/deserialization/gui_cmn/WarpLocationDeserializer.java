package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.WarpLocation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.WarpLocationList;

import java.nio.file.Path;

public class WarpLocationDeserializer extends ClientResourceFileDeserializer<WarpLocationList> {
    private static WarpLocation readWarpLocation(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long Id = bufferReader.readUnsignedInteger();
        long SortNo = bufferReader.readUnsignedInteger();
        long AreaId = bufferReader.readUnsignedInteger();
        long SpotId = bufferReader.readUnsignedInteger();
        int StageNo = bufferReader.readSignedInteger();
        long PosNo = bufferReader.readUnsignedInteger();
        int MapPosX = bufferReader.readUnsignedShort();
        int MapPosY = bufferReader.readUnsignedShort();
        int IconType = bufferReader.readUnsignedByte();
        Translation AreaName = null;
        Translation SpotName = null;
        Translation StageName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getAreaName((int) AreaId);
            SpotName = lookupUtil.getSpotName(SpotId);
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
        }

        return new WarpLocation(Id, SortNo, AreaId, AreaName, SpotId, SpotName, StageNo, StageName, PosNo, MapPosX, MapPosY, IconType);
    }

    @Override
    protected WarpLocationList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new WarpLocationList(bufferReader.readArray(WarpLocationDeserializer::readWarpLocation, lookupUtil));
    }
}
