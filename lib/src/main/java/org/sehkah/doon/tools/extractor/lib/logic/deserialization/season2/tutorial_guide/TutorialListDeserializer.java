package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season2.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.tutorial_guide.TutorialNode;

import java.util.List;

public class TutorialListDeserializer extends ClientResourceFileDeserializer<List<TutorialNode>> {
    public TutorialListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TutorialNode readEntity(FileReader fileReader) {
        return new TutorialNode(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<TutorialNode> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(TutorialListDeserializer::readEntity);
    }
}