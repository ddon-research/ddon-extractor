package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.*;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.meta.LayoutSetInfoType;


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
                fileReader.readUnsignedInteger(),
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
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
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
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmLadder readSetInfoOmLadder(FileReader fileReader) {
        return new SetInfoOmLadder(
                fileReader.readSignedInteger(),
                readSetInfoOmOld(fileReader)
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

    private static SetInfoOmWarpNew readSetInfoOmWarpNew(FileReader fileReader) {
        return new SetInfoOmWarpNew(
                fileReader.readUnsignedInteger(),
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

    private static SetInfoOmWarpNewV3 readSetInfoOmWarpNewV3(FileReader fileReader) {
        return new SetInfoOmWarpNewV3(
                fileReader.readBoolean(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedInteger(),
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
                readSetInfoOmOld(fileReader)
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
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmElfSW readSetInfoOmElfSW(FileReader fileReader) {
        return new SetInfoOmElfSW(
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmFall readSetInfoOmFall(FileReader fileReader) {
        return new SetInfoOmFall(
                fileReader.readFloat(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmLever readSetInfoOmLever(FileReader fileReader) {
        return new SetInfoOmLever(
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedLong(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmRange readSetInfoOmRange(FileReader fileReader) {
        return new SetInfoOmRange(
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmText readSetInfoOmText(FileReader fileReader) {
        return new SetInfoOmText(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmWall readSetInfoOmWall(FileReader fileReader) {
        return new SetInfoOmWall(
                fileReader.readUnsignedInteger(),
                fileReader.readOrientedBoundingBox(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmHakuryuu readSetInfoOmHakuryuu(FileReader fileReader) {
        return new SetInfoOmHakuryuu(
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOm readSetInfoOm(FileReader fileReader) {
        return new SetInfoOm(
                fileReader.readBoolean(),
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

    private static SetInfoOmOld readSetInfoOmOld(FileReader fileReader) {
        return new SetInfoOmOld(
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
                readSetInfoOmOld(fileReader)
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
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmNav readSetInfoOmNav(FileReader fileReader) {
        return new SetInfoOmNav(
                fileReader.readVector3f(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmHeal readSetInfoOmHeal(FileReader fileReader) {
        return new SetInfoOmHeal(
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmBadStatus readSetInfoOmBadStatus(FileReader fileReader) {
        return new SetInfoOmBadStatus(
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmBlock readSetInfoOmBlock(FileReader fileReader) {
        return new SetInfoOmBlock(
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmEx readSetInfoOmEx(FileReader fileReader) {
        return new SetInfoOmEx(
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
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
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown28 readSetInfoOmUnknown28(FileReader fileReader) {
        return new SetInfoOmUnknown28(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown27 readSetInfoOmUnknown27(FileReader fileReader) {
        return new SetInfoOmUnknown27(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown30 readSetInfoOmUnknown30(FileReader fileReader) {
        return new SetInfoOmUnknown30(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown31 readSetInfoOmUnknown31(FileReader fileReader) {
        return new SetInfoOmUnknown31(
                fileReader.readVector4f(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown32 readSetInfoOmUnknown32(FileReader fileReader) {
        return new SetInfoOmUnknown32(
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown33 readSetInfoOmUnknown33(FileReader fileReader) {
        return new SetInfoOmUnknown33(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown34 readSetInfoOmUnknown34(FileReader fileReader) {
        return new SetInfoOmUnknown34(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown45 readSetInfoOmUnknown45(FileReader fileReader) {
        return new SetInfoOmUnknown45(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                fileReader.readVector4f(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown42 readSetInfoOmUnknown42(FileReader fileReader) {
        return new SetInfoOmUnknown42(
                fileReader.readBoolean(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown46 readSetInfoOmUnknown46(FileReader fileReader) {
        return new SetInfoOmUnknown46(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown47 readSetInfoOmUnknown47(FileReader fileReader) {
        return new SetInfoOmUnknown47(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown48 readSetInfoOmUnknown48(FileReader fileReader) {
        return new SetInfoOmUnknown48(
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown49 readSetInfoOmUnknown49(FileReader fileReader) {
        return new SetInfoOmUnknown49(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown50 readSetInfoOmUnknown50(FileReader fileReader) {
        return new SetInfoOmUnknown50(
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown51 readSetInfoOmUnknown51(FileReader fileReader) {
        return new SetInfoOmUnknown51(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown53 readSetInfoOmUnknown53(FileReader fileReader) {
        return new SetInfoOmUnknown53(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown55 readSetInfoOmUnknown55(FileReader fileReader) {
        return new SetInfoOmUnknown55(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmUnknown52 readSetInfoOmUnknown52(FileReader fileReader) {
        return new SetInfoOmUnknown52(
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readSetInfoOmOld(fileReader)
        );
    }

    private static SetInfoOmWarpNewV2 readSetInfoOmWarpNewV2(FileReader fileReader) {
        return new SetInfoOmWarpNewV2(
                fileReader.readUnsignedInteger(),
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

    private static SetInfoEnemyV2 readSetInfoEnemyV2(FileReader fileReader) {
        return new SetInfoEnemyV2(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                readSetInfoCoord(fileReader)
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
                readSetInfoOmOld(fileReader)
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
            case LayoutSetInfoType.SetInfoOmUnknown27 -> Info = readSetInfoOmUnknown27(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown28 -> Info = readSetInfoOmUnknown28(fileReader);
            case LayoutSetInfoType.SetInfoOmWarpNew -> Info = readSetInfoOmWarpNew(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown30 -> Info = readSetInfoOmUnknown30(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown31 -> Info = readSetInfoOmUnknown31(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown32 -> Info = readSetInfoOmUnknown32(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown33 -> Info = readSetInfoOmUnknown33(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown34 -> Info = readSetInfoOmUnknown34(fileReader);
            case LayoutSetInfoType.SetInfoOmOld -> Info = readSetInfoOmOld(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown42 -> Info = readSetInfoOmUnknown42(fileReader);
            case LayoutSetInfoType.SetInfoOmWarpNewV3 -> Info = readSetInfoOmWarpNewV3(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown45 -> Info = readSetInfoOmUnknown45(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown46 -> Info = readSetInfoOmUnknown46(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown47 -> Info = readSetInfoOmUnknown47(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown48 -> Info = readSetInfoOmUnknown48(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown49 -> Info = readSetInfoOmUnknown49(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown50 -> Info = readSetInfoOmUnknown50(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown51 -> Info = readSetInfoOmUnknown51(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown52 -> Info = readSetInfoOmUnknown52(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown53 -> Info = readSetInfoOmUnknown53(fileReader);
            case LayoutSetInfoType.SetInfoOmWarpNewV2 -> Info = readSetInfoOmWarpNewV2(fileReader);
            case LayoutSetInfoType.SetInfoEnemyV2 -> Info = readSetInfoEnemyV2(fileReader);
            case LayoutSetInfoType.SetInfoOmUnknown55 -> Info = readSetInfoOmUnknown55(fileReader);
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
