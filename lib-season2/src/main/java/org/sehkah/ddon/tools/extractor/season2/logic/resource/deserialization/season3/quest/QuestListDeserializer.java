package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.quest;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.OrientedBoundingBox;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.binary.XfsDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.binary.ClassData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.binary.XfsHeader;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.binary.XfsObjectData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.quest.*;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.SetInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.meta.LayoutUnitKind;

import java.util.List;
import java.util.Map;

public class QuestListDeserializer extends ClientResourceFileDeserializer {
    public QuestListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestSetInfoCoord readQuestSetInfoCoord(BufferReader bufferReader) {
        String Name = XfsDeserializer.readNullTerminatedString(bufferReader);
        int UnitID = XfsDeserializer.readSignedInteger(bufferReader);
        Vector3f Position = XfsDeserializer.readVector3f(bufferReader);
        Vector3f Angle = XfsDeserializer.readVector3f(bufferReader);
        Vector3f Scale = XfsDeserializer.readVector3f(bufferReader);
        int AreaHitNo = XfsDeserializer.readSignedInteger(bufferReader);
        long Version = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoCoord(Name, UnitID, Position, Angle, Scale, AreaHitNo, Version);
    }

    private static FSMRelate readFSMRelate(BufferReader bufferReader) {
        String FSMName = XfsDeserializer.readNullTerminatedString(bufferReader);
        int FSMType = XfsDeserializer.readUnsignedByte(bufferReader);

        return new FSMRelate(FSMName, FSMType);
    }

    private static QuestSetInfoNpc readQuestSetInfoNpc(BufferReader bufferReader) {
        QuestSetInfoCoord InfoCharacter = readQuestSetInfoCoord(bufferReader);
        int NpcId = XfsDeserializer.readSignedInteger(bufferReader);
        FSMRelate FsmResource = readFSMRelate(bufferReader);
        boolean IsCommunicate = XfsDeserializer.readBoolean(bufferReader);
        int ClothType = XfsDeserializer.readUnsignedByte(bufferReader);
        byte DefNPCMotCategory = XfsDeserializer.readSignedByte(bufferReader);
        byte DefNPCMotNo = XfsDeserializer.readSignedByte(bufferReader);
        int ThinkIndex = XfsDeserializer.readUnsignedShort(bufferReader);
        int JobLv = XfsDeserializer.readUnsignedShort(bufferReader);
        int Lantern = XfsDeserializer.readUnsignedByte(bufferReader);
        boolean DisableScrAdj = XfsDeserializer.readBoolean(bufferReader);
        boolean DisableLedgerFinger = XfsDeserializer.readBoolean(bufferReader);
        boolean IsForceListTalk = XfsDeserializer.readBoolean(bufferReader);
        boolean IsAttand = XfsDeserializer.readBoolean(bufferReader);
        boolean UseAttendComponent = XfsDeserializer.readBoolean(bufferReader);
        boolean DisableTouchAction = XfsDeserializer.readBoolean(bufferReader);
        boolean DispElseQuestTalk = XfsDeserializer.readBoolean(bufferReader);
        boolean ForceSwitchGreeting = XfsDeserializer.readBoolean(bufferReader);
        long TalkStateId = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean UseLiteMotion = XfsDeserializer.readBoolean(bufferReader);
        boolean IsNoSetOnPS3 = XfsDeserializer.readBoolean(bufferReader);
        boolean UseJobParamEx = XfsDeserializer.readBoolean(bufferReader);
        boolean DispOnWeapon = XfsDeserializer.readBoolean(bufferReader);
        short InitEffectType = XfsDeserializer.readSignedShort(bufferReader);

        return new QuestSetInfoNpc(InfoCharacter, NpcId, FsmResource, IsCommunicate, ClothType, DefNPCMotCategory, DefNPCMotNo, ThinkIndex, JobLv, Lantern, DisableScrAdj, DisableLedgerFinger, IsForceListTalk, IsAttand, UseAttendComponent, DisableTouchAction, DispElseQuestTalk, ForceSwitchGreeting, TalkStateId, UseLiteMotion, IsNoSetOnPS3, UseJobParamEx, DispOnWeapon, InitEffectType);
    }

