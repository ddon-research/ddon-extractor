package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.Human;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.BakeJoint;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.BakeJointTbl;

public class BakeJointTblDeserializer extends ClientResourceFileDeserializer {
    public BakeJointTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static BakeJoint readBakeJoint(FileReader fileReader) {
        return new BakeJoint(
                fileReader.readBoolean(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected BakeJointTbl parseClientResourceFile(FileReader fileReader) {
        return new BakeJointTbl(fileReader.readArray(BakeJointTblDeserializer::readBakeJoint));
    }
}
