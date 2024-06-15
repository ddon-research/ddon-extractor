package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.JointInfo;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.JointInfoTable;

import java.nio.file.Path;

public class JointInfoTableDeserializer extends ClientResourceFileDeserializer<JointInfoTable> {
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
    protected JointInfoTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JointInfoTable(bufferReader.readArray(JointInfoTableDeserializer::readJointInfo));
    }
}
