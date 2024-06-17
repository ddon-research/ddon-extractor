package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.DungeonMarker;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.DungeonMarkerPosition;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.DungeonMarkerWarpInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.DungeonMarkerWarpInfoIndex;

import java.nio.file.Path;
import java.util.List;

public class DungeonMarkerDeserializer extends ClientResourceFileDeserializer<DungeonMarker> {
    private static DungeonMarkerPosition readDungeonMarkerPosition(BufferReader bufferReader) {
        return new DungeonMarkerPosition(bufferReader.readVector3f());
    }

    private static DungeonMarkerWarpInfoIndex readDungeonMarkerWarpInfoIndex(BufferReader bufferReader) {
        return new DungeonMarkerWarpInfoIndex(bufferReader.readUnsignedByte());
    }

    private static DungeonMarkerWarpInfo readDungeonMarkerWarpInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        short GroupNo = bufferReader.readSignedShort();
        int TargetStageNo = bufferReader.readUnsignedShort();
        short TargetGroupNo = bufferReader.readSignedShort();
        List<DungeonMarkerWarpInfoIndex> PosIndex = bufferReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerWarpInfoIndex);

        Translation TargetStageName = null;
        if (lookupUtil != null) {
            TargetStageName = lookupUtil.getStageNameByStageNo(TargetStageNo);
        }

        return new DungeonMarkerWarpInfo(GroupNo, TargetStageNo, TargetStageName, TargetGroupNo, PosIndex);
    }

    @Override
    protected DungeonMarker parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        int WarpStageNo = bufferReader.readUnsignedShort();
        List<DungeonMarkerWarpInfo> WarpInfoList = bufferReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerWarpInfo, lookupUtil);
        List<DungeonMarkerPosition> PositionList = bufferReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerPosition);

        Translation WarpStageName = null;
        if (lookupUtil != null) {
            WarpStageName = lookupUtil.getStageNameByStageNo(WarpStageNo);
        }

        return new DungeonMarker(WarpStageNo, WarpStageName, WarpInfoList, PositionList);
    }
}
