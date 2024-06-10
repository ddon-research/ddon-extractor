package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.PathUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.MsgData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.MsgGroup;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.MsgSet;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta.MsgGroupType;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MsgSetDeserializer extends ClientResourceFileDeserializer<MsgSet> {
    private static MsgData readMsgData(String gmdFilePath, BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int buffer = bufferReader.readUnsignedByte();

        long MsgSerial = bufferReader.readUnsignedInteger();
        long GmdIndex = bufferReader.readUnsignedInteger();
        Translation Message = null;
        if (lookupUtil != null) {
            Message = lookupUtil.getMessageTranslation(gmdFilePath, (int) GmdIndex);
        }
        long MsgType = bufferReader.readUnsignedInteger();
        long JumpGroupSerial = bufferReader.readUnsignedInteger();
        long DispType = bufferReader.readUnsignedInteger();
        long DispTime = bufferReader.readUnsignedInteger();
        long SetMotion = bufferReader.readUnsignedInteger();
        int VoiceReqNo = bufferReader.readSignedInteger();
        int TalkFaceType = bufferReader.readUnsignedByte();

        return new MsgData(MsgSerial, GmdIndex, Message, MsgType, JumpGroupSerial, DispType, DispTime, SetMotion, VoiceReqNo, TalkFaceType);
    }

    private static MsgGroup readMsgGroup(String gmdFilePath, BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int buffer = bufferReader.readUnsignedByte();

        long GroupSerial = bufferReader.readUnsignedInteger();
        long NpcId = bufferReader.readUnsignedInteger();
        Translation NpcName = null;
        if (lookupUtil != null) {
            NpcName = lookupUtil.getNpcName(NpcId);
        }
        long GroupNameSerial = bufferReader.readUnsignedInteger();
        long GroupType = bufferReader.readUnsignedInteger();
        MsgGroupType GroupTypeName = MsgGroupType.of((int) GroupType);
        boolean NameDispOff = bufferReader.readBoolean();
        List<MsgData> MsgData = bufferReader.readArray(br -> MsgSetDeserializer.readMsgData(gmdFilePath, br, lookupUtil));
        return new MsgGroup(GroupSerial, NpcId, NpcName, GroupNameSerial, GroupType, GroupTypeName, NameDispOff, MsgData);
    }

    @Override
    protected MsgSet parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long NativeMsgGroupArrayNum = bufferReader.readUnsignedInteger();
        long NativeMsgDataArrayNum = bufferReader.readUnsignedInteger();

        final String gmdFilePath;
        if (lookupUtil != null) {
            gmdFilePath = PathUtil.getRelativeFilePathFromRom(filePath).replace(".mss", ".gmd");
        } else {
            gmdFilePath = null;
        }

        List<MsgGroup> NativeMsgGroupArray = new ArrayList<>((int) NativeMsgGroupArrayNum);
        for (int i = 0; i < NativeMsgGroupArrayNum; i++) {
            NativeMsgGroupArray.add(readMsgGroup(gmdFilePath, bufferReader, lookupUtil));
        }

        return new MsgSet(
                NativeMsgGroupArrayNum,
                NativeMsgDataArrayNum,
                NativeMsgGroupArray
        );
    }
}
