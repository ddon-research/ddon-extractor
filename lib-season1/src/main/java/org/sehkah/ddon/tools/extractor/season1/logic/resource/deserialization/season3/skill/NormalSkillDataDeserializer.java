package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.skill;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.skill.NormalSkillData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.skill.NormalSkillDataList;

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