    private static QuestSetInfoOm readQuestSetInfoOm(BufferReader bufferReader) {
        QuestSetInfoCoord InfoCharacter = readQuestSetInfoCoord(bufferReader);
        boolean DisableEffect = XfsDeserializer.readBoolean(bufferReader);
        boolean DisableOnlyEffect = XfsDeserializer.readBoolean(bufferReader);
        boolean OpenFlag = XfsDeserializer.readBoolean(bufferReader);
        boolean EnableSyncLight = XfsDeserializer.readBoolean(bufferReader);
        boolean EnableZone = XfsDeserializer.readBoolean(bufferReader);
        long InitMtnNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long AreaMasterNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        int AreaReleaseNo = XfsDeserializer.readUnsignedShort(bufferReader);
        boolean AreaReleaseON = XfsDeserializer.readBoolean(bufferReader);
        boolean AreaReleaseOFF = XfsDeserializer.readBoolean(bufferReader);
        long WarpPointId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long KeyNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsBreakLink = XfsDeserializer.readBoolean(bufferReader);
        boolean IsBreakQuest = XfsDeserializer.readBoolean(bufferReader);
        int BreakKind = XfsDeserializer.readUnsignedShort(bufferReader);
        int BreakGroup = XfsDeserializer.readUnsignedShort(bufferReader);
        int BreakID = XfsDeserializer.readUnsignedShort(bufferReader);
        long QuestFlag = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsNoSbc = XfsDeserializer.readBoolean(bufferReader);
        boolean IsMyQuest = XfsDeserializer.readBoolean(bufferReader);

        return new QuestSetInfoOm(InfoCharacter, DisableEffect, DisableOnlyEffect, OpenFlag, EnableSyncLight, EnableZone, InitMtnNo, AreaMasterNo, AreaReleaseNo, AreaReleaseON, AreaReleaseOFF, WarpPointId, KeyNo, IsBreakLink, IsBreakQuest, BreakKind, BreakGroup, BreakID, QuestFlag, IsNoSbc, IsMyQuest);
    }

    private static QuestSetInfoOmWall readQuestSetInfoOmWall(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);
        long WallType = XfsDeserializer.readUnsignedInteger(bufferReader);
        OrientedBoundingBox NavOBB = XfsDeserializer.readOrientedBoundingBox(bufferReader);

