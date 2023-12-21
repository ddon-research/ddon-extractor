package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.tutorial_guide.TutorialDialogMessage;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.tutorial_guide.TutorialDialogMessageDialogPage;

public class TutorialDialogMessageDeserializer extends ClientResourceFileDeserializer {
    public TutorialDialogMessageDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TutorialDialogMessageDialogPage readTutorialDialogMessageDialogPage(FileReader fileReader) {
        return new TutorialDialogMessageDialogPage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }


    @Override
    protected TutorialDialogMessage parseClientResourceFile(FileReader fileReader) {
        return new TutorialDialogMessage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(TutorialDialogMessageDeserializer::readTutorialDialogMessageDialogPage)
        );
    }
}
