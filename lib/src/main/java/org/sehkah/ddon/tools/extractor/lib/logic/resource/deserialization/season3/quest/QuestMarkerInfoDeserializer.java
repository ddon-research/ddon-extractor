package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.quest;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.QuestMarkerInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.QuestMarkerInfoInfo;

public class QuestMarkerInfoDeserializer extends ClientResourceFileDeserializer {

    public QuestMarkerInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestMarkerInfoInfo readQuestMarkerInfoInfo(BufferReader bufferReader) {
        return new QuestMarkerInfoInfo(
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestMarkerInfo parseClientResourceFile(BufferReader bufferReader) {
        return new QuestMarkerInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(QuestMarkerInfoDeserializer::readQuestMarkerInfoInfo)
        );
    }
}
