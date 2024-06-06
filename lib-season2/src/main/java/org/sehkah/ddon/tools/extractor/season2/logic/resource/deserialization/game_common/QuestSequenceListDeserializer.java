package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.QuestSequence;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.QuestSequenceList;

public class QuestSequenceListDeserializer extends ClientResourceFileDeserializer {


    private static QuestSequence readQuestSequence(BufferReader bufferReader) {
        return new QuestSequence(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestSequenceList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new QuestSequenceList(bufferReader.readArray(QuestSequenceListDeserializer::readQuestSequence));
    }
}
