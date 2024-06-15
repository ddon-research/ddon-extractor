package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.AreaInfoJointArea;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.AreaInfoJointAreaList;

import java.nio.file.Path;

public class AreaInfoJointAreaDeserializer extends ClientResourceFileDeserializer<AreaInfoJointAreaList> {
    private static AreaInfoJointArea readAreaInfoJointArea(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long MAJAId = bufferReader.readUnsignedInteger();
        long AreaId = bufferReader.readUnsignedInteger();
        Translation AreaName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.AREA_LIST.getFilePath(), (int) AreaId);
        }

        return new AreaInfoJointArea(MAJAId, AreaId, AreaName);
    }

    @Override
    protected AreaInfoJointAreaList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AreaInfoJointAreaList(bufferReader.readArray(br -> readAreaInfoJointArea(br, lookupUtil)));
    }
}
