package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.AreaInfoStage;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.AreaInfoStageList;

import java.nio.file.Path;

public class AreaInfoStageDeserializer extends ClientResourceFileDeserializer<AreaInfoStageList> {
    private static AreaInfoStage readAreaInfoStage(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long StageNo = bufferReader.readUnsignedInteger();
        long AreaId = bufferReader.readUnsignedInteger();
        Translation AreaName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.AREA_LIST.getFilePath(), (int) (AreaId - 1));
        }

        return new AreaInfoStage(StageNo, AreaId, AreaName);
    }

    @Override
    protected AreaInfoStageList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AreaInfoStageList(bufferReader.readArray(br -> readAreaInfoStage(br, lookupUtil)));
    }
}
