package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.skill;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.skill.NormalSkillData;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.skill.NormalSkillDataList;

public class NormalSkillDataDeserializer extends ClientResourceFileDeserializer {
    public NormalSkillDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NormalSkillData readNormalSkillData(BufferReader bufferReader) {
        return new NormalSkillData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }


    @Override
    protected NormalSkillDataList parseClientResourceFile(BufferReader bufferReader) {
        return new NormalSkillDataList(bufferReader.readArray(NormalSkillDataDeserializer::readNormalSkillData));
    }
}
