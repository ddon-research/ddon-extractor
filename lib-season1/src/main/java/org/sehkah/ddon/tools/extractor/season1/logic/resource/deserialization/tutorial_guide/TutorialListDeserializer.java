package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.tutorial_guide;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.tutorial_guide.TutorialList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.tutorial_guide.TutorialNode;

public class TutorialListDeserializer extends ClientResourceFileDeserializer {
    private static TutorialNode readTutorialNode(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long Id = bufferReader.readUnsignedInteger();
        long SortNo = bufferReader.readUnsignedInteger();
        long TitleGmdIdx = bufferReader.readUnsignedInteger();

        String TutorialTitleName = null;
        if (lookupUtil != null) {
            TutorialTitleName = lookupUtil.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE.getFilePath(), TitleGmdIdx);
        }

        long Category = bufferReader.readUnsignedInteger();
        long OpenQuestId = bufferReader.readUnsignedInteger();

        return new TutorialNode(Id, SortNo, TitleGmdIdx, TutorialTitleName, Category, OpenQuestId);
    }

    @Override
    protected TutorialList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new TutorialList(bufferReader.readArray(br -> readTutorialNode(bufferReader, lookupUtil)));
    }
}
