package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.JointInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.JointInfoTable;

public class JointInfoTableDeserializer extends ClientResourceFileDeserializer {
    public JointInfoTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JointInfo readJointInfo(FileReader fileReader) {
        return new JointInfo(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readFloat(),
                fileReader.readVector3f(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected JointInfoTable parseClientResourceFile(FileReader fileReader) {
        return new JointInfoTable(fileReader.readArray(JointInfoTableDeserializer::readJointInfo));
    }
}
