package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.LayoutSetInfoType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.LayoutUnitKind;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@Slf4j
public class LayoutDeserializer extends ClientResourceFileDeserializer<Layout> {
    private static final Pattern stageNoPattern = Pattern.compile("(?:^|[\\\\/])st(\\d+)");

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
                bufferReader.readSignedInteger(),
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

        long TalkStateId = bufferReader.readUnsignedInteger();

        boolean DispElseQuestTalk = bufferReader.readBoolean();
        boolean ForceSwitchGreeting = bufferReader.readBoolean();
        boolean UseAttendComponent = bufferReader.readBoolean();
        boolean UseLiteMotion = bufferReader.readBoolean();

        boolean IsNoSetOnPS3 = bufferReader.readBoolean();
        boolean UseJobParamEx = bufferReader.readBoolean();
        boolean DispOnWeapon = bufferReader.readBoolean();

        short InitEffectType = bufferReader.readSignedShort();
        SetInfoCoord InfoCharacter = readSetInfoCoord(bufferReader);

        return new SetInfoNpc(NpcId, NpcName, FilePath, IsCommunicate, ClothType, DefNPCMotCategory, DefNPCMotNo,
                ThinkIndex, JobLv, Lantern, DisableScrAdj, DisableLedgerFinger, IsForceListTalk, IsAttand,
                DisableTouchAction, DispElseQuestTalk, ForceSwitchGreeting, UseAttendComponent, TalkStateId,
                UseLiteMotion, IsNoSetOnPS3, UseJobParamEx, DispOnWeapon, InitEffectType, InfoCharacter);
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

    private static SetInfoOmLimitWarp readSetInfoOmLimitWarp(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long LimitSpotID = bufferReader.readUnsignedInteger();
        List<Long> StageNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> StartPosNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> QuestId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> FlagNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> SpotId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        long TextType = bufferReader.readUnsignedInteger();
        long TextQuestNo = bufferReader.readUnsignedInteger();
        long TextNo = bufferReader.readUnsignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        Translation LimitSpotName = null;
        List<Translation> StageNames = new ArrayList<>(StageNo.size());
        List<Translation> QuestNames = new ArrayList<>(QuestId.size());
        List<Translation> SpotNames = new ArrayList<>(SpotId.size());
        if (lookupUtil != null) {
            LimitSpotName = lookupUtil.getSpotName(LimitSpotID);
            StageNo.forEach(s -> StageNames.add(lookupUtil.getStageNameByStageNo(s.intValue())));
            QuestId.forEach(s -> QuestNames.add(lookupUtil.getQuestName(s)));
            SpotId.forEach(s -> SpotNames.add(lookupUtil.getSpotName(s)));
        }

        return new SetInfoOmLimitWarp(LimitSpotID, LimitSpotName, StageNo, StageNames, StartPosNo, QuestId, QuestNames, FlagNo, SpotId, SpotNames, TextType, TextQuestNo, TextNo, InfoOm);
    }

