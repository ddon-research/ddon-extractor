package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.npc_common.NpcLedgerListItem;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.npc_common.NpcLedgerListItemInstitution;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.npc_common.NpcLedgerListItemInstitutionOpenData;

public class NpcLedgerListDeserializer extends ClientResourceFileDeserializer {
    public NpcLedgerListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected NpcLedgerList parseClientResourceFile(BufferReader bufferReader) {
        return new NpcLedgerList(bufferReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItem));
    }
}
