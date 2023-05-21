package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.tutorial_guide.TutorialDialogMessage;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.tutorial_guide.TutorialDialogMessageDialogPage;

public class TutorialDialogMessageDeserializer extends ClientResourceFileDeserializer<TutorialDialogMessage> {
    public TutorialDialogMessageDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected TutorialDialogMessage parseClientResourceFile(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
