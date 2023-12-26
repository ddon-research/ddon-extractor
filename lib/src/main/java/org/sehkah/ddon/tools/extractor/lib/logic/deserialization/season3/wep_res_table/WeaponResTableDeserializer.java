package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.wep_res_table;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.wep_res_table.WeaponRes;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.wep_res_table.WeaponResTable;

public class WeaponResTableDeserializer extends ClientResourceFileDeserializer {
    public WeaponResTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WeaponRes readWeaponRes(FileReader fileReader) {
        return new WeaponRes(
                fileReader.readUnsignedInteger(),
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong()
        );
    }

    @Override
    protected WeaponResTable parseClientResourceFile(FileReader fileReader) {
        return new WeaponResTable(fileReader.readArray(WeaponResTableDeserializer::readWeaponRes));
    }
}
