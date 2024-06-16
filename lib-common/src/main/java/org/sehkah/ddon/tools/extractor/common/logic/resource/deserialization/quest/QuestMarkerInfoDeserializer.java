package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.quest;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.QuestMarkerInfo;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.QuestMarkerInfoInfo;

import java.nio.file.Path;
import java.util.List;

public class QuestMarkerInfoDeserializer extends ClientResourceFileDeserializer<QuestMarkerInfo> {
    private static QuestMarkerInfoInfo readQuestMarkerInfoInfo(BufferReader bufferReader) {
        return new QuestMarkerInfoInfo(
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestMarkerInfo parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long StageNo = bufferReader.readUnsignedInteger();
        List<QuestMarkerInfoInfo> InfoList = bufferReader.readArray(QuestMarkerInfoDeserializer::readQuestMarkerInfoInfo);
        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo((int) StageNo);
        }

        return new QuestMarkerInfo(StageNo, StageName, InfoList);
    }
}
