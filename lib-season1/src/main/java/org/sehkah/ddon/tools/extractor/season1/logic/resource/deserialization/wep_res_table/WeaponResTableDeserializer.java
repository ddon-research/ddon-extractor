package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.wep_res_table;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.wep_res_table.WeaponRes;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.wep_res_table.WeaponResTable;

public class WeaponResTableDeserializer extends ClientResourceFileDeserializer<WeaponResTable> {


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
    protected WeaponResTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new WeaponResTable(bufferReader.readArray(WeaponResTableDeserializer::readWeaponRes));
    }
}
