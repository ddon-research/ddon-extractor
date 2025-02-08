package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.JumpPosition;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.StageAdjoinList;

import java.nio.file.Path;
import java.util.List;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer<StageAdjoinList> {
    private static JumpPosition readJumpPosition(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        Vector3f Pos = bufferReader.readVector3f();
        long QuestId = bufferReader.readUnsignedInteger();
        long FlagId = bufferReader.readUnsignedInteger();

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new JumpPosition(Pos, QuestId, QuestName, FlagId);
    }

    private static AdjoinInfoIndex readAdjoinInfoIndex(BufferReader bufferReader) {
        return new AdjoinInfoIndex(
                bufferReader.readUnsignedShort()
        );
    }

    public static AdjoinInfo readAdjoinInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        List<AdjoinInfoIndex> IndexArray = bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfoIndex);
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
    protected StageAdjoinList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        int StageNo = bufferReader.readUnsignedShort();
        List<AdjoinInfo> AdjoinInfoArray = bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfo, lookupUtil);
        List<JumpPosition> JumpPositionArray = bufferReader.readArray(StageAdjoinListDeserializer::readJumpPosition, lookupUtil);

        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
        }

        return new StageAdjoinList(StageNo, StageName, AdjoinInfoArray, JumpPositionArray);
    }
}
