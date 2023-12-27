package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.NpcLedgerListItem;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.NpcLedgerListItemInstitution;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.NpcLedgerListItemInstitutionOpenData;

public class NpcLedgerListDeserializer extends ClientResourceFileDeserializer {
    public NpcLedgerListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcLedgerListItemInstitutionOpenData readNpcLedgerListItemInstitutionOpenData(FileReader fileReader) {
        return new NpcLedgerListItemInstitutionOpenData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static NpcLedgerListItemInstitution readNpcLedgerListItemInstitution(FileReader fileReader) {
        return new NpcLedgerListItemInstitution(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItemInstitutionOpenData)
        );
    }

    private static NpcLedgerListItem readNpcLedgerListItem(FileReader fileReader) {
        return new NpcLedgerListItem(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItemInstitution)
        );
    }

    @Override
    protected NpcLedgerList parseClientResourceFile(FileReader fileReader) {
        return new NpcLedgerList(fileReader.readArray(NpcLedgerListDeserializer::readNpcLedgerListItem));
    }
}
