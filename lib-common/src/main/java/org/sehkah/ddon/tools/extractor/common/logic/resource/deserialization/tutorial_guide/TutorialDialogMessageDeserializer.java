package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.tutorial_guide;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.tutorial_guide.TutorialDialogMessage;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.tutorial_guide.TutorialDialogMessageDialogPage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TutorialDialogMessageDeserializer extends ClientResourceFileDeserializer<TutorialDialogMessage> {
    private static TutorialDialogMessageDialogPage readTutorialDialogMessageDialogPage(String gmdFilePath, BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long TextGmdIdx = bufferReader.readUnsignedInteger();
        String Message = null;
        if (lookupUtil != null) {
            Message = lookupUtil.getMessage(gmdFilePath, TextGmdIdx);
        }
        long ImageId = bufferReader.readUnsignedInteger();

        return new TutorialDialogMessageDialogPage(TextGmdIdx, Message, ImageId);
    }


    @Override
    protected TutorialDialogMessage parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long TitleGmdIdx = bufferReader.readUnsignedInteger();
        long CategoryGmdIdx = bufferReader.readUnsignedInteger();

        String TutorialTitleName;
        final String gmdFilePath;
        if (lookupUtil != null) {
            TutorialTitleName = lookupUtil.getMessage(GUIMessageLookupTable.TUTORIAL_GUIDE.getFilePath(), "TUTORIAL_" + TitleGmdIdx);

            // nativePC/rom/tguide/tutorial_guide_100/ui/00_param/tutorial_guide/tutorial_guide_100.tdm.json
            // nativePC/rom/tguide/tutorial_guide_100/ui/00_message/tutorial_guide/steps/tutorial_guide_step100.gmd.json
            String fileName = filePath.getFileName().toString()
                    .replace("tutorial_guide_", "tutorial_guide_step")
                    .replace(".tdm", ".gmd");
            String parent = filePath.getParent().toString() + '/';
            gmdFilePath = Paths.get(parent
                            .replace("00_param", "00_message")
                            .replace("tutorial_guide/", "tutorial_guide/steps"))
                    .resolve(fileName).toString();
        } else {
            TutorialTitleName = null;
            gmdFilePath = null;
        }

        List<TutorialDialogMessageDialogPage> PageInfo = bufferReader.readArray(br -> readTutorialDialogMessageDialogPage(gmdFilePath, br, lookupUtil));

        return new TutorialDialogMessage(TitleGmdIdx, TutorialTitleName, CategoryGmdIdx, PageInfo);
    }
}
