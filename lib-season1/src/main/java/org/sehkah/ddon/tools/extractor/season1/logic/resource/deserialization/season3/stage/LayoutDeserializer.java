package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.stage;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.meta.LayoutSetInfoType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.*;


@Slf4j
public class LayoutDeserializer extends ClientResourceFileDeserializer {
    public LayoutDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }


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
                bufferReader.readUnsignedInteger(),
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
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readSignedShort(),
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
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmLadder readSetInfoOmLadder(BufferReader bufferReader) {
        return new SetInfoOmLadder(
                bufferReader.readSignedInteger(),
                readSetInfoOmOld(bufferReader)
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

    private static SetInfoOmWarpNew readSetInfoOmWarpNew(BufferReader bufferReader) {
        return new SetInfoOmWarpNew(
                bufferReader.readUnsignedInteger(),
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

    private static SetInfoOmWarpNewV3 readSetInfoOmWarpNewV3(BufferReader bufferReader) {
        return new SetInfoOmWarpNewV3(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
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
                readSetInfoOmOld(bufferReader)
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

    private static SetInfoOmCtrl readSetInfoOmCtrl(BufferReader bufferReader) {
        return new SetInfoOmCtrl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(4, LayoutDeserializer::readSetInfoOmCtrlLinkParam),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmElfSW readSetInfoOmElfSW(BufferReader bufferReader) {
        return new SetInfoOmElfSW(
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmFall readSetInfoOmFall(BufferReader bufferReader) {
        return new SetInfoOmFall(
                bufferReader.readFloat(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmLever readSetInfoOmLever(BufferReader bufferReader) {
        return new SetInfoOmLever(
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedLong(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmRange readSetInfoOmRange(BufferReader bufferReader) {
        return new SetInfoOmRange(
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmText readSetInfoOmText(BufferReader bufferReader) {
        return new SetInfoOmText(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmWall readSetInfoOmWall(BufferReader bufferReader) {
        return new SetInfoOmWall(
                bufferReader.readUnsignedInteger(),
                bufferReader.readOrientedBoundingBox(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmHakuryuu readSetInfoOmHakuryuu(BufferReader bufferReader) {
        return new SetInfoOmHakuryuu(
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOm readSetInfoOm(BufferReader bufferReader) {
        return new SetInfoOm(
                bufferReader.readBoolean(),
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

    private static SetInfoOmOld readSetInfoOmOld(BufferReader bufferReader) {
        return new SetInfoOmOld(
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
                readSetInfoOmOld(bufferReader)
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
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmNav readSetInfoOmNav(BufferReader bufferReader) {
        return new SetInfoOmNav(
                bufferReader.readVector3f(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmHeal readSetInfoOmHeal(BufferReader bufferReader) {
        return new SetInfoOmHeal(
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmBadStatus readSetInfoOmBadStatus(BufferReader bufferReader) {
        return new SetInfoOmBadStatus(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmBlock readSetInfoOmBlock(BufferReader bufferReader) {
        return new SetInfoOmBlock(
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmEx readSetInfoOmEx(BufferReader bufferReader) {
        return new SetInfoOmEx(
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
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
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown28 readSetInfoOmUnknown28(BufferReader bufferReader) {
        return new SetInfoOmUnknown28(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown27 readSetInfoOmUnknown27(BufferReader bufferReader) {
        return new SetInfoOmUnknown27(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown30 readSetInfoOmUnknown30(BufferReader bufferReader) {
        return new SetInfoOmUnknown30(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown31 readSetInfoOmUnknown31(BufferReader bufferReader) {
        return new SetInfoOmUnknown31(
                bufferReader.readVector4f(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown32 readSetInfoOmUnknown32(BufferReader bufferReader) {
        return new SetInfoOmUnknown32(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown33 readSetInfoOmUnknown33(BufferReader bufferReader) {
        return new SetInfoOmUnknown33(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown34 readSetInfoOmUnknown34(BufferReader bufferReader) {
        return new SetInfoOmUnknown34(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown45 readSetInfoOmUnknown45(BufferReader bufferReader) {
        return new SetInfoOmUnknown45(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readVector4f(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown42 readSetInfoOmUnknown42(BufferReader bufferReader) {
        return new SetInfoOmUnknown42(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown46 readSetInfoOmUnknown46(BufferReader bufferReader) {
        return new SetInfoOmUnknown46(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown47 readSetInfoOmUnknown47(BufferReader bufferReader) {
        return new SetInfoOmUnknown47(
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown48 readSetInfoOmUnknown48(BufferReader bufferReader) {
        return new SetInfoOmUnknown48(
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown49 readSetInfoOmUnknown49(BufferReader bufferReader) {
        return new SetInfoOmUnknown49(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown50 readSetInfoOmUnknown50(BufferReader bufferReader) {
        return new SetInfoOmUnknown50(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown51 readSetInfoOmUnknown51(BufferReader bufferReader) {
        return new SetInfoOmUnknown51(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown53 readSetInfoOmUnknown53(BufferReader bufferReader) {
        return new SetInfoOmUnknown53(
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown55 readSetInfoOmUnknown55(BufferReader bufferReader) {
        return new SetInfoOmUnknown55(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown52 readSetInfoOmUnknown52(BufferReader bufferReader) {
        return new SetInfoOmUnknown52(
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmWarpNewV2 readSetInfoOmWarpNewV2(BufferReader bufferReader) {
        return new SetInfoOmWarpNewV2(
                bufferReader.readUnsignedInteger(),
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

    private static SetInfoEnemyV2 readSetInfoEnemyV2(BufferReader bufferReader) {
        return new SetInfoEnemyV2(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                readSetInfoCoord(bufferReader)
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
                readSetInfoOmOld(bufferReader)
        );
    }

    private static LayoutSetInfo readLayoutSetInfo(BufferReader bufferReader) {
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
            case LayoutSetInfoType.SetInfoOmCtrl -> Info = readSetInfoOmCtrl(bufferReader);
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
            case LayoutSetInfoType.SetInfoOmUnknown27 -> Info = readSetInfoOmUnknown27(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown28 -> Info = readSetInfoOmUnknown28(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarpNew -> Info = readSetInfoOmWarpNew(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown30 -> Info = readSetInfoOmUnknown30(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown31 -> Info = readSetInfoOmUnknown31(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown32 -> Info = readSetInfoOmUnknown32(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown33 -> Info = readSetInfoOmUnknown33(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown34 -> Info = readSetInfoOmUnknown34(bufferReader);
            case LayoutSetInfoType.SetInfoOmOld -> Info = readSetInfoOmOld(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown42 -> Info = readSetInfoOmUnknown42(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarpNewV3 -> Info = readSetInfoOmWarpNewV3(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown45 -> Info = readSetInfoOmUnknown45(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown46 -> Info = readSetInfoOmUnknown46(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown47 -> Info = readSetInfoOmUnknown47(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown48 -> Info = readSetInfoOmUnknown48(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown49 -> Info = readSetInfoOmUnknown49(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown50 -> Info = readSetInfoOmUnknown50(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown51 -> Info = readSetInfoOmUnknown51(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown52 -> Info = readSetInfoOmUnknown52(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown53 -> Info = readSetInfoOmUnknown53(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarpNewV2 -> Info = readSetInfoOmWarpNewV2(bufferReader);
            case LayoutSetInfoType.SetInfoEnemyV2 -> Info = readSetInfoEnemyV2(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown55 -> Info = readSetInfoOmUnknown55(bufferReader);
            default -> log.error("Unhandled layout type: {}", Type);
        }

        return new LayoutSetInfo(
                ID,
                Type,
                Info
        );
    }

    @Override
    protected Layout parseClientResourceFile(BufferReader bufferReader) {
        return new Layout(
                bufferReader.readFixedLengthArray(22, BufferReader::readUnsignedInteger),
                bufferReader.readArray(LayoutDeserializer::readLayoutSetInfo)
        );
    }
}
