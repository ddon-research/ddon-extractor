package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.event;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.event.EventViewerSetInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.event.EventViewerSetInfoFlagData;

import java.nio.file.Path;

public class EventViewerSetInfoDeserializer extends ClientResourceFileDeserializer<EventViewerSetInfo> {
    private static EventViewerSetInfoFlagData readEventViewerSetInfoFlagData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestId = bufferReader.readUnsignedInteger();
        long FlagNo = bufferReader.readUnsignedInteger();

        Translation QuestName = null;

        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new EventViewerSetInfoFlagData(QuestId, QuestName, FlagNo);
    }

    @Override
    protected EventViewerSetInfo parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EventViewerSetInfo(
                bufferReader.readArray(EventViewerSetInfoDeserializer::readEventViewerSetInfoFlagData, lookupUtil),
                bufferReader.readArray(EventViewerSetInfoDeserializer::readEventViewerSetInfoFlagData, lookupUtil)
        );

    }
}
