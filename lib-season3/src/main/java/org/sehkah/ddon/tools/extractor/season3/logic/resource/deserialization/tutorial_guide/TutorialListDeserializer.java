package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.tutorial_guide;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.tutorial_guide.TutorialList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.tutorial_guide.TutorialNode;

public class TutorialListDeserializer extends ClientResourceFileDeserializer {


    private static TutorialNode readTutorialNode(BufferReader bufferReader) {
        return new TutorialNode(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected TutorialList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new TutorialList(bufferReader.readArray(TutorialListDeserializer::readTutorialNode));
    }
}
