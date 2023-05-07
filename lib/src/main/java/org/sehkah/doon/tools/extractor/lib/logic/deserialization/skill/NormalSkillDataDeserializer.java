package org.sehkah.doon.tools.extractor.lib.logic.deserialization.skill;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.skill.NormalSkillData;

public class NormalSkillDataDeserializer extends FileDeserializer {
    public NormalSkillDataDeserializer(FileReader fileReader) {
        super(ExtensionMap.rNormalSkillData, fileReader);
    }

    private static NormalSkillData readEntity(FileReader fileReader) {
        return new NormalSkillData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(NormalSkillDataDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
