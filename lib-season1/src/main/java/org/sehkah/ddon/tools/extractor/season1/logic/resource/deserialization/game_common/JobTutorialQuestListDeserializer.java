package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.JobTutorialQuestList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.QuestId;

import java.nio.file.Path;

public class JobTutorialQuestListDeserializer extends ClientResourceFileDeserializer<JobTutorialQuestList> {


    static QuestId readQuestId(BufferReader bufferReader) {
        return new QuestId(bufferReader.readUnsignedInteger());
    }

    @Override
    protected JobTutorialQuestList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JobTutorialQuestList(bufferReader.readArray(JobTutorialQuestListDeserializer::readQuestId));
    }
}
