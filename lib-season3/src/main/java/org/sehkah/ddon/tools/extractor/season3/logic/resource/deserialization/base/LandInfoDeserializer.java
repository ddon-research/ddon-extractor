package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.LandAreaInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.LandAreaInfoList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.LandAreaInfoGameMode;

import java.nio.file.Path;
import java.util.List;

public class LandInfoDeserializer extends ClientResourceFileDeserializer<LandAreaInfoList> {
    private static LandAreaInfo readLandAreaInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long LandId = bufferReader.readUnsignedInteger();
        String LandName = null;
        if (lookupUtil != null) {
            LandName = lookupUtil.getMessage(GUIMessageLookupTable.LAND_NAME.getFilePath(), LandId - 1);
        }
        boolean IsDispNews = bufferReader.readBoolean();
        int GameMode = bufferReader.readUnsignedByte();
        LandAreaInfoGameMode GameModeName = LandAreaInfoGameMode.of(GameMode);
        List<Long> AreaIds = bufferReader.readArray(BufferReader::readUnsignedInteger);

        return new LandAreaInfo(LandId, LandName, IsDispNews, GameMode, GameModeName, AreaIds);
    }

    @Override
    protected LandAreaInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new LandAreaInfoList(bufferReader.readArray(LandInfoDeserializer::readLandAreaInfo, lookupUtil));
    }
}
