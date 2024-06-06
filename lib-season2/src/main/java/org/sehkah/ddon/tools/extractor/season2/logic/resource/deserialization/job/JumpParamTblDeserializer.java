package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.job;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.JumpParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.JumpParamTbl;

public class JumpParamTblDeserializer extends ClientResourceFileDeserializer {


    private static JumpParam readJumpParam(BufferReader bufferReader) {
        return new JumpParam(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected JumpParamTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JumpParamTbl(bufferReader.readArray(JumpParamTblDeserializer::readJumpParam));
    }
}
