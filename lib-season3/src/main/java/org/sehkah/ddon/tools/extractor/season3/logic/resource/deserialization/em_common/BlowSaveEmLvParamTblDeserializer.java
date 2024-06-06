package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.em_common.BlowSaveEmLvParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.em_common.BlowSaveEmLvParamTbl;

public class BlowSaveEmLvParamTblDeserializer extends ClientResourceFileDeserializer {


    private static BlowSaveEmLvParam readBlowSaveEmLvParam(BufferReader bufferReader) {
        return new BlowSaveEmLvParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected BlowSaveEmLvParamTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new BlowSaveEmLvParamTbl(bufferReader.readArray(BlowSaveEmLvParamTblDeserializer::readBlowSaveEmLvParam));
    }
}
