package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.AbilityData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.AbilityDataList;

public class AbilityDataDeserializer extends ClientResourceFileDeserializer {


    private static AbilityData readAbilityData(BufferReader bufferReader) {
        return new AbilityData(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected AbilityDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AbilityDataList(bufferReader.readArray(AbilityDataDeserializer::readAbilityData));
    }
}