    private static SetInfoOmRimWarp readSetInfoOmRimWarp(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        boolean NoWarp = bufferReader.readBoolean();
        int Kind = bufferReader.readUnsignedShort();
        int Group = bufferReader.readUnsignedShort();
        int ID = bufferReader.readSignedInteger();
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

        return new SetInfoOmRimWarp(NoWarp, Kind, Group, ID, StageNo, StageNames, StartPosNo, QuestId, QuestNames, FlagNo, SpotId, SpotNames, TextType, TextQuestNo, TextNo, InfoOm);
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

    private static SetInfoOmCtrl readSetInfoOmCtrl(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long KeyItemNo = bufferReader.readUnsignedInteger();
        boolean IsQuest = bufferReader.readBoolean();
        long QuestId = bufferReader.readUnsignedInteger();
        List<SetInfoOmCtrlLinkParam> LinkParam = bufferReader.readFixedLengthArray(4, LayoutDeserializer::readSetInfoOmCtrlLinkParam);
        int AddGroupNo = bufferReader.readSignedInteger();
        int AddSubGroupNo = bufferReader.readSignedInteger();
        long EmHpRate = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation KeyItemName = null;
        Translation QuestName = null;
        if (lookupUtil != null) {
            KeyItemName = lookupUtil.getItemName(KeyItemNo);
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        boolean ControlsKeyDoorMechanism = false;
        List<SetInfoOmCtrlLinkParam> omParams = LinkParam.stream().filter(p -> p.getKindType() == LayoutUnitKind.U_OM).toList();
        // Known patterns:
        // 1x EM unknown what this does, very few exist
        // 1x EM for 1x OM (enemy group unlocks door),
        // >=2x EM for 1x OM (different enemy groups unlock door),
        // 1x OM for 1x OM (lever unlocks door)
        // 1x EM & 1x OM for 1x OM is a dead ID which can be ignored (only exists in 821+824)
        // There are never more than 2x OM in a single SetInfoOmCtrl
        if (!omParams.isEmpty()) {
            log.debug("SetInfoOmCtrl has a high chance of controlling a key door!");
            ControlsKeyDoorMechanism = true;
        }

        return new SetInfoOmCtrl(KeyItemNo, KeyItemName, IsQuest, QuestId, QuestName, LinkParam, ControlsKeyDoorMechanism, AddGroupNo, AddSubGroupNo, EmHpRate, InfoOm);
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

    private static SetInfoOmDoor readSetInfoOmDoor(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        boolean PRT = bufferReader.readBoolean();
        Vector3f PRTPos = bufferReader.readVector3f();
        float PRTScale = bufferReader.readFloat();
        long TextType = bufferReader.readUnsignedInteger();
        long TextQuestNo = bufferReader.readUnsignedInteger();
        long TextNo = bufferReader.readUnsignedInteger();
        long QuestID = bufferReader.readUnsignedInteger();
        long QuestFlag = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

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
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new SetInfoOmBowlOfLife(WaitBowlOfLife, FullBowlOfLife, SetEM, Invisible, IsQuest, QuestId, QuestName, Kind, Group, ID, InfoOm);
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

    private static SetInfoOmBlock readSetInfoOmBlock(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestID = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestID);
        }

        return new SetInfoOmBlock(QuestID, QuestName, InfoOm);
    }

    private static SetInfoOmEx readSetInfoOmEx(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestID = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

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
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new SetInfoOmOldDoor(IsQuest, QuestId, QuestName, Kind0, Group0, ID0, Kind1, Group1, ID1, Kind2, Group2, ID2, InfoOm);
    }

    private static SetInfoOmXXX readSetInfoOmXXX(BufferReader bufferReader) {
        return new SetInfoOmXXX(
                bufferReader.readSignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmCannon readSetInfoOmCannon(BufferReader bufferReader) {
        boolean Homing = bufferReader.readBoolean();
        boolean AutoFire = bufferReader.readBoolean();
        float AngleX = bufferReader.readFloat();
        long CannonType = bufferReader.readUnsignedInteger();
        long BreakHitNum = bufferReader.readUnsignedInteger();
        short Group = bufferReader.readSignedShort();
        short GroupID = bufferReader.readSignedShort();
        float CannonHeightLimit = bufferReader.readFloat();
        float DistanceLimitMin = bufferReader.readFloat();
        float DistanceLimitMax = bufferReader.readFloat();
        long ShotInterval = bufferReader.readUnsignedInteger();
        int ShotIdleFrequency = bufferReader.readUnsignedByte();
        int CheckAngle = bufferReader.readUnsignedByte();

        SetInfoOmOld setInfoOmOld = readSetInfoOmOld(bufferReader);

        return new SetInfoOmCannon(Homing, AutoFire, AngleX, CannonType, BreakHitNum, Group, GroupID, CannonHeightLimit, DistanceLimitMin, DistanceLimitMax, ShotInterval, ShotIdleFrequency, CheckAngle, setInfoOmOld);
    }

    private static SetInfoOmActText readSetInfoOmActText(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long PLActNo = bufferReader.readUnsignedInteger();
        long TextNo = bufferReader.readUnsignedInteger();
        long TextQuestNo = bufferReader.readUnsignedInteger();
        long TextType = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(TextQuestNo);
        }

        return new SetInfoOmActText(PLActNo, TextNo, TextQuestNo, QuestName, TextType, InfoOm);
    }

    private static SetInfoOmPLJump readSetInfoOmPLJump(BufferReader bufferReader) {
        return new SetInfoOmPLJump(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmPlCannon readSetInfoOmPlCannon(BufferReader bufferReader) {
        return new SetInfoOmPlCannon(
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
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

    private static SetInfoOmBreakRecovery readSetInfoOmBreakRecovery(BufferReader bufferReader) {
        return new SetInfoOmBreakRecovery(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmBreakHeal readSetInfoOmBreakHeal(BufferReader bufferReader) {
        return new SetInfoOmBreakHeal(
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmMagmaSpring readSetInfoOmMagmaSpring(BufferReader bufferReader) {
        return new SetInfoOmMagmaSpring(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmTreasureBoxG readSetInfoOmTreasureBoxG(BufferReader bufferReader) {
        return new SetInfoOmTreasureBoxG(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmFlagMapMarker readSetInfoOmFlagMapMarker(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long RedQuestFlag = bufferReader.readUnsignedInteger();
        long RedQuestID = bufferReader.readUnsignedInteger();
        long BlueQuestFlag = bufferReader.readUnsignedInteger();
        long BlueQuestID = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation RedQuestName = null;
        Translation BlueQuestName = null;
        if (lookupUtil != null) {
            RedQuestName = lookupUtil.getQuestName(RedQuestID);
            BlueQuestName = lookupUtil.getQuestName(BlueQuestID);
        }

        return new SetInfoOmFlagMapMarker(RedQuestFlag, RedQuestID, RedQuestName, BlueQuestFlag, BlueQuestID, BlueQuestName, InfoOm);
    }

    private static SetInfoOm511380 readSetInfoOm511380(BufferReader bufferReader) {
        return new SetInfoOm511380(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmGauge readSetInfoOmGauge(BufferReader bufferReader) {
        return new SetInfoOmGauge(
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmHugeRimShl readSetInfoOmHugeRimShl(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int ShotGrp = bufferReader.readSignedInteger();
        long ShotInterval = bufferReader.readUnsignedInteger();
        int WeatherID = bufferReader.readSignedInteger();
        long StartHour = bufferReader.readUnsignedInteger();
        long EndHour = bufferReader.readUnsignedInteger();
        boolean Boundary = bufferReader.readBoolean();
        Vector3f BoundaryPos = bufferReader.readVector3f();
        float BoundaryRadius = bufferReader.readFloat();
        boolean Block = bufferReader.readBoolean();
        int Kind = bufferReader.readUnsignedShort();
        int Grp = bufferReader.readUnsignedShort();
        int ID = bufferReader.readSignedInteger();
        boolean BlockQuest = bufferReader.readBoolean();
        long BlockQuestID = bufferReader.readUnsignedInteger();
        long BlockQuestFlag = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation BlockQuestName = null;
        if (lookupUtil != null) {
            BlockQuestName = lookupUtil.getQuestName(BlockQuestID);
        }

        return new SetInfoOmHugeRimShl(ShotGrp, ShotInterval, WeatherID, StartHour, EndHour, Boundary, BoundaryPos,
                BoundaryRadius, Block, Kind, Grp, ID, BlockQuest, BlockQuestID, BlockQuestName, BlockQuestFlag, InfoOm);
    }

    private static SetInfoOmRisingMagma readSetInfoOmRisingMagma(BufferReader bufferReader) {
        return new SetInfoOmRisingMagma(
                bufferReader.readFixedLengthArray(6, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(5, BufferReader::readFloat),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmMagmaFall readSetInfoOmMagmaFall(BufferReader bufferReader) {
        return new SetInfoOmMagmaFall(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmGrpID readSetInfoOmGrpID(BufferReader bufferReader) {
        return new SetInfoOmGrpID(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmVolcano readSetInfoOmVolcano(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int ShotGrp = bufferReader.readSignedInteger();
        long ShotInterval = bufferReader.readUnsignedInteger();
        int WeatherID = bufferReader.readSignedInteger();
        long ShotPtn = bufferReader.readUnsignedInteger();
        long StartHour = bufferReader.readUnsignedInteger();
        long EndHour = bufferReader.readUnsignedInteger();
        boolean Boundary = bufferReader.readBoolean();
        Vector3f BoundaryPos = bufferReader.readVector3f();
        float BoundaryRadius = bufferReader.readFloat();
        boolean Block = bufferReader.readBoolean();
        int Kind = bufferReader.readUnsignedShort();
        int Grp = bufferReader.readUnsignedShort();
        int ID = bufferReader.readSignedInteger();
        boolean BlockQuest = bufferReader.readBoolean();
        long BlockQuestID = bufferReader.readUnsignedInteger();
        long BlockQuestFlag = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation BlockQuestName = null;
        if (lookupUtil != null) {
            BlockQuestName = lookupUtil.getQuestName(BlockQuestID);
        }

        return new SetInfoOmVolcano(ShotGrp, ShotInterval, WeatherID, ShotPtn, StartHour, EndHour, Boundary, BoundaryPos,
                BoundaryRadius, Block, Kind, Grp, ID, BlockQuest, BlockQuestID, BlockQuestName, BlockQuestFlag, InfoOm);
    }

    private static SetInfoOmRisingMagma2 readSetInfoOmRisingMagma2(BufferReader bufferReader) {
        return new SetInfoOmRisingMagma2(
                bufferReader.readFixedLengthArray(4, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(4, BufferReader::readFloat),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmWarpFX readSetInfoOmWarpFX(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long MemberCount = bufferReader.readUnsignedInteger();
        List<Long> StageNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> StartPosNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> QuestId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> FlagNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> SpotId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        long TextType = bufferReader.readSignedInteger();
        long TextQuestNo = bufferReader.readSignedInteger();
        long TextNo = bufferReader.readSignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        List<Translation> StageNames = new ArrayList<>(StageNo.size());
        List<Translation> QuestNames = new ArrayList<>(QuestId.size());
        List<Translation> SpotNames = new ArrayList<>(SpotId.size());
        if (lookupUtil != null) {
            StageNo.forEach(s -> StageNames.add(lookupUtil.getStageNameByStageNo(s.intValue())));
            QuestId.forEach(s -> QuestNames.add(lookupUtil.getQuestName(s)));
            SpotId.forEach(s -> SpotNames.add(lookupUtil.getSpotName(s)));
        }

        return new SetInfoOmWarpFX(MemberCount, StageNo, StageNames, StartPosNo, QuestId, QuestNames, FlagNo, SpotId, SpotNames, TextType, TextQuestNo, TextNo, InfoOm);
    }

    private static SetInfoEnemyLinked readSetInfoEnemyLinked(BufferReader bufferReader) {
        return new SetInfoEnemyLinked(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                readSetInfoCoord(bufferReader)
        );
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
                readSetInfoOmOld(bufferReader)
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
            case LayoutSetInfoType.SetInfoOmCannon -> Info = readSetInfoOmCannon(bufferReader);
            case LayoutSetInfoType.SetInfoOmXXX -> Info = readSetInfoOmXXX(bufferReader);
            case LayoutSetInfoType.SetInfoOmLimitWarp -> Info = readSetInfoOmLimitWarp(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmActText -> Info = readSetInfoOmActText(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmPLJump -> Info = readSetInfoOmPLJump(bufferReader);
            case LayoutSetInfoType.SetInfoOmPlCannon -> Info = readSetInfoOmPlCannon(bufferReader);
            case LayoutSetInfoType.SetInfoOmBreakRecovery -> Info = readSetInfoOmBreakRecovery(bufferReader);
            case LayoutSetInfoType.SetInfoOmBreakHeal -> Info = readSetInfoOmBreakHeal(bufferReader);
            case LayoutSetInfoType.SetInfoOmOld -> Info = readSetInfoOmOld(bufferReader);
            case LayoutSetInfoType.SetInfoOmTreasureBoxG -> Info = readSetInfoOmTreasureBoxG(bufferReader);
            case LayoutSetInfoType.SetInfoOmRimWarp -> Info = readSetInfoOmRimWarp(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmMagmaSpring -> Info = readSetInfoOmMagmaSpring(bufferReader);
            case LayoutSetInfoType.SetInfoOmFlagMapMarker ->
                    Info = readSetInfoOmFlagMapMarker(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOm511380 -> Info = readSetInfoOm511380(bufferReader);
            case LayoutSetInfoType.SetInfoOmGauge -> Info = readSetInfoOmGauge(bufferReader);
            case LayoutSetInfoType.SetInfoOmHugeRimShl -> Info = readSetInfoOmHugeRimShl(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmRisingMagma -> Info = readSetInfoOmRisingMagma(bufferReader);
            case LayoutSetInfoType.SetInfoOmMagmaFall -> Info = readSetInfoOmMagmaFall(bufferReader);
            case LayoutSetInfoType.SetInfoOmRisingMagma2 -> Info = readSetInfoOmRisingMagma2(bufferReader);
            case LayoutSetInfoType.SetInfoOmGrpID -> Info = readSetInfoOmGrpID(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarpFX -> Info = readSetInfoOmWarpFX(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoEnemyLinked -> Info = readSetInfoEnemyLinked(bufferReader);
            case LayoutSetInfoType.SetInfoOmVolcano -> Info = readSetInfoOmVolcano(bufferReader, lookupUtil);
            default -> log.error("Unhandled layout type: {}", Type);
        }

        return new LayoutSetInfo(ID, Type, Info);
    }

    @Override
    protected Layout parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        List<Long> SetInfoNeedNums = bufferReader.readFixedLengthArray(22, BufferReader::readUnsignedInteger);
        List<LayoutSetInfo> Array = bufferReader.readArray(br -> readLayoutSetInfo(br, lookupUtil));

        // stage/st0414/lot/st0414_00m00n/scr/st0414/etc/st0414_00m00n_n02.lot
        int StageNo = stageNoPattern.matcher(filePath.toString()).results().findFirst()
                .map(m -> Integer.parseInt(m.group(1), 10))
                .orElse(-1);

        int AreaId = -1;
        Translation StageName = null;
        Translation AreaName = null;
        if (StageNo > 0 && lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
            AreaId = (int) lookupUtil.getAreaIdByStageNo(StageNo);
            AreaName = lookupUtil.getAreaName(AreaId);
        }

        return new Layout(SetInfoNeedNums, Array, StageNo, StageName, AreaId, AreaName);
    }
}
