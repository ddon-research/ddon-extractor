package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.menu_evidence_list;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta.EvidenceType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.menu_evidence_list.Evidence;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.menu_evidence_list.EvidenceList;

import java.nio.file.Path;

public class EvidenceListDeserializer extends ClientResourceFileDeserializer<EvidenceList> {
    private static Evidence readEvidence(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int Count = bufferReader.readUnsignedByte();
        int Type = bufferReader.readUnsignedByte();
        long EvidenceId = bufferReader.readUnsignedInteger();
        long QuestId = bufferReader.readUnsignedInteger();
        long Flag = bufferReader.readUnsignedInteger();

        Translation QuestName = null;
        Translation EvidenceInfo = null;
        Translation EvidenceName = null;

        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
            EvidenceInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.EVIDENCE_INFO.getFilePath(), (int) EvidenceId);
            EvidenceName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.EVIDENCE_NAME.getFilePath(), (int) EvidenceId);
        }

        return new Evidence(Count, Type, EvidenceType.of(Type), EvidenceId, EvidenceName, EvidenceInfo, QuestId, QuestName, Flag);
    }

    @Override
    protected EvidenceList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EvidenceList(bufferReader.readArray(EvidenceListDeserializer::readEvidence, lookupUtil));

    }
}
