package org.sehkah.doon.tools.extractor.lib.logic.deserialization.skill;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.skill.NormalSkillData;

import java.util.List;

public class NormalSkillDataDeserializer extends FileDeserializer<List<NormalSkillData>> {
    public NormalSkillDataDeserializer() {
        super(ClientResourceFile.rNormalSkillData);
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
    protected List<NormalSkillData> readObject(FileReader fileReader) {
        return fileReader.readArray(NormalSkillDataDeserializer::readEntity);
    }
}
