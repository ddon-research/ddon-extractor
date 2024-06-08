package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human.BakeJoint;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human.BakeJointTbl;

public class BakeJointTblDeserializer extends ClientResourceFileDeserializer<BakeJointTbl> {


    private static BakeJoint readBakeJoint(BufferReader bufferReader) {
        return new BakeJoint(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected BakeJointTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new BakeJointTbl(bufferReader.readArray(BakeJointTblDeserializer::readBakeJoint));
    }
}
