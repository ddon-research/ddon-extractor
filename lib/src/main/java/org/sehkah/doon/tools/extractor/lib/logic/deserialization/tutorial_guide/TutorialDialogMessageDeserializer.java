package org.sehkah.doon.tools.extractor.lib.logic.deserialization.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.tutorial_guide.TutorialDialogMessage;
import org.sehkah.doon.tools.extractor.lib.logic.entity.tutorial_guide.TutorialDialogMessageDialogPage;

public class TutorialDialogMessageDeserializer extends FileDeserializer {
    public TutorialDialogMessageDeserializer() {
        super(ClientResourceFile.rTutorialDialogMessage);
    }

    private static TutorialDialogMessageDialogPage readTutorialDialogMessageDialogPage(FileReader fileReader) {
        return new TutorialDialogMessageDialogPage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static TutorialDialogMessage readEntity(FileReader fileReader) {
        return new TutorialDialogMessage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(TutorialDialogMessageDeserializer::readTutorialDialogMessageDialogPage)
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
