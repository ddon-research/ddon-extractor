package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.quest;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.QuestTextData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.QuestTextDataList;

public class QuestTextDataDeserializer extends ClientResourceFileDeserializer<QuestTextDataList> {


    private static QuestTextData readQuestTextData(BufferReader bufferReader) {
        return new QuestTextData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestTextDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new QuestTextDataList(bufferReader.readArray(QuestTextDataDeserializer::readQuestTextData));
    }
}
