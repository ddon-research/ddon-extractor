package org.sehkah.doon.tools.extractor.lib.logic.deserialization.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.tutorial_guide.TutorialNode;

public class TutorialListDeserializer extends FileDeserializer {
    public TutorialListDeserializer(FileReader fileReader) {
        super(ExtensionMap.rTutorialList, fileReader);
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
    protected Object readObject() {
        return fileReader.readArray(TutorialListDeserializer::readEntity);
    }
}
