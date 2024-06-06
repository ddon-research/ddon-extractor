package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.quest;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.QuestMarkerInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.QuestMarkerInfoInfo;

public class QuestMarkerInfoDeserializer extends ClientResourceFileDeserializer {


    private static QuestMarkerInfoInfo readQuestMarkerInfoInfo(BufferReader bufferReader) {
        return new QuestMarkerInfoInfo(
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestMarkerInfo parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new QuestMarkerInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(QuestMarkerInfoDeserializer::readQuestMarkerInfoInfo)
        );
    }
}
