package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.JointOrder;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.JointOrderTable;

public class JointOrderTableDeserializer extends ClientResourceFileDeserializer {
    public JointOrderTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JointOrder readJointOrder(FileReader fileReader) {
        return new JointOrder(
                fileReader.readArray(FileReader::readUnsignedByte)
        );
    }

    @Override
    protected JointOrderTable parseClientResourceFile(FileReader fileReader) {
        return new JointOrderTable(fileReader.readArray(JointOrderTableDeserializer::readJointOrder));
    }
}
