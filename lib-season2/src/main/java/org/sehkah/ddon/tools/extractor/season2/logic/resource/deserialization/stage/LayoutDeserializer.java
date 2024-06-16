package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.*;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta.LayoutSetInfoType;

import java.nio.file.Path;
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

    private static SetInfoNpc readSetInfoNpc(BufferReader bufferReader) {
        return new SetInfoNpc(
                bufferReader.readSignedInteger(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedByte(),
                bufferReader.readSignedByte(),
                bufferReader.readSignedByte(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                readSetInfoCoord(bufferReader)
        );
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

    private static SetInfoOmWarp readSetInfoOmWarp(BufferReader bufferReader) {
        return new SetInfoOmWarp(
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                readSetInfoOm(bufferReader)
        );
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
        Translation KeyItemName = null;
        if (lookupUtil != null) {
            KeyItemName = lookupUtil.getItemName(KeyItemId);
        }
        boolean IsQuest = bufferReader.readBoolean();
        long QuestId = bufferReader.readUnsignedInteger();
        List<SetInfoOmCtrlLinkParam> LinkParam = bufferReader.readFixedLengthArray(4, LayoutDeserializer::readSetInfoOmCtrlLinkParam);
        int AddGroupNo = bufferReader.readSignedInteger();
        int AddSubGroupNo = bufferReader.readSignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        return new SetInfoOmCtrl(KeyItemId, KeyItemName, IsQuest, QuestId, LinkParam, AddGroupNo, AddSubGroupNo, InfoOm);
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

    private static SetInfoOmDoor readSetInfoOmDoor(BufferReader bufferReader) {
        return new SetInfoOmDoor(
                bufferReader.readBoolean(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmBowlOfLife readSetInfoOmBowlOfLife(BufferReader bufferReader) {
        return new SetInfoOmBowlOfLife(
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                readSetInfoOm(bufferReader)
        );
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

    private static SetInfoOmBlock readSetInfoOmBlock(BufferReader bufferReader) {
        return new SetInfoOmBlock(
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmEx readSetInfoOmEx(BufferReader bufferReader) {
        return new SetInfoOmEx(
                bufferReader.readUnsignedInteger(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmOldDoor readSetInfoOmOldDoor(BufferReader bufferReader) {
        return new SetInfoOmOldDoor(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                readSetInfoOm(bufferReader)
        );
    }

    private static SetInfoOmOneWay readSetInfoOmOneWay(BufferReader bufferReader) {
        return new SetInfoOmOneWay(
                bufferReader.readFixedLengthArray(4, BufferReader::readVector3f),
                readSetInfoOmEx(bufferReader)
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
            case LayoutSetInfoType.SetInfoNpc -> Info = readSetInfoNpc(bufferReader);
            case LayoutSetInfoType.SetInfoGeneralPoint -> Info = readSetInfoGeneralPoint(bufferReader);
            case LayoutSetInfoType.SetInfoOmGather, LayoutSetInfoType.SetInfoOmTreasureBox ->
                    Info = readSetInfoOmGather(bufferReader);
            case LayoutSetInfoType.SetInfoOmLadder -> Info = readSetInfoOmLadder(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarp -> Info = readSetInfoOmWarp(bufferReader);
            case LayoutSetInfoType.SetInfoOmBoard -> Info = readSetInfoOmBoard(bufferReader);
            case LayoutSetInfoType.SetInfoOmCtrl -> Info = readSetInfoOmCtrl(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmElfSW -> Info = readSetInfoOmElfSW(bufferReader);
            case LayoutSetInfoType.SetInfoOmFall -> Info = readSetInfoOmFall(bufferReader);
            case LayoutSetInfoType.SetInfoOmLever -> Info = readSetInfoOmLever(bufferReader);
            case LayoutSetInfoType.SetInfoOmRange -> Info = readSetInfoOmRange(bufferReader);
            case LayoutSetInfoType.SetInfoOmText -> Info = readSetInfoOmText(bufferReader);
            case LayoutSetInfoType.SetInfoOmWall -> Info = readSetInfoOmWall(bufferReader);
            case LayoutSetInfoType.SetInfoOmHakuryuu -> Info = readSetInfoOmHakuryuu(bufferReader);
            case LayoutSetInfoType.SetInfoOmDoor -> Info = readSetInfoOmDoor(bufferReader);
            case LayoutSetInfoType.SetInfoOmBowlOfLife -> Info = readSetInfoOmBowlOfLife(bufferReader);
            case LayoutSetInfoType.SetInfoOmNav -> Info = readSetInfoOmNav(bufferReader);
            case LayoutSetInfoType.SetInfoOmHeal -> Info = readSetInfoOmHeal(bufferReader);
            case LayoutSetInfoType.SetInfoOmBadStatus -> Info = readSetInfoOmBadStatus(bufferReader);
            case LayoutSetInfoType.SetInfoOmBlock -> Info = readSetInfoOmBlock(bufferReader);
            case LayoutSetInfoType.SetInfoOmEx -> Info = readSetInfoOmEx(bufferReader);
            case LayoutSetInfoType.SetInfoOmOldDoor -> Info = readSetInfoOmOldDoor(bufferReader);
            case LayoutSetInfoType.SetInfoOmOneWay -> Info = readSetInfoOmOneWay(bufferReader);
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
