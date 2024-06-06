package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.skill;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill.NormalSkillData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill.NormalSkillDataList;

public class NormalSkillDataDeserializer extends ClientResourceFileDeserializer {


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
    protected NormalSkillDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NormalSkillDataList(bufferReader.readArray(NormalSkillDataDeserializer::readNormalSkillData));
    }
}
