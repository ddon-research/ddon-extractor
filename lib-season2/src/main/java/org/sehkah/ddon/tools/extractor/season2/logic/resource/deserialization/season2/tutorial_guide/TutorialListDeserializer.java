package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season2.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.tutorial_guide.TutorialList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.tutorial_guide.TutorialNode;

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
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected TutorialList parseClientResourceFile(BufferReader bufferReader) {
        return new TutorialList(bufferReader.readArray(TutorialListDeserializer::readTutorialNode));
    }
}
