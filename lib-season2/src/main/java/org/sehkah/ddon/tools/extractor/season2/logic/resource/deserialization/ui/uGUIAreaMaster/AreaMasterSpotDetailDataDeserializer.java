package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailDataList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.SpotEnemyData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.SpotItemData;

import java.nio.file.Path;

public class AreaMasterSpotDetailDataDeserializer extends ClientResourceFileDeserializer<AreaMasterSpotDetailDataList> {


    private static SpotEnemyData readSpotEnemyData(BufferReader bufferReader) {
        return new SpotEnemyData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    private static SpotItemData readSpotItemData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ItemId = bufferReader.readUnsignedInteger();
        Translation ItemName = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getItemName(ItemId);
        }
        boolean IsFeature = bufferReader.readBoolean();
        boolean IsCannotPawnTake = bufferReader.readBoolean();

        return new SpotItemData(ItemId, ItemName, IsFeature, IsCannotPawnTake);
    }

    private static AreaMasterSpotDetailData readAreaMasterSpotDetailData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        return new AreaMasterSpotDetailData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotItemData, lookupUtil),
                bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotEnemyData)
        );
    }

    @Override
    protected AreaMasterSpotDetailDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AreaMasterSpotDetailDataList(bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readAreaMasterSpotDetailData, lookupUtil));
    }
}
