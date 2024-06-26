package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.QuestHistoryData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.QuestHistoryDataList;

import java.nio.file.Path;

public class QuestHistoryDataDeserializer extends ClientResourceFileDeserializer<QuestHistoryDataList> {
    private static QuestHistoryData readQuestHistoryData(BufferReader bufferReader) {
        return new QuestHistoryData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected QuestHistoryDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new QuestHistoryDataList(bufferReader.readArray(QuestHistoryDataDeserializer::readQuestHistoryData));
    }
}
