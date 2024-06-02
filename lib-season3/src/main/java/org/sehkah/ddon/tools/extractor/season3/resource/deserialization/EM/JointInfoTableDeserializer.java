package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.JointInfo;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.JointInfoTable;

public class JointInfoTableDeserializer extends ClientResourceFileDeserializer {
    public JointInfoTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JointInfo readJointInfo(BufferReader bufferReader) {
        return new JointInfo(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readFloat(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected JointInfoTable parseClientResourceFile(BufferReader bufferReader) {
        return new JointInfoTable(bufferReader.readArray(JointInfoTableDeserializer::readJointInfo));
    }
}
