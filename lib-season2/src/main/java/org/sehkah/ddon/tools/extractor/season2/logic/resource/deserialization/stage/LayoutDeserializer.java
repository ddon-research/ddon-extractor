package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.LayoutSetInfoType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class LayoutDeserializer extends ClientResourceFileDeserializer<Layout> {


    private static SetInfoCoord readSetInfoCoord(BufferReader bufferReader) {
        return new SetInfoCoord(
                bufferReader.readNullTerminatedString(),
                bufferReader.readSignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readSignedInteger()
        );
    }

    private static SetInfoEnemy readSetInfoEnemy(BufferReader bufferReader) {
        return new SetInfoEnemy(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoCoord(bufferReader)
        );
    }

    private static SetInfoNpc readSetInfoNpc(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int NpcId = bufferReader.readSignedInteger();
        Translation NpcName = null;
        if (lookupUtil != null) {
            NpcName = lookupUtil.getNpcName(NpcId);
        }
        String FilePath = bufferReader.readNullTerminatedString();
        boolean IsCommunicate = bufferReader.readBoolean();
        int ClothType = bufferReader.readUnsignedByte();
        byte DefNPCMotCategory = bufferReader.readSignedByte();
        byte DefNPCMotNo = bufferReader.readSignedByte();
        int ThinkIndex = bufferReader.readUnsignedShort();
        int JobLv = bufferReader.readUnsignedShort();
        int Lantern = bufferReader.readUnsignedByte();
        boolean DisableScrAdj = bufferReader.readBoolean();
        boolean DisableLedgerFinger = bufferReader.readBoolean();
        boolean IsForceListTalk = bufferReader.readBoolean();
        boolean IsAttand = bufferReader.readBoolean();
        boolean DisableTouchAction = bufferReader.readBoolean();
        boolean DispElseQuestTalk = bufferReader.readBoolean();
        SetInfoCoord InfoCharacter = readSetInfoCoord(bufferReader);

        return new SetInfoNpc(NpcId, NpcName, FilePath, IsCommunicate, ClothType, DefNPCMotCategory, DefNPCMotNo, ThinkIndex, JobLv, Lantern, DisableScrAdj, DisableLedgerFinger, IsForceListTalk, IsAttand, DisableTouchAction, DispElseQuestTalk, InfoCharacter);
    }

    private static SetInfoGeneralPoint readSetInfoGeneralPoint(BufferReader bufferReader) {
        return new SetInfoGeneralPoint(
                readSetInfoCoord(bufferReader),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    private static SetInfoOmGather readSetInfoOmGather(BufferReader bufferReader) {
        return new SetInfoOmGather(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmLadder readSetInfoOmLadder(BufferReader bufferReader) {
        return new SetInfoOmLadder(
                bufferReader.readSignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmWarp readSetInfoOmWarp(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        List<Long> StageNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> StartPosNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> QuestId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> FlagNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> SpotId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        long TextType = bufferReader.readUnsignedInteger();
        long TextQuestNo = bufferReader.readUnsignedInteger();
        long TextNo = bufferReader.readUnsignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        List<Translation> StageNames = new ArrayList<>(StageNo.size());
        List<Translation> QuestNames = new ArrayList<>(QuestId.size());
        List<Translation> SpotNames = new ArrayList<>(SpotId.size());
        if (lookupUtil != null) {
            StageNo.forEach(s -> StageNames.add(lookupUtil.getStageNameByStageNo(s.intValue())));
            QuestId.forEach(s -> QuestNames.add(lookupUtil.getQuestName(s)));
            SpotId.forEach(s -> SpotNames.add(lookupUtil.getSpotName(s)));
        }

        return new SetInfoOmWarp(StageNo, StageNames, StartPosNo, QuestId, QuestNames, FlagNo, SpotId, SpotNames, TextType, TextQuestNo, TextNo, InfoOm);
    }

    private static SetInfoOmBoard readSetInfoOmBoard(BufferReader bufferReader) {
        return new SetInfoOmBoard(
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmCtrlLinkParam readSetInfoOmCtrlLinkParam(BufferReader bufferReader) {
        return new SetInfoOmCtrlLinkParam(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedLong()
        );
    }

    private static SetInfoOmCtrl readSetInfoOmCtrl(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long KeyItemId = bufferReader.readUnsignedInteger();
        boolean IsQuest = bufferReader.readBoolean();
        long QuestId = bufferReader.readUnsignedInteger();
        List<SetInfoOmCtrlLinkParam> LinkParam = bufferReader.readFixedLengthArray(4, LayoutDeserializer::readSetInfoOmCtrlLinkParam);
        int AddGroupNo = bufferReader.readSignedInteger();
        int AddSubGroupNo = bufferReader.readSignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        Translation KeyItemName = null;
        Translation QuestName = null;
        if (lookupUtil != null) {
            KeyItemName = lookupUtil.getItemName(KeyItemId);
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new SetInfoOmCtrl(KeyItemId, KeyItemName, IsQuest, QuestId, QuestName, LinkParam, AddGroupNo, AddSubGroupNo, InfoOm);
    }

    private static SetInfoOmElfSW readSetInfoOmElfSW(BufferReader bufferReader) {
        return new SetInfoOmElfSW(
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmFall readSetInfoOmFall(BufferReader bufferReader) {
        return new SetInfoOmFall(
                bufferReader.readFloat(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmLever readSetInfoOmLever(BufferReader bufferReader) {
        return new SetInfoOmLever(
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedLong(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmRange readSetInfoOmRange(BufferReader bufferReader) {
        return new SetInfoOmRange(
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmText readSetInfoOmText(BufferReader bufferReader) {
        return new SetInfoOmText(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmWall readSetInfoOmWall(BufferReader bufferReader) {
        return new SetInfoOmWall(
                bufferReader.readUnsignedInteger(),
                bufferReader.readOrientedBoundingBox(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmHakuryuu readSetInfoOmHakuryuu(BufferReader bufferReader) {
        return new SetInfoOmHakuryuu(
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOm readSetInfoOm(BufferReader bufferReader) {
        return new SetInfoOm(
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                readSetInfoCoord(bufferReader)
        );
    }

    private static SetInfoOmDoor readSetInfoOmDoor(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        boolean PRT = bufferReader.readBoolean();
        Vector3f PRTPos = bufferReader.readVector3f();
        float PRTScale = bufferReader.readFloat();
        long TextType = bufferReader.readUnsignedInteger();
        long TextQuestNo = bufferReader.readUnsignedInteger();
        long TextNo = bufferReader.readUnsignedInteger();
        long QuestID = bufferReader.readUnsignedInteger();
        long QuestFlag = bufferReader.readUnsignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestID);
        }

        return new SetInfoOmDoor(PRT, PRTPos, PRTScale, TextType, TextQuestNo, TextNo, QuestID, QuestName, QuestFlag, InfoOm);
    }

    private static SetInfoOmBowlOfLife readSetInfoOmBowlOfLife(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        boolean WaitBowlOfLife = bufferReader.readBoolean();
        boolean FullBowlOfLife = bufferReader.readBoolean();
        boolean SetEM = bufferReader.readBoolean();
        boolean Invisible = bufferReader.readBoolean();
        boolean IsQuest = bufferReader.readBoolean();
        long QuestId = bufferReader.readUnsignedInteger();
        int Kind = bufferReader.readSignedShort();
        int Group = bufferReader.readSignedShort();
        int ID = bufferReader.readSignedShort();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new SetInfoOmBowlOfLife(WaitBowlOfLife, FullBowlOfLife, SetEM, Invisible, IsQuest, QuestId, QuestName, Kind, Group, ID, InfoOm);
    }

    private static SetInfoOmNav readSetInfoOmNav(BufferReader bufferReader) {
        return new SetInfoOmNav(
                bufferReader.readVector3f(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmHeal readSetInfoOmHeal(BufferReader bufferReader) {
        return new SetInfoOmHeal(
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmBadStatus readSetInfoOmBadStatus(BufferReader bufferReader) {
        return new SetInfoOmBadStatus(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmBlock readSetInfoOmBlock(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestID = bufferReader.readUnsignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestID);
        }

        return new SetInfoOmBlock(QuestID, QuestName, InfoOm);
    }

    private static SetInfoOmEx readSetInfoOmEx(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestID = bufferReader.readUnsignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestID);
        }

        return new SetInfoOmEx(QuestID, QuestName, InfoOm);
    }

    private static SetInfoOmOldDoor readSetInfoOmOldDoor(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        boolean IsQuest = bufferReader.readBoolean();
        long QuestId = bufferReader.readUnsignedInteger();
        int Kind0 = bufferReader.readSignedShort();
        int Group0 = bufferReader.readSignedShort();
        int ID0 = bufferReader.readSignedShort();
        int Kind1 = bufferReader.readSignedShort();
        int Group1 = bufferReader.readSignedShort();
        int ID1 = bufferReader.readSignedShort();
        int Kind2 = bufferReader.readSignedShort();
        int Group2 = bufferReader.readSignedShort();
        int ID2 = bufferReader.readSignedShort();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new SetInfoOmOldDoor(IsQuest, QuestId, QuestName, Kind0, Group0, ID0, Kind1, Group1, ID1, Kind2, Group2, ID2, InfoOm);
    }

    private static SetInfoOmOneWay readSetInfoOmOneWay(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        return new SetInfoOmOneWay(
                bufferReader.readFixedLengthArray(4, BufferReader::readVector3f),
                readSetInfoOmEx(bufferReader, lookupUtil)
        );
    }

    private static SetInfoOmBreakTarget readSetInfoOmBreakTarget(BufferReader bufferReader) {
        return new SetInfoOmBreakTarget(
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static LayoutSetInfo readLayoutSetInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int ID = bufferReader.readSignedInteger();
        long Type = bufferReader.readUnsignedInteger();
        SetInfo Info = null;

        switch (LayoutSetInfoType.of(Type)) {
            case LayoutSetInfoType.SetInfoOm -> Info = readSetInfoOm(bufferReader);
            case LayoutSetInfoType.SetInfoEnemy -> Info = readSetInfoEnemy(bufferReader);
            case LayoutSetInfoType.SetInfoNpc -> Info = readSetInfoNpc(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoGeneralPoint -> Info = readSetInfoGeneralPoint(bufferReader);
            case LayoutSetInfoType.SetInfoOmGather, LayoutSetInfoType.SetInfoOmTreasureBox ->
                    Info = readSetInfoOmGather(bufferReader);
            case LayoutSetInfoType.SetInfoOmLadder -> Info = readSetInfoOmLadder(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarp -> Info = readSetInfoOmWarp(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmBoard -> Info = readSetInfoOmBoard(bufferReader);
            case LayoutSetInfoType.SetInfoOmCtrl -> Info = readSetInfoOmCtrl(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmElfSW -> Info = readSetInfoOmElfSW(bufferReader);
            case LayoutSetInfoType.SetInfoOmFall -> Info = readSetInfoOmFall(bufferReader);
            case LayoutSetInfoType.SetInfoOmLever -> Info = readSetInfoOmLever(bufferReader);
            case LayoutSetInfoType.SetInfoOmRange -> Info = readSetInfoOmRange(bufferReader);
            case LayoutSetInfoType.SetInfoOmText -> Info = readSetInfoOmText(bufferReader);
            case LayoutSetInfoType.SetInfoOmWall -> Info = readSetInfoOmWall(bufferReader);
            case LayoutSetInfoType.SetInfoOmHakuryuu -> Info = readSetInfoOmHakuryuu(bufferReader);
            case LayoutSetInfoType.SetInfoOmDoor -> Info = readSetInfoOmDoor(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmBowlOfLife -> Info = readSetInfoOmBowlOfLife(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmNav -> Info = readSetInfoOmNav(bufferReader);
            case LayoutSetInfoType.SetInfoOmHeal -> Info = readSetInfoOmHeal(bufferReader);
            case LayoutSetInfoType.SetInfoOmBadStatus -> Info = readSetInfoOmBadStatus(bufferReader);
            case LayoutSetInfoType.SetInfoOmBlock -> Info = readSetInfoOmBlock(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmEx -> Info = readSetInfoOmEx(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmOldDoor -> Info = readSetInfoOmOldDoor(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmOneWay -> Info = readSetInfoOmOneWay(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmBreakTarget -> Info = readSetInfoOmBreakTarget(bufferReader);
            default -> log.error("Unhandled layout type: {}", Type);
        }

        return new LayoutSetInfo(
                ID,
                Type,
                Info
        );
    }

    @Override
    protected Layout parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        List<Long> SetInfoNeedNums = bufferReader.readFixedLengthArray(22, BufferReader::readUnsignedInteger);
        List<LayoutSetInfo> Array = bufferReader.readArray(LayoutDeserializer::readLayoutSetInfo, lookupUtil);

        return new Layout(SetInfoNeedNums, Array);
    }
}
