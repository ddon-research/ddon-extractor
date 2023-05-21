package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.skill;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.skill.NormalSkillData;

import java.util.List;

public class NormalSkillDataDeserializer extends ClientResourceFileDeserializer<List<NormalSkillData>> {
    public NormalSkillDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<NormalSkillData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(NormalSkillDataDeserializer::readEntity);
    }
}
