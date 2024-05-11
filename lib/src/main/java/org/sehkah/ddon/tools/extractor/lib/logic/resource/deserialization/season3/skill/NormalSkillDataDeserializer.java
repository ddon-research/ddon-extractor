package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.skill;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.skill.NormalSkillData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.skill.NormalSkillDataList;

public class NormalSkillDataDeserializer extends ClientResourceFileDeserializer {
    public NormalSkillDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NormalSkillData readNormalSkillData(FileReader fileReader) {
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
    protected NormalSkillDataList parseClientResourceFile(FileReader fileReader) {
        return new NormalSkillDataList(fileReader.readArray(NormalSkillDataDeserializer::readNormalSkillData));
    }
}
