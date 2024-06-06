package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.JobTutorialQuestList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.QuestId;

public class JobTutorialQuestListDeserializer extends ClientResourceFileDeserializer {


    static QuestId readQuestId(BufferReader bufferReader) {
        return new QuestId(bufferReader.readUnsignedInteger());
    }

    @Override
    protected JobTutorialQuestList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JobTutorialQuestList(bufferReader.readArray(JobTutorialQuestListDeserializer::readQuestId));
    }
}
