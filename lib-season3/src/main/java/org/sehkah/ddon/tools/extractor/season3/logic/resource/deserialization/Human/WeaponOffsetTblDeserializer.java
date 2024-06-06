package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human.WeaponOffset;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human.WeaponOffsetTbl;

public class WeaponOffsetTblDeserializer extends ClientResourceFileDeserializer {


    private static WeaponOffset readWeaponOffset(BufferReader bufferReader) {
        return new WeaponOffset(
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected WeaponOffsetTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new WeaponOffsetTbl(bufferReader.readArray(WeaponOffsetTblDeserializer::readWeaponOffset));
    }
}
