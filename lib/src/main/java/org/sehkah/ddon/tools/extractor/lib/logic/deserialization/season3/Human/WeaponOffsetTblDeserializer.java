package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.Human;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.WeaponOffset;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.WeaponOffsetTbl;

public class WeaponOffsetTblDeserializer extends ClientResourceFileDeserializer {
    public WeaponOffsetTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WeaponOffset readWeaponOffset(FileReader fileReader) {
        return new WeaponOffset(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readFloat()
        );
    }

    @Override
    protected WeaponOffsetTbl parseClientResourceFile(FileReader fileReader) {
        return new WeaponOffsetTbl(fileReader.readArray(WeaponOffsetTblDeserializer::readWeaponOffset));
    }
}
