package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.AchievementData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.AchievementDataList;

public class AchievementDeserializer extends ClientResourceFileDeserializer {


    private static AchievementData readAchievementData(BufferReader bufferReader) {
        return new AchievementData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected AchievementDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AchievementDataList(bufferReader.readArray(AchievementDeserializer::readAchievementData));
    }
}
