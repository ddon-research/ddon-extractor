package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.JobTutorialQuestList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.QuestId;

import java.nio.file.Path;

public class JobTutorialQuestListDeserializer extends ClientResourceFileDeserializer<JobTutorialQuestList> {
    private static QuestId readQuestId(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestId = bufferReader.readUnsignedInteger();
        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new QuestId(QuestId, QuestName);
    }

    @Override
    protected JobTutorialQuestList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JobTutorialQuestList(bufferReader.readArray(JobTutorialQuestListDeserializer::readQuestId, lookupUtil));
    }
}
