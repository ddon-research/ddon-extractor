package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.stage;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.stage.*;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.stage.meta.LayoutSetInfoType;


@Slf4j
public class LayoutDeserializer extends ClientResourceFileDeserializer {
    public LayoutDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }


    private static SetInfoCoord readSetInfoCoord(FileReader fileReader) {
        return new SetInfoCoord(
                fileReader.readNullTerminatedString(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readSignedInteger()
        );
    }

    private static SetInfoEnemy readSetInfoEnemy(FileReader fileReader) {
        return new SetInfoEnemy(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                readSetInfoCoord(fileReader)
        );
    }

    private static SetInfoNpc readSetInfoNpc(FileReader fileReader) {
        return new SetInfoNpc(
                fileReader.readSignedInteger(),
                fileReader.readNullTerminatedString(),
                fileReader.readBoolean(),
                fileReader.readUnsignedByte(),
                fileReader.readSignedByte(),
                fileReader.readSignedByte(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                readSetInfoCoord(fileReader)
        );
    }

    private static SetInfoGeneralPoint readSetInfoGeneralPoint(FileReader fileReader) {
        return new SetInfoGeneralPoint(
                readSetInfoCoord(fileReader),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    private static SetInfoOmGather readSetInfoOmGather(FileReader fileReader) {
        return new SetInfoOmGather(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmLadder readSetInfoOmLadder(FileReader fileReader) {
        return new SetInfoOmLadder(
                fileReader.readSignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmWarp readSetInfoOmWarp(FileReader fileReader) {
        return new SetInfoOmWarp(
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmBoard readSetInfoOmBoard(FileReader fileReader) {
        return new SetInfoOmBoard(
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmCtrlLinkParam readSetInfoOmCtrlLinkParam(FileReader fileReader) {
        return new SetInfoOmCtrlLinkParam(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedLong()
        );
    }

    private static SetInfoOmCtrl readSetInfoOmCtrl(FileReader fileReader) {
        return new SetInfoOmCtrl(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(4, LayoutDeserializer::readSetInfoOmCtrlLinkParam),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmElfSW readSetInfoOmElfSW(FileReader fileReader) {
        return new SetInfoOmElfSW(
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmFall readSetInfoOmFall(FileReader fileReader) {
        return new SetInfoOmFall(
                fileReader.readFloat(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmLever readSetInfoOmLever(FileReader fileReader) {
        return new SetInfoOmLever(
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedLong(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmRange readSetInfoOmRange(FileReader fileReader) {
        return new SetInfoOmRange(
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmText readSetInfoOmText(FileReader fileReader) {
        return new SetInfoOmText(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmWall readSetInfoOmWall(FileReader fileReader) {
        return new SetInfoOmWall(
                fileReader.readUnsignedInteger(),
                fileReader.readOrientedBoundingBox(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmHakuryuu readSetInfoOmHakuryuu(FileReader fileReader) {
        return new SetInfoOmHakuryuu(
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOm readSetInfoOm(FileReader fileReader) {
        return new SetInfoOm(
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                readSetInfoCoord(fileReader)
        );
    }

    private static SetInfoOmDoor readSetInfoOmDoor(FileReader fileReader) {
        return new SetInfoOmDoor(
                fileReader.readBoolean(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmBowlOfLife readSetInfoOmBowlOfLife(FileReader fileReader) {
        return new SetInfoOmBowlOfLife(
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmNav readSetInfoOmNav(FileReader fileReader) {
        return new SetInfoOmNav(
                fileReader.readVector3f(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmHeal readSetInfoOmHeal(FileReader fileReader) {
        return new SetInfoOmHeal(
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmBadStatus readSetInfoOmBadStatus(FileReader fileReader) {
        return new SetInfoOmBadStatus(
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmBlock readSetInfoOmBlock(FileReader fileReader) {
        return new SetInfoOmBlock(
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmEx readSetInfoOmEx(FileReader fileReader) {
        return new SetInfoOmEx(
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmOldDoor readSetInfoOmOldDoor(FileReader fileReader) {
        return new SetInfoOmOldDoor(
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                readSetInfoOm(fileReader)
        );
    }

    private static SetInfoOmOneWay readSetInfoOmOneWay(FileReader fileReader) {
        return new SetInfoOmOneWay(
                fileReader.readFixedLengthArray(4, FileReader::readVector3f),
                readSetInfoOmEx(fileReader)
        );
    }

    private static SetInfoOmBreakTarget readSetInfoOmBreakTarget(FileReader fileReader) {
        return new SetInfoOmBreakTarget(
                fileReader.readUnsignedInteger(),
                readSetInfoOm(fileReader)
        );
    }

    private static LayoutSetInfo readLayoutSetInfo(FileReader fileReader) {
        int ID = fileReader.readSignedInteger();
        long Type = fileReader.readUnsignedInteger();
        SetInfo Info = null;

        switch (LayoutSetInfoType.of(Type)) {
            case LayoutSetInfoType.SetInfoOm -> Info = readSetInfoOm(fileReader);
            case LayoutSetInfoType.SetInfoEnemy -> Info = readSetInfoEnemy(fileReader);
            case LayoutSetInfoType.SetInfoNpc -> Info = readSetInfoNpc(fileReader);
            case LayoutSetInfoType.SetInfoGeneralPoint -> Info = readSetInfoGeneralPoint(fileReader);
            case LayoutSetInfoType.SetInfoOmGather, LayoutSetInfoType.SetInfoOmTreasureBox ->
                    Info = readSetInfoOmGather(fileReader);
            case LayoutSetInfoType.SetInfoOmLadder -> Info = readSetInfoOmLadder(fileReader);
            case LayoutSetInfoType.SetInfoOmWarp -> Info = readSetInfoOmWarp(fileReader);
            case LayoutSetInfoType.SetInfoOmBoard -> Info = readSetInfoOmBoard(fileReader);
            case LayoutSetInfoType.SetInfoOmCtrl -> Info = readSetInfoOmCtrl(fileReader);
            case LayoutSetInfoType.SetInfoOmElfSW -> Info = readSetInfoOmElfSW(fileReader);
            case LayoutSetInfoType.SetInfoOmFall -> Info = readSetInfoOmFall(fileReader);
            case LayoutSetInfoType.SetInfoOmLever -> Info = readSetInfoOmLever(fileReader);
            case LayoutSetInfoType.SetInfoOmRange -> Info = readSetInfoOmRange(fileReader);
            case LayoutSetInfoType.SetInfoOmText -> Info = readSetInfoOmText(fileReader);
            case LayoutSetInfoType.SetInfoOmWall -> Info = readSetInfoOmWall(fileReader);
            case LayoutSetInfoType.SetInfoOmHakuryuu -> Info = readSetInfoOmHakuryuu(fileReader);
            case LayoutSetInfoType.SetInfoOmDoor -> Info = readSetInfoOmDoor(fileReader);
            case LayoutSetInfoType.SetInfoOmBowlOfLife -> Info = readSetInfoOmBowlOfLife(fileReader);
            case LayoutSetInfoType.SetInfoOmNav -> Info = readSetInfoOmNav(fileReader);
            case LayoutSetInfoType.SetInfoOmHeal -> Info = readSetInfoOmHeal(fileReader);
            case LayoutSetInfoType.SetInfoOmBadStatus -> Info = readSetInfoOmBadStatus(fileReader);
            case LayoutSetInfoType.SetInfoOmBlock -> Info = readSetInfoOmBlock(fileReader);
            case LayoutSetInfoType.SetInfoOmEx -> Info = readSetInfoOmEx(fileReader);
            case LayoutSetInfoType.SetInfoOmOldDoor -> Info = readSetInfoOmOldDoor(fileReader);
            case LayoutSetInfoType.SetInfoOmOneWay -> Info = readSetInfoOmOneWay(fileReader);
            case LayoutSetInfoType.SetInfoOmBreakTarget -> Info = readSetInfoOmBreakTarget(fileReader);
            default -> log.error("Unhandled layout type: {}", Type);
        }

        return new LayoutSetInfo(
                ID,
                Type,
                Info
        );
    }

    @Override
    protected Layout parseClientResourceFile(FileReader fileReader) {
        return new Layout(
                fileReader.readFixedLengthArray(22, FileReader::readUnsignedInteger),
                fileReader.readArray(LayoutDeserializer::readLayoutSetInfo)
        );
    }
}
