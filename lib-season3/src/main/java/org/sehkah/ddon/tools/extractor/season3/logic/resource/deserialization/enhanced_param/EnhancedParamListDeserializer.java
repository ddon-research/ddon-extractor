package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.enhanced_param;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipParamKind;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.enhanced_param.EnhancedData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.enhanced_param.EnhancedParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.enhanced_param.EnhancedParamList;

import java.nio.file.Path;

public class EnhancedParamListDeserializer extends ClientResourceFileDeserializer<EnhancedParamList> {
    private static EnhancedData readEnhancedData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long DTIID = bufferReader.readUnsignedInteger();
        int ParamId = bufferReader.readUnsignedByte();
        int ParamValue = bufferReader.readUnsignedShort();

        return new EnhancedData(DTIID, ParamId, ItemListEquipParamKind.of(ParamId), ParamValue);
    }

    private static EnhancedParam readEnhancedParam(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnhancedParam(bufferReader.readArray(EnhancedParamListDeserializer::readEnhancedData, lookupUtil));
    }

    @Override
    protected EnhancedParamList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnhancedParamList(bufferReader.readArray(EnhancedParamListDeserializer::readEnhancedParam, lookupUtil));
    }
}