        return new QuestSetInfoOmWall(InfoOm, WallType, NavOBB);
    }

    private static QuestSetInfoOmWarp readQuestSetInfoOmWarp(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);
        List<Long> StageNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> StartPosNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> QuestNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> FlagNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> SpotId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        long TextType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TextQuestNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TextNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean NoWarp = XfsDeserializer.readBoolean(bufferReader);

        return new QuestSetInfoOmWarp(InfoOm, StageNo, StartPosNo, QuestNo, FlagNo, SpotId, TextType, TextQuestNo, TextNo, NoWarp);
    }

    private static QuestSetInfoOmDoor readQuestSetInfoOmDoor(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        boolean PRT = XfsDeserializer.readBoolean(bufferReader);
        Vector3f PRTPos = XfsDeserializer.readVector3f(bufferReader);
        float PRTScale = XfsDeserializer.readFloat(bufferReader);
        long TextType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TextQuestNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TextNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long QuestID = XfsDeserializer.readUnsignedInteger(bufferReader);
        long QuestFlag = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoOmDoor(InfoOm, PRT, PRTPos, PRTScale, TextType, TextQuestNo, TextNo, QuestID, QuestFlag);
    }

    private static QuestSetInfoOmBowlOfLife readQuestSetInfoOmBowlOfLife(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);
        boolean WaitBowlOfLife = XfsDeserializer.readBoolean(bufferReader);
        boolean FullBowlOfLife = XfsDeserializer.readBoolean(bufferReader);
        boolean SetEM = XfsDeserializer.readBoolean(bufferReader);
        boolean Invisible = XfsDeserializer.readBoolean(bufferReader);
        boolean IsQuest = XfsDeserializer.readBoolean(bufferReader);
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        int Kind = XfsDeserializer.readUnsignedShort(bufferReader);
        int Group = XfsDeserializer.readUnsignedShort(bufferReader);
        int ID = XfsDeserializer.readUnsignedShort(bufferReader);

        return new QuestSetInfoOmBowlOfLife(InfoOm, WaitBowlOfLife, FullBowlOfLife, SetEM, Invisible, IsQuest, QuestId, Kind, Group, ID);
    }

    private static QuestSetInfoOmText readQuestSetInfoOmText(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        long TextNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TextQuestNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TextType = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoOmText(InfoOm, TextNo, TextQuestNo, TextType);
    }

    private static QuestSetInfoOmTextUnknown readQuestSetInfoOmTextUnknown(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        long TextNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TextQuestNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TextType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long PLActNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoOmTextUnknown(InfoOm, TextNo, TextQuestNo, TextType, PLActNo);
    }

    private static QuestSetInfoOmBadStatus readQuestSetInfoOmBadStatus(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        float BadRadius = XfsDeserializer.readFloat(bufferReader);
        float BadHeight = XfsDeserializer.readFloat(bufferReader);
        Vector3f BadPos = XfsDeserializer.readVector3f(bufferReader);
        long BreakHitNum = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoOmBadStatus(InfoOm, BadRadius, BadHeight, BadPos, BreakHitNum);
    }

    private static QuestSetInfoOmBreakTarget readQuestSetInfoOmBreakTarget(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        long BreakHitNum = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoOmBreakTarget(InfoOm, BreakHitNum);
    }

    private static QuestSetInfoOmGather readQuestSetInfoOmGather(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        long ItemListID = XfsDeserializer.readUnsignedInteger(bufferReader);
        long GatheringType = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsGatherEnemy = XfsDeserializer.readBoolean(bufferReader);
        short EnemyGroupNo = XfsDeserializer.readSignedShort(bufferReader);

        return new QuestSetInfoOmGather(InfoOm, ItemListID, GatheringType, IsGatherEnemy, EnemyGroupNo);
    }

    private static QuestSetInfoOmTreasureBox readQuestSetInfoOmTreasureBox(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        long ItemListID = XfsDeserializer.readUnsignedInteger(bufferReader);
        long GatheringType = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsGatherEnemy = XfsDeserializer.readBoolean(bufferReader);
        short EnemyGroupNo = XfsDeserializer.readSignedShort(bufferReader);

        return new QuestSetInfoOmTreasureBox(InfoOm, ItemListID, GatheringType, IsGatherEnemy, EnemyGroupNo);
    }

    private static QuestSetInfoOmRange readQuestSetInfoOmRange(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        float Range = XfsDeserializer.readFloat(bufferReader);
        long Grp = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsAll = XfsDeserializer.readBoolean(bufferReader);
        boolean IsOneTime = XfsDeserializer.readBoolean(bufferReader);

        return new QuestSetInfoOmRange(InfoOm, Range, Grp, IsAll, IsOneTime);
    }

    private static QuestSetInfoOmHakuryuu readQuestSetInfoOmHakuryuu(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        long StoneLevel = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoOmHakuryuu(InfoOm, StoneLevel);
    }

    private static QuestSetInfoOmCtrlLinkParam readQuestSetInfoOmCtrlLinkParam(BufferReader bufferReader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        int Kind = XfsDeserializer.readUnsignedShort(bufferReader);
        int Group = XfsDeserializer.readUnsignedShort(bufferReader);
        int ID = XfsDeserializer.readUnsignedShort(bufferReader);
        long Transition = XfsDeserializer.readUnsignedInteger(bufferReader);
        long State = XfsDeserializer.readUnsignedInteger(bufferReader);
        int CamEvNo = XfsDeserializer.readSignedInteger(bufferReader);
        String FSM = XfsDeserializer.readNullTerminatedString(bufferReader);

        return new QuestSetInfoOmCtrlLinkParam(Kind, Group, ID, Transition, State, CamEvNo, FSM);
    }

    private static QuestSetInfoOmCtrl readQuestSetInfoOmCtrl(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        long KeyItemNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsQuest = XfsDeserializer.readBoolean(bufferReader);
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        List<QuestSetInfoOmCtrlLinkParam> LinkParam = bufferReader.readArray(QuestListDeserializer::readQuestSetInfoOmCtrlLinkParam);
        int AddGroupNo = XfsDeserializer.readSignedInteger(bufferReader);
        int AddSubGroupNo = XfsDeserializer.readSignedInteger(bufferReader);
        long EmHpRate = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoOmCtrl(InfoOm, KeyItemNo, IsQuest, QuestId, LinkParam, AddGroupNo, AddSubGroupNo, EmHpRate);
    }

    private static QuestSetInfoOmLever readQuestSetInfoOmLever(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        boolean ReqLever = XfsDeserializer.readBoolean(bufferReader);
        int CamEvNo = XfsDeserializer.readSignedInteger(bufferReader);
        String FSM = XfsDeserializer.readNullTerminatedString(bufferReader);

        return new QuestSetInfoOmLever(InfoOm, ReqLever, CamEvNo, FSM);
    }

    private static QuestSetInfoOmHeal readQuestSetInfoOmHeal(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        long HealType = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new QuestSetInfoOmHeal(InfoOm, HealType);
    }

    private static QuestSetInfoOmCannon readQuestSetInfoOmCannon(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        boolean Homing = XfsDeserializer.readBoolean(bufferReader);
        boolean AutoFire = XfsDeserializer.readBoolean(bufferReader);
        float AngleX = XfsDeserializer.readFloat(bufferReader);
        long CannonType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long BreakHitNum = XfsDeserializer.readUnsignedInteger(bufferReader);
        short Group = XfsDeserializer.readSignedShort(bufferReader);
        short GroupID = XfsDeserializer.readSignedShort(bufferReader);
        float CannonHeightLimit = XfsDeserializer.readFloat(bufferReader);
        float DistanceLimitMin = XfsDeserializer.readFloat(bufferReader);
        float DistanceLimitMax = XfsDeserializer.readFloat(bufferReader);
        long ShotInterval = XfsDeserializer.readUnsignedInteger(bufferReader);
        int ShotIdleFrequency = XfsDeserializer.readUnsignedByte(bufferReader);
        int CheckAngle = XfsDeserializer.readUnsignedByte(bufferReader);

        return new QuestSetInfoOmCannon(InfoOm, Homing, AutoFire, AngleX, CannonType, BreakHitNum, Group, GroupID, CannonHeightLimit, DistanceLimitMin, DistanceLimitMax, ShotInterval, ShotIdleFrequency, CheckAngle);
    }

    private static QuestSetInfoOmTimer readQuestSetInfoOmTimer(BufferReader bufferReader) {
        QuestSetInfoOm InfoOm = readQuestSetInfoOm(bufferReader);

        float Timer = XfsDeserializer.readFloat(bufferReader);

        return new QuestSetInfoOmTimer(InfoOm, Timer);
    }

    private static SetInfo readSetInfo(BufferReader bufferReader, XfsHeader xfsHeader, long kind) {
        XfsObjectData setInfoObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        Map<Integer, ClassData> classHeaderIndexMap = xfsHeader.classHeaderIndex();
        LayoutUnitKind layoutUnitKind = LayoutUnitKind.of(kind);

        return switch (layoutUnitKind) {
            case U_OM -> switch (classHeaderIndexMap.get(setInfoObjectData.classIndex()).resourceName()) {
                case "cSetInfoOmWall" -> readQuestSetInfoOmWall(bufferReader);
                case "cSetInfoOmWarp" -> readQuestSetInfoOmWarp(bufferReader);
                case "cSetInfoOmDoor" -> readQuestSetInfoOmDoor(bufferReader);
                case "cSetInfoOmBowlOfLife" -> readQuestSetInfoOmBowlOfLife(bufferReader);
                case "cSetInfoOmText" -> readQuestSetInfoOmText(bufferReader);
                case "cSetInfoOmBadStatus" -> readQuestSetInfoOmBadStatus(bufferReader);
                case "cSetInfoOmBreakTarget" -> readQuestSetInfoOmBreakTarget(bufferReader);
                case "cSetInfoOmGather" -> readQuestSetInfoOmGather(bufferReader);
                case "cSetInfoOmTreasureBox" -> readQuestSetInfoOmTreasureBox(bufferReader);
                case "cSetInfoOmRange" -> readQuestSetInfoOmRange(bufferReader);
                case "cSetInfoOmHakuryuu" -> readQuestSetInfoOmHakuryuu(bufferReader);
                case "cSetInfoOmCtrl" -> readQuestSetInfoOmCtrl(bufferReader);
                case "cSetInfoOmLever" -> readQuestSetInfoOmLever(bufferReader);
                case "cSetInfoOmHeal" -> readQuestSetInfoOmHeal(bufferReader);
                case "cSetInfoOmCannon" -> readQuestSetInfoOmCannon(bufferReader);
                case "cSetInfoOmTimer" -> readQuestSetInfoOmTimer(bufferReader);
                default -> {
                    if (classHeaderIndexMap.get(setInfoObjectData.classIndex()).ID() == 100955604L) {
                        yield readQuestSetInfoOmTextUnknown(bufferReader);
                    } else {
                        yield readQuestSetInfoOm(bufferReader);
                    }
                }
            };
            case U_NPC -> readQuestSetInfoNpc(bufferReader);
            default -> throw new IllegalStateException("Unexpected value: " + LayoutUnitKind.of(kind));
        };
    }

    private static QuestSet readQuestSet(BufferReader bufferReader, XfsHeader xfsHeader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        long OmID = XfsDeserializer.readUnsignedInteger(bufferReader);
        long UnitNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        String Comment = XfsDeserializer.readJapaneseNullTerminatedString(bufferReader);
        long Kind = XfsDeserializer.readUnsignedInteger(bufferReader);
        SetInfo setInfo = XfsDeserializer.readXfsProperty(bufferReader, br -> readSetInfo(bufferReader, xfsHeader, Kind));

        return new QuestSet(OmID, UnitNo, Comment, Kind, setInfo);
    }

    private static QuestGroup readQuestGroup(BufferReader bufferReader, XfsHeader xfsHeader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        long GroupNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        String Comment = XfsDeserializer.readJapaneseNullTerminatedString(bufferReader);
        int Condition = XfsDeserializer.readSignedInteger(bufferReader);
        int EraseCondition = XfsDeserializer.readSignedInteger(bufferReader);
        List<QuestSet> QuestSet = XfsDeserializer.readMtArray(bufferReader, br -> readQuestSet(br, xfsHeader));

        return new QuestGroup(GroupNo, Comment, Condition, EraseCondition, QuestSet);
    }

    private static QuestStage readQuestStage(BufferReader bufferReader, XfsHeader xfsHeader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        int StageNo = XfsDeserializer.readSignedInteger(bufferReader);
        List<QuestGroup> QuestGrp = XfsDeserializer.readMtArray(bufferReader, br -> readQuestGroup(br, xfsHeader));

        return new QuestStage(StageNo, QuestGrp);
    }

    @Override
    protected QuestList parseClientResourceFile(BufferReader bufferReader) {
        // Account for hacky workaround to make a unique resourceVersion by reading in both the deserializer and class resourceVersion initially
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        XfsHeader xfsHeader = XfsDeserializer.readHeader(bufferReader);
        XfsDeserializer.readResource(bufferReader);

        return new QuestList(XfsDeserializer.readMtArray(bufferReader, br -> readQuestStage(br, xfsHeader)));
    }
}
