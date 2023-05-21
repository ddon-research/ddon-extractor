package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season2.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.tutorial_guide.TutorialList;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.tutorial_guide.TutorialNode;

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
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected TutorialList parseClientResourceFile(FileReader fileReader) {
        return new TutorialList(fileReader.readArray(TutorialListDeserializer::readTutorialNode));
    }
}
