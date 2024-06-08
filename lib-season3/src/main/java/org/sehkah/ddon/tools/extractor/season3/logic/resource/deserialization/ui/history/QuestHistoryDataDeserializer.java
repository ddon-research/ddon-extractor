package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.history;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.history.QuestHistoryData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.history.QuestHistoryDataList;

public class QuestHistoryDataDeserializer extends ClientResourceFileDeserializer<QuestHistoryDataList> {


    private static QuestHistoryData readQuestHistoryData(BufferReader bufferReader) {
        return new QuestHistoryData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected QuestHistoryDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new QuestHistoryDataList(bufferReader.readArray(QuestHistoryDataDeserializer::readQuestHistoryData));
    }
}
