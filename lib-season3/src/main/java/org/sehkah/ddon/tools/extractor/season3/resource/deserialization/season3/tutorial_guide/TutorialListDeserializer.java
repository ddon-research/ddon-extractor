package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.tutorial_guide.TutorialList;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.tutorial_guide.TutorialNode;

public class TutorialListDeserializer extends ClientResourceFileDeserializer {
    public TutorialListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected TutorialList parseClientResourceFile(BufferReader bufferReader) {
        return new TutorialList(bufferReader.readArray(TutorialListDeserializer::readTutorialNode));
    }
}
