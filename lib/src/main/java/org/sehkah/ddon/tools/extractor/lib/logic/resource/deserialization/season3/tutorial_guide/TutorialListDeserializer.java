package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.tutorial_guide.TutorialList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.tutorial_guide.TutorialNode;

public class TutorialListDeserializer extends ClientResourceFileDeserializer {
    public TutorialListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TutorialNode readTutorialNode(FileReader fileReader) {
        return new TutorialNode(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected TutorialList parseClientResourceFile(FileReader fileReader) {
        return new TutorialList(fileReader.readArray(TutorialListDeserializer::readTutorialNode));
    }
}
