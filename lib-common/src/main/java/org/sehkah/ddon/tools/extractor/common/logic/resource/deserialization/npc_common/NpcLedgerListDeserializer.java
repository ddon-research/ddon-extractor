package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerListItem;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerListItemInstitution;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerListItemInstitutionOpenData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.meta.*;

import java.nio.file.Path;
import java.util.List;

public class NpcLedgerListDeserializer extends ClientResourceFileDeserializer<NpcLedgerList> {
    private static NpcLedgerListItemInstitutionOpenData readNpcLedgerListItemInstitutionOpenData(BufferReader bufferReader) {
        long Type = bufferReader.readUnsignedInteger();
        NpcFunctionType TypeName = NpcFunctionType.of(Type);
        long FlagNo = bufferReader.readUnsignedInteger();

        return new NpcLedgerListItemInstitutionOpenData(Type, TypeName, FlagNo);
    }

    private static NpcLedgerListItemInstitution readNpcLedgerListItemInstitution(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long FunctionId = bufferReader.readUnsignedInteger();
        Translation FunctionName = null;
        if (lookupUtil != null) {
            FunctionName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.FUNC_SELECT_NAME.getFilePath(), "FUNC_SELECT_NAME_" + FunctionId);
        }
        NpcFunctionIdType FunctionIdType = NpcFunctionIdType.of(FunctionId);
        long FunctionParam = bufferReader.readUnsignedInteger();
        List<NpcLedgerListItemInstitutionOpenData> FunctionOpenList = bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItemInstitutionOpenData);

        return new NpcLedgerListItemInstitution(FunctionId, FunctionName, FunctionIdType, FunctionParam, FunctionOpenList);
    }

    private static NpcLedgerListItem readNpcLedgerListItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long NpcId = bufferReader.readUnsignedInteger();
        int Sex = bufferReader.readUnsignedByte();
        NpcSexType SexType = NpcSexType.of(Sex);
        long NameId = bufferReader.readUnsignedInteger();
        long ClassNameId = bufferReader.readUnsignedInteger();
        int JobId = bufferReader.readUnsignedByte();
        Translation NpcName = null;
        Translation NpcClassName = null;
        Translation JobName = null;
        if (lookupUtil != null) {
            NpcName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.NPC_NAME.getFilePath(), (int) NameId);
            NpcClassName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.NPC_CLASS_NAME.getFilePath(), (int) ClassNameId);
            JobName = lookupUtil.getJobName(JobId);
        }
        int Finger = bufferReader.readUnsignedByte();
        int VoiceType = bufferReader.readUnsignedByte();
        NpcVoiceType VoiceTypeName = NpcVoiceType.of(VoiceType);
        int UnitType = bufferReader.readUnsignedByte();
        NpcUnitType UnitTypeName = NpcUnitType.of(UnitType);
        long UnitTypeParam = bufferReader.readUnsignedInteger();
        List<NpcLedgerListItemInstitution> InstitutionList = bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItemInstitution, lookupUtil);

        return new NpcLedgerListItem(NpcId, Sex, SexType, NameId, NpcName, ClassNameId, NpcClassName, JobId, JobName, Finger, VoiceType, VoiceTypeName, UnitType, UnitTypeName, UnitTypeParam, InstitutionList);
    }

    @Override
    protected NpcLedgerList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcLedgerList(bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItem, lookupUtil));
    }
}
