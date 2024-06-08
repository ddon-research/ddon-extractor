package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.tutorial_guide;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.tutorial_guide.TutorialDialogMessage;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.tutorial_guide.TutorialDialogMessageDialogPage;

import java.util.List;

public class TutorialDialogMessageDeserializer extends ClientResourceFileDeserializer<TutorialDialogMessage> {
    private static TutorialDialogMessageDialogPage readTutorialDialogMessageDialogPage(BufferReader bufferReader) {
        return new TutorialDialogMessageDialogPage(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }


    @Override
    protected TutorialDialogMessage parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long TitleGmdIdx = bufferReader.readUnsignedInteger();
        String TutorialTitleName = null;
        if (lookupUtil != null) {
            TutorialTitleName = lookupUtil.getMessage(GUIMessageLookupTable.TUTORIAL_GUIDE.getFilePath(), "TUTORIAL_" + TitleGmdIdx);
        }
        long CategoryGmdIdx = bufferReader.readUnsignedInteger();
        List<TutorialDialogMessageDialogPage> PageInfo = bufferReader.readArray(TutorialDialogMessageDeserializer::readTutorialDialogMessageDialogPage);

        return new TutorialDialogMessage(TitleGmdIdx, TutorialTitleName, CategoryGmdIdx, PageInfo);
    }
}
