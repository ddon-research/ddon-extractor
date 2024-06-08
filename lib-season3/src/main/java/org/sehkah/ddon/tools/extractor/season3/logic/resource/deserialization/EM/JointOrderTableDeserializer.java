package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.JointOrder;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.JointOrderTable;

import java.nio.file.Path;

public class JointOrderTableDeserializer extends ClientResourceFileDeserializer<JointOrderTable> {


    private static JointOrder readJointOrder(BufferReader bufferReader) {
        return new JointOrder(
                bufferReader.readArray(BufferReader::readUnsignedByte)
        );
    }

    @Override
    protected JointOrderTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JointOrderTable(bufferReader.readArray(JointOrderTableDeserializer::readJointOrder));
    }
}
