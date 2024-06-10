package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.AreaInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.AreaInfoList;

import java.nio.file.Path;
import java.util.List;

public class AreaInfoDeserializer extends ClientResourceFileDeserializer<AreaInfoList> {
    private static AreaInfo readAreaInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long AreaId = bufferReader.readUnsignedInteger();
        Translation AreaName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.AREA_LIST.getFilePath(), (int) (AreaId - 1));
        }
        int PosX = bufferReader.readSignedInteger();
        int PosY = bufferReader.readSignedInteger();

        return new AreaInfo(AreaId, AreaName, PosX, PosY);
    }

    @Override
    protected AreaInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        List<AreaInfo> areaInfos = bufferReader.readArray(AreaInfoDeserializer::readAreaInfo, lookupUtil);

        return new AreaInfoList(areaInfos);
    }
}
