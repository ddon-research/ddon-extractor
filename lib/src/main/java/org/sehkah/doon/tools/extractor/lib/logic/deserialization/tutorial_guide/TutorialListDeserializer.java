package org.sehkah.doon.tools.extractor.lib.logic.deserialization.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.tutorial_guide.TutorialNode;

import java.util.List;

public class TutorialListDeserializer extends FileDeserializer<List<TutorialNode>> {
    public TutorialListDeserializer() {
        super(ClientResourceFile.rTutorialList);
    }

    private static TutorialNode readEntity(FileReader fileReader) {
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
    protected List<TutorialNode> readObject(FileReader fileReader) {
        return fileReader.readArray(TutorialListDeserializer::readEntity);
    }
}
