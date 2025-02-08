package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.skill;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.PathUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill.CustomSkillData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill.CustomSkillDataList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill.SkillLevelData;

import java.nio.file.Path;
import java.util.List;

public class CustomSkillDataDeserializer extends ClientResourceFileDeserializer<CustomSkillDataList> {
    private static SkillLevelData readSkillLevelData(BufferReader bufferReader) {
        return new SkillLevelData(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static CustomSkillData readCustomSkillData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, String gmdFilePathSkillName, String gmdFilePathSkillInfo, String gmdFilePathSkillCommand) {
        int Id = bufferReader.readUnsignedShort();
        int MsgNameIndex = bufferReader.readUnsignedShort();
        int IconId = bufferReader.readUnsignedShort();
        List<SkillLevelData> LvArray = bufferReader.readArray(CustomSkillDataDeserializer::readSkillLevelData);

        Translation SkillName = null;
        Translation SkillInfo = null;
        Translation SkillCommand = null;
        if (lookupUtil != null) {
            SkillName = lookupUtil.getMessageTranslation(gmdFilePathSkillName, MsgNameIndex);
            SkillInfo = lookupUtil.getMessageTranslation(gmdFilePathSkillInfo, MsgNameIndex);
            SkillCommand = lookupUtil.getMessageTranslation(gmdFilePathSkillCommand, MsgNameIndex);
        }

        return new CustomSkillData(Id, MsgNameIndex, SkillName, SkillInfo, SkillCommand, IconId, LvArray);
    }

    @Override
    protected CustomSkillDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        final String gmdFilePathSkillName;
        final String gmdFilePathSkillInfo;
        final String gmdFilePathSkillCommand;
        if (lookupUtil != null) {
            // skill/normal_skill_data_01/ui/00_param/skill_ability/normal_skill_data_01.nsd

            // name => ui/gui_cmn/ui/00_message/skill/normal_skill_name_01.gmd
            // info => skill/normal_skill_data_01/ui/00_message/skill/normal_skill_info_01.gmd
            // command => skill/normal_skill_data_01/ui/00_message/skill/normal_skill_command_01.gmd

            gmdFilePathSkillName = "ui/gui_cmn/ui/00_message/skill/" + filePath.getFileName().toString().replace("costom_skill_data_", "custom_skill_name_").replace(".csd", ".gmd");

            String tmp = PathUtil.getRelativeFilePathFromRom(filePath).replace("00_param", "00_message").replace(".csd", ".gmd");
            gmdFilePathSkillInfo = tmp.replace("skill_ability/costom_skill_data_", "skill/custom_skill_info_");
            gmdFilePathSkillCommand = tmp.replace("skill_ability/costom_skill_data_", "skill/custom_skill_command_");
        } else {
            gmdFilePathSkillName = null;
            gmdFilePathSkillInfo = null;
            gmdFilePathSkillCommand = null;
        }

        return new CustomSkillDataList(bufferReader.readArray(br -> readCustomSkillData(br, lookupUtil, gmdFilePathSkillName, gmdFilePathSkillInfo, gmdFilePathSkillCommand)));
    }
}
