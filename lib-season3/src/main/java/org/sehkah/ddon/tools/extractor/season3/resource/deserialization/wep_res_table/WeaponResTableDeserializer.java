package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.wep_res_table;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.wep_res_table.wep_res_table.WeaponRes;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.wep_res_table.wep_res_table.WeaponResTable;

public class WeaponResTableDeserializer extends ClientResourceFileDeserializer {
    public WeaponResTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WeaponRes readWeaponRes(BufferReader bufferReader) {
        return new WeaponRes(
                bufferReader.readUnsignedInteger(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong()
        );
    }

    @Override
    protected WeaponResTable parseClientResourceFile(BufferReader bufferReader) {
        return new WeaponResTable(bufferReader.readArray(WeaponResTableDeserializer::readWeaponRes));
    }
}
