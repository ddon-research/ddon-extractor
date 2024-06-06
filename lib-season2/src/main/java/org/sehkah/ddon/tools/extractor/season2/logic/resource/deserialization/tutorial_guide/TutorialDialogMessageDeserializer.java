package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.tutorial_guide;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.tutorial_guide.TutorialDialogMessage;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.tutorial_guide.TutorialDialogMessageDialogPage;

public class TutorialDialogMessageDeserializer extends ClientResourceFileDeserializer {


    private static TutorialDialogMessageDialogPage readTutorialDialogMessageDialogPage(BufferReader bufferReader) {
        return new TutorialDialogMessageDialogPage(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }


    @Override
    protected TutorialDialogMessage parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new TutorialDialogMessage(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(TutorialDialogMessageDeserializer::readTutorialDialogMessageDialogPage)
        );
    }
}
