package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.AreaInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.AreaInfoList;

import java.nio.file.Path;

/**
 * Season 1, season 2 & season 3 all share the same header version 2, but season 1 lacks the position data for areas.
 */
public class AreaInfoDeserializer extends ClientResourceFileDeserializer<AreaInfoList> {
    private static AreaInfo readAreaInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long AreaId = bufferReader.readUnsignedInteger();
        Translation AreaName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.AREA_LIST.getFilePath(), (int) (AreaId - 1));
        }

        return new AreaInfo(AreaId, AreaName);
    }

    @Override
    protected AreaInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AreaInfoList(bufferReader.readArray(AreaInfoDeserializer::readAreaInfo, lookupUtil));
    }
}
