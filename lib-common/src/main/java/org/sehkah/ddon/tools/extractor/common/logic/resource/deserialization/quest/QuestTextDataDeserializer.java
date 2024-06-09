package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.quest;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.QuestTextData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.QuestTextDataList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.meta.QuestTextType;

import java.nio.file.Path;

public class QuestTextDataDeserializer extends ClientResourceFileDeserializer<QuestTextDataList> {
    private static QuestTextData readQuestTextData(String gmdFilePath, BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long Type = bufferReader.readUnsignedInteger();
        QuestTextType TypeName = QuestTextType.of(Type);
        long MsgGmdIdx = bufferReader.readUnsignedInteger();
        String Message = null;
        if (lookupUtil != null) {
            Message = lookupUtil.getMessage(gmdFilePath, MsgGmdIdx);
        }

        return new QuestTextData(Type, TypeName, MsgGmdIdx, Message);
    }

    @Override
    protected QuestTextDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        final String gmdFilePath;
        if (lookupUtil != null) {
            gmdFilePath = filePath.toString().replace("00_param", "00_message").replace("quest_text", "quest_info").replace(".qtd", ".gmd");
        } else {
            gmdFilePath = null;
        }

        return new QuestTextDataList(bufferReader.readArray(br -> readQuestTextData(gmdFilePath, br, lookupUtil)));
    }
}
