package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.JumpPosition2;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.StageAdjoinList2;

import java.nio.file.Path;
import java.util.List;

public class StageAdjoinList2Deserializer extends ClientResourceFileDeserializer<StageAdjoinList2> {
    private static JumpPosition2 readJumpPosition(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ID = bufferReader.readUnsignedInteger();
        Vector3f Pos = bufferReader.readVector3f();
        long QuestId = bufferReader.readUnsignedInteger();
        long FlagId = bufferReader.readUnsignedInteger();
        long LayoutFlagId = bufferReader.readUnsignedInteger();

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new JumpPosition2(ID, Pos, QuestId, QuestName, FlagId, LayoutFlagId);
    }

    private static AdjoinInfoIndex readAdjoinInfoIndex(BufferReader bufferReader) {
        return new AdjoinInfoIndex(
                bufferReader.readUnsignedShort()
        );
    }

    public static AdjoinInfo readAdjoinInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        List<AdjoinInfoIndex> IndexArray = bufferReader.readArray(StageAdjoinList2Deserializer::readAdjoinInfoIndex);
        int DestinationStageNo = bufferReader.readUnsignedShort();
        int NextStageNo = bufferReader.readUnsignedShort();
        int Priority = bufferReader.readUnsignedByte();

        Translation DestinationStageName = null;
        Translation NextStageName = null;
        if (lookupUtil != null) {
            DestinationStageName = lookupUtil.getStageNameByStageNo(DestinationStageNo);
            NextStageName = lookupUtil.getStageNameByStageNo(NextStageNo);
        }

        return new AdjoinInfo(IndexArray, DestinationStageNo, DestinationStageName, NextStageNo, NextStageName, Priority);
    }

    @Override
    protected StageAdjoinList2 parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        int StageNo = bufferReader.readUnsignedShort();
        List<AdjoinInfo> AdjoinInfoArray = bufferReader.readArray(StageAdjoinList2Deserializer::readAdjoinInfo, lookupUtil);
        List<JumpPosition2> JumpPositionArray = bufferReader.readArray(StageAdjoinList2Deserializer::readJumpPosition, lookupUtil);

        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
        }

        return new StageAdjoinList2(StageNo, StageName, AdjoinInfoArray, JumpPositionArray);
    }
}
