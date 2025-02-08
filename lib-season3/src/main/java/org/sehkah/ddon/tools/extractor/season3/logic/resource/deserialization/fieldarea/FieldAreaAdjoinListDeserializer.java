package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.AdjoinInfoVector3;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.FieldAreaAdjoinList;

import java.nio.file.Path;
import java.util.List;

public class FieldAreaAdjoinListDeserializer extends ClientResourceFileDeserializer<FieldAreaAdjoinList> {
    private static AdjoinInfoVector3 readAdjoinInfoVector3(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        Vector3f Pos = bufferReader.readVector3f();
        long QuestId = bufferReader.readUnsignedInteger();
        long FlagId = bufferReader.readUnsignedInteger();

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new AdjoinInfoVector3(Pos, QuestId, QuestName, FlagId);
    }

    private static AdjoinInfo readAdjoinInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        short DestinationStageNo = bufferReader.readSignedShort();
        short NextStageNo = bufferReader.readSignedShort();
        List<AdjoinInfoVector3> Positions = bufferReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfoVector3, lookupUtil);
        int Priority = bufferReader.readUnsignedByte();

        Translation DestinationStageName = null;
        Translation NextStageName = null;
        if (lookupUtil != null) {
            DestinationStageName = lookupUtil.getStageNameByStageNo(DestinationStageNo);
            NextStageName = lookupUtil.getStageNameByStageNo(NextStageNo);
        }

        return new AdjoinInfo(DestinationStageNo, DestinationStageName, NextStageNo, NextStageName, Positions, Priority);
    }

    @Override
    protected FieldAreaAdjoinList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        short FieldAreaId = bufferReader.readSignedShort();
        Translation FieldAreaName = null;
        if (lookupUtil != null) {
            FieldAreaName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.FIELD_AREA_NAME.getFilePath(), (int) (FieldAreaId - 1L));
        }
        List<AdjoinInfo> Array = bufferReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfo, lookupUtil);

        return new FieldAreaAdjoinList(FieldAreaId, FieldAreaName, Array);
    }
}
