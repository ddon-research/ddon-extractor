package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.JointOrder;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.JointOrderTable;

public class JointOrderTableDeserializer extends ClientResourceFileDeserializer {
    public JointOrderTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JointOrder readJointOrder(BufferReader bufferReader) {
        return new JointOrder(
                bufferReader.readArray(BufferReader::readUnsignedByte)
        );
    }

    @Override
    protected JointOrderTable parseClientResourceFile(BufferReader bufferReader) {
        return new JointOrderTable(bufferReader.readArray(JointOrderTableDeserializer::readJointOrder));
    }
}
