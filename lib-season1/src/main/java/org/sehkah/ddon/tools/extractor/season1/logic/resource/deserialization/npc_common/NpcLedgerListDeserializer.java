package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.NpcLedgerListItem;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.NpcLedgerListItemInstitution;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.NpcLedgerListItemInstitutionOpenData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.meta.NpcFunctionIdType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.meta.NpcSexType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.meta.NpcUnitType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.meta.NpcVoiceType;

import java.util.List;

public class NpcLedgerListDeserializer extends ClientResourceFileDeserializer<NpcLedgerList> {
    private static NpcLedgerListItemInstitutionOpenData readNpcLedgerListItemInstitutionOpenData(BufferReader bufferReader) {
        return new NpcLedgerListItemInstitutionOpenData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static NpcLedgerListItemInstitution readNpcLedgerListItemInstitution(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long FunctionId = bufferReader.readUnsignedInteger();
        String FunctionName = null;
        if (lookupUtil != null) {
            FunctionName = lookupUtil.getMessage(ResourceFileLookupType.FUNC_SELECT_NAME.getFilePath(), "FUNC_SELECT_NAME_" + FunctionId);
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
        long ClassNameId = bufferReader.readUnsignedByte();
        String NpcName = null;
        String NpcClassName = null;
        if (lookupUtil != null) {
            NpcName = lookupUtil.getMessage(ResourceFileLookupType.NPC_NAME.getFilePath(), NameId);
            NpcClassName = lookupUtil.getMessage(ResourceFileLookupType.NPC_CLASS_NAME.getFilePath(), ClassNameId);

        }
        int JobId = bufferReader.readUnsignedByte();
        int Finger = bufferReader.readUnsignedByte();
        int VoiceType = bufferReader.readUnsignedByte();
        NpcVoiceType VoiceTypeName = NpcVoiceType.of(VoiceType);
        int UnitType = bufferReader.readUnsignedByte();
        NpcUnitType UnitTypeName = NpcUnitType.of(UnitType);
        long UnitTypeParam = bufferReader.readUnsignedInteger();
        List<NpcLedgerListItemInstitution> InstitutionList = bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItemInstitution, lookupUtil);

        return new NpcLedgerListItem(NpcId, Sex, SexType, NameId, NpcName, ClassNameId, NpcClassName, JobId, Finger, VoiceType, VoiceTypeName, UnitType, UnitTypeName, UnitTypeParam, InstitutionList);
    }

    @Override
    protected NpcLedgerList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcLedgerList(bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItem, lookupUtil));
    }
}
