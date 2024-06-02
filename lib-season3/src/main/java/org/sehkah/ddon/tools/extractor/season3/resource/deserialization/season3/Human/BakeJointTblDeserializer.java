package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.Human;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.Human.BakeJoint;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.Human.BakeJointTbl;

public class BakeJointTblDeserializer extends ClientResourceFileDeserializer {
    public BakeJointTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static BakeJoint readBakeJoint(BufferReader bufferReader) {
        return new BakeJoint(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected BakeJointTbl parseClientResourceFile(BufferReader bufferReader) {
        return new BakeJointTbl(bufferReader.readArray(BakeJointTblDeserializer::readBakeJoint));
    }
}
