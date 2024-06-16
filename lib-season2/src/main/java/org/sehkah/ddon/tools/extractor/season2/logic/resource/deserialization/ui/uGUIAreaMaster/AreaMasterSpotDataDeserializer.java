package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDataList;

import java.nio.file.Path;

public class AreaMasterSpotDataDeserializer extends ClientResourceFileDeserializer<AreaMasterSpotDataList> {
    private static AreaMasterSpotData readAreaMasterSpotData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long SpotId = bufferReader.readUnsignedInteger();
        long CategoryNo = bufferReader.readUnsignedInteger();
        long MessageId = bufferReader.readUnsignedInteger();
        int StageNoMap = bufferReader.readSignedInteger();
        float PosX = bufferReader.readFloat();
        float PosY = bufferReader.readFloat();
        float PosZ = bufferReader.readFloat();
        int ImageId = bufferReader.readUnsignedShort();
        int RecommendLevel = bufferReader.readUnsignedByte();
        int KeyType = bufferReader.readUnsignedByte();
        int MaskType = bufferReader.readUnsignedByte();
        boolean PosHide = bufferReader.readBoolean();

        Translation SpotName = null;
        Translation CategoryName = null;
        Translation StageName = null;
        if (lookupUtil != null) {
            SpotName = lookupUtil.getSpotName(SpotId);
            CategoryName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.SPOT_CATEGORY.getFilePath(), (int) (CategoryNo - 1));
            StageName = lookupUtil.getStageNameByStageNo(StageNoMap);
        }

        return new AreaMasterSpotData(SpotId, SpotName, CategoryNo, CategoryName, MessageId, StageNoMap, StageName, PosX, PosY, PosZ, ImageId, RecommendLevel, KeyType, MaskType, PosHide);
    }

    @Override
    protected AreaMasterSpotDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AreaMasterSpotDataList(bufferReader.readArray(AreaMasterSpotDataDeserializer::readAreaMasterSpotData, lookupUtil));
    }
}
