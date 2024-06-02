package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.Human;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human.WeaponOffset;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human.WeaponOffsetTbl;

public class WeaponOffsetTblDeserializer extends ClientResourceFileDeserializer {
    public WeaponOffsetTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected WeaponOffsetTbl parseClientResourceFile(BufferReader bufferReader) {
        return new WeaponOffsetTbl(bufferReader.readArray(WeaponOffsetTblDeserializer::readWeaponOffset));
    }
}
