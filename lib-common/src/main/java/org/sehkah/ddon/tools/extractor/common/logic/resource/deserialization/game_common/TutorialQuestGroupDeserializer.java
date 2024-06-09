package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.QuestId;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.TutorialQuestGroup;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.TutorialQuestGroupList;

import java.nio.file.Path;

public class TutorialQuestGroupDeserializer extends ClientResourceFileDeserializer<TutorialQuestGroupList> {
    private static QuestId readQuestId(BufferReader bufferReader) {
        return new QuestId(bufferReader.readUnsignedInteger());
    }

    private static TutorialQuestGroup readTutorialQuestGroup(BufferReader bufferReader) {
        return new TutorialQuestGroup(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(TutorialQuestGroupDeserializer::readQuestId)
        );
    }

    @Override
    protected TutorialQuestGroupList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new TutorialQuestGroupList(bufferReader.readArray(TutorialQuestGroupDeserializer::readTutorialQuestGroup));
    }
}
