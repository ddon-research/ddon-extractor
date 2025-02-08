package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.QuestSequence;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.QuestSequenceList;

import java.nio.file.Path;

public class QuestSequenceListDeserializer extends ClientResourceFileDeserializer<QuestSequenceList> {
    private static QuestSequence readQuestSequence(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long SeqNo = bufferReader.readUnsignedInteger();
        long QuestId = bufferReader.readUnsignedInteger();
        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new QuestSequence(SeqNo, QuestId, QuestName);
    }

    @Override
    protected QuestSequenceList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new QuestSequenceList(bufferReader.readArray(QuestSequenceListDeserializer::readQuestSequence, lookupUtil));
    }
}
