package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.tutorial_guide;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.tutorial_guide.TutorialList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.tutorial_guide.TutorialNode;

import java.nio.file.Path;

public class TutorialListDeserializer extends ClientResourceFileDeserializer<TutorialList> {
    private static TutorialNode readTutorialNode(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long Id = bufferReader.readUnsignedInteger();
        long SortNo = bufferReader.readUnsignedInteger();
        long TitleGmdIdx = bufferReader.readUnsignedInteger();
        long Category = bufferReader.readUnsignedInteger();
        String TutorialTitleName = null;
        String CategoryName = null;
        if (lookupUtil != null) {
            TutorialTitleName = lookupUtil.getMessage(GUIMessageLookupTable.TUTORIAL_GUIDE.getFilePath(), TitleGmdIdx);
            CategoryName = lookupUtil.getMessage(GUIMessageLookupTable.TUTORIAL_GUIDE_CATEGORY.getFilePath(), Category);
        }
        long OpenQuestId = bufferReader.readUnsignedInteger();

        return new TutorialNode(Id, SortNo, TitleGmdIdx, TutorialTitleName, Category, CategoryName, OpenQuestId);
    }

    @Override
    protected TutorialList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new TutorialList(bufferReader.readArray(br -> readTutorialNode(bufferReader, lookupUtil)));
    }
}