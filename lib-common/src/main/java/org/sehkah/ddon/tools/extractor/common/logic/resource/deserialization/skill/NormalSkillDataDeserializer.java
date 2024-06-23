package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.skill;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.PathUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.skill.NormalSkillData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.skill.NormalSkillDataList;

import java.nio.file.Path;

public class NormalSkillDataDeserializer extends ClientResourceFileDeserializer<NormalSkillDataList> {
    private static NormalSkillData readNormalSkillData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, String gmdFilePathSkillName, String gmdFilePathSkillInfo, String gmdFilePathSkillCommand) {
        long NeedJp = bufferReader.readUnsignedInteger();
        int NeedLv = bufferReader.readUnsignedShort();
        int SkillNo = bufferReader.readUnsignedShort();
        int IconId = bufferReader.readUnsignedShort();
        int Index = bufferReader.readUnsignedByte();
        int MsgIndex = bufferReader.readUnsignedByte();
        int Category = bufferReader.readUnsignedByte();
        int PreSkillIndex = bufferReader.readUnsignedByte();
        int SlotNo = bufferReader.readUnsignedByte();

        Translation SkillName = null;
        Translation SkillInfo = null;
        Translation SkillCommand = null;
        if (lookupUtil != null) {
            SkillName = lookupUtil.getMessageTranslation(gmdFilePathSkillName, MsgIndex);
            SkillInfo = lookupUtil.getMessageTranslation(gmdFilePathSkillInfo, MsgIndex);
            SkillCommand = lookupUtil.getMessageTranslation(gmdFilePathSkillCommand, MsgIndex);
        }

        return new NormalSkillData(NeedJp, NeedLv, SkillNo, IconId, Index, MsgIndex, SkillName, SkillInfo, SkillCommand, Category, PreSkillIndex, SlotNo);
    }

    @Override
    protected NormalSkillDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        final String gmdFilePathSkillName;
        final String gmdFilePathSkillInfo;
        final String gmdFilePathSkillCommand;
        if (lookupUtil != null) {
            // skill/normal_skill_data_01/ui/00_param/skill_ability/normal_skill_data_01.nsd

            // name => ui/gui_cmn/ui/00_message/skill/normal_skill_name_01.gmd
            // info => skill/normal_skill_data_01/ui/00_message/skill/normal_skill_info_01.gmd
            // command => skill/normal_skill_data_01/ui/00_message/skill/normal_skill_command_01.gmd

            gmdFilePathSkillName = "ui/gui_cmn/ui/00_message/skill/" + filePath.getFileName().toString().replace("normal_skill_data_", "normal_skill_name_").replace(".nsd", ".gmd");

            String tmp = PathUtil.getRelativeFilePathFromRom(filePath).replace("00_param", "00_message").replace(".nsd", ".gmd");;
            gmdFilePathSkillInfo = tmp.replace("skill_ability/normal_skill_data_", "skill/normal_skill_info_");
            gmdFilePathSkillCommand = tmp.replace("skill_ability/normal_skill_data_", "skill/normal_skill_command_");
        }else{
            gmdFilePathSkillName = null;
            gmdFilePathSkillInfo = null;
            gmdFilePathSkillCommand = null;
        }

        return new NormalSkillDataList(bufferReader.readArray(br -> readNormalSkillData(br, lookupUtil, gmdFilePathSkillName, gmdFilePathSkillInfo, gmdFilePathSkillCommand)));
    }
}
