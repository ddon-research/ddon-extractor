package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.tutorial_guide.TutorialDialogMessage;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.tutorial_guide.TutorialDialogMessageDialogPage;

public class TutorialDialogMessageDeserializer extends ClientResourceFileDeserializer {
    public TutorialDialogMessageDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TutorialDialogMessageDialogPage readTutorialDialogMessageDialogPage(BufferReader bufferReader) {
        return new TutorialDialogMessageDialogPage(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }


    @Override
    protected TutorialDialogMessage parseClientResourceFile(BufferReader bufferReader) {
        return new TutorialDialogMessage(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(TutorialDialogMessageDeserializer::readTutorialDialogMessageDialogPage)
        );
    }
}
