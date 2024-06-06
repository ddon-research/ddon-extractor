package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcLedgerListItem;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcLedgerListItemInstitution;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcLedgerListItemInstitutionOpenData;

public class NpcLedgerListDeserializer extends ClientResourceFileDeserializer {


    private static NpcLedgerListItemInstitutionOpenData readNpcLedgerListItemInstitutionOpenData(BufferReader bufferReader) {
        return new NpcLedgerListItemInstitutionOpenData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static NpcLedgerListItemInstitution readNpcLedgerListItemInstitution(BufferReader bufferReader) {
        return new NpcLedgerListItemInstitution(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItemInstitutionOpenData)
        );
    }

    private static NpcLedgerListItem readNpcLedgerListItem(BufferReader bufferReader) {
        return new NpcLedgerListItem(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItemInstitution)
        );
    }

    @Override
    protected NpcLedgerList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcLedgerList(bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItem));
    }
}
