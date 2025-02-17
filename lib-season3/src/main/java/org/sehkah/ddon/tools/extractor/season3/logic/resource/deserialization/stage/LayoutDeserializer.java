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
                bufferReader.readUnsignedInteger(),
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
        boolean UseAttendComponent = bufferReader.readBoolean();
        boolean DisableTouchAction = bufferReader.readBoolean();

        long TalkStateId = bufferReader.readUnsignedInteger();

        boolean DispElseQuestTalk = bufferReader.readBoolean();
        boolean ForceSwitchGreeting = bufferReader.readBoolean();
        boolean UseLiteMotion = bufferReader.readBoolean();

        boolean IsNoSetOnPS3 = bufferReader.readBoolean();
        boolean UseJobParamEx = bufferReader.readBoolean();
        boolean DispOnWeapon = bufferReader.readBoolean();

        short InitEffectType = bufferReader.readSignedShort();
        SetInfoCoord InfoCharacter = readSetInfoCoord(bufferReader);

        return new SetInfoNpc(NpcId, NpcName, FilePath, IsCommunicate, ClothType, DefNPCMotCategory, DefNPCMotNo, ThinkIndex, JobLv, Lantern, DisableScrAdj, DisableLedgerFinger, IsForceListTalk, IsAttand, UseAttendComponent, DisableTouchAction, TalkStateId, DispElseQuestTalk, ForceSwitchGreeting, UseLiteMotion, IsNoSetOnPS3, UseJobParamEx, DispOnWeapon, InitEffectType, InfoCharacter);
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

    private static SetInfoOmWarpNew readSetInfoOmWarpNew(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long UnknownStageNo = bufferReader.readUnsignedInteger();
        List<Long> StageNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> StartPosNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> QuestId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> FlagNo = bufferReader.readArray(BufferReader::readUnsignedInteger);
        List<Long> SpotId = bufferReader.readArray(BufferReader::readUnsignedInteger);
        long TextType = bufferReader.readUnsignedInteger();
        long TextQuestNo = bufferReader.readUnsignedInteger();
        long TextNo = bufferReader.readUnsignedInteger();
        SetInfoOm InfoOm = readSetInfoOm(bufferReader);

        Translation UnknownStageName = null;
        List<Translation> StageNames = new ArrayList<>(StageNo.size());
        List<Translation> QuestNames = new ArrayList<>(QuestId.size());
        List<Translation> SpotNames = new ArrayList<>(SpotId.size());
        if (lookupUtil != null) {
            UnknownStageName = lookupUtil.getStageNameByStageNo((int) UnknownStageNo);
            StageNo.forEach(s -> StageNames.add(lookupUtil.getStageNameByStageNo(s.intValue())));
            QuestId.forEach(s -> QuestNames.add(lookupUtil.getQuestName(s)));
            SpotId.forEach(s -> SpotNames.add(lookupUtil.getSpotName(s)));
        }

        return new SetInfoOmWarpNew(UnknownStageNo, UnknownStageName, StageNo, StageNames, StartPosNo, QuestId, QuestNames, FlagNo, SpotId, SpotNames, TextType, TextQuestNo, TextNo, InfoOm);
    }

    private static SetInfoOmWarpNewV3 readSetInfoOmWarpNewV3(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        boolean Unknown1 = bufferReader.readBoolean();
        int Unknown2 = bufferReader.readUnsignedShort();
        int Unknown3 = bufferReader.readUnsignedShort();
        int Unknown4 = bufferReader.readSignedInteger();
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

        return new SetInfoOmWarpNewV3(Unknown1, Unknown2, Unknown3, Unknown4, StageNo, StageNames, StartPosNo, QuestId, QuestNames, FlagNo, SpotId, SpotNames, TextType, TextQuestNo, TextNo, InfoOm);
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

    private static SetInfoOmCtrl readSetInfoOmCtrl(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, Path filePath) {
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

    private static SetInfoOmLeverNew readSetInfoOmLeverNew(BufferReader bufferReader) {
        return new SetInfoOmLeverNew(
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

    private static SetInfoOmUnknown30 readSetInfoOmUnknown30(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long UnknownStageNo = bufferReader.readUnsignedInteger();
        long Unknown1 = bufferReader.readUnsignedInteger();
        long QuestId = bufferReader.readUnsignedInteger();
        long Unknown2 = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation QuestName = null;
        Translation UnknownStageName = null;
        if (lookupUtil != null) {
            UnknownStageName = lookupUtil.getStageNameByStageNo((int) UnknownStageNo);
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new SetInfoOmUnknown30(UnknownStageNo, UnknownStageName, Unknown1, QuestId, QuestName, Unknown2, InfoOm);
    }

    private static SetInfoOmGeyser readSetInfoOmUnknown31(BufferReader bufferReader) {
        return new SetInfoOmGeyser(
                bufferReader.readVector4f(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmReloadableCannon readSetInfoOmUnknown32(BufferReader bufferReader) {
        return new SetInfoOmReloadableCannon(
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

    private static SetInfoOmFlag readSetInfoOmFlag(BufferReader bufferReader) {
        return new SetInfoOmFlag(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmMagicBreakableWall readSetInfoOmUnknown34(BufferReader bufferReader) {
        return new SetInfoOmMagicBreakableWall(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmLavaGeyser readSetInfoOmUnknown45(BufferReader bufferReader) {
        return new SetInfoOmLavaGeyser(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readVector4f(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmSealedTreasureBox readSetInfoOmSealedTreasureBox(BufferReader bufferReader) {
        return new SetInfoOmSealedTreasureBox(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmUnknown46 readSetInfoOmUnknown46(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestFlag1 = bufferReader.readUnsignedInteger();
        long QuestId1 = bufferReader.readUnsignedInteger();
        long QuestFlag2 = bufferReader.readUnsignedInteger();
        long QuestId2 = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation QuestName1 = null;
        Translation QuestName2 = null;
        if (lookupUtil != null) {
            QuestName1 = lookupUtil.getQuestName(QuestId1);
            QuestName2 = lookupUtil.getQuestName(QuestId2);
        }

        return new SetInfoOmUnknown46(QuestFlag1, QuestId1, QuestName1, QuestFlag2, QuestId2, QuestName2, InfoOm);
    }

    private static SetInfoOmEpitaphBarrier readSetInfoOmUnknown47(BufferReader bufferReader) {
        return new SetInfoOmEpitaphBarrier(
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmDragonHornStaff readSetInfoOmUnknown48(BufferReader bufferReader) {
        return new SetInfoOmDragonHornStaff(
                bufferReader.readUnsignedInteger(),
                readSetInfoOmOld(bufferReader)
        );
    }

    private static SetInfoOmThunderstorm readSetInfoOmUnknown49(BufferReader bufferReader) {
        return new SetInfoOmThunderstorm(
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

    private static SetInfoOmUnknown55 readSetInfoOmUnknown55(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long Unknown1 = bufferReader.readUnsignedInteger();
        long Unknown2 = bufferReader.readUnsignedInteger();
        long Unknown3 = bufferReader.readUnsignedInteger();
        long Unknown4 = bufferReader.readUnsignedInteger();
        long Unknown5 = bufferReader.readUnsignedInteger();
        long Unknown6 = bufferReader.readUnsignedInteger();
        long Unknown7 = bufferReader.readUnsignedInteger();
        long Unknown8 = bufferReader.readUnsignedInteger();
        long Unknown9 = bufferReader.readUnsignedInteger();
        boolean Unknown10 = bufferReader.readBoolean();
        float Unknown11 = bufferReader.readFloat();
        boolean Unknown12 = bufferReader.readBoolean();
        long Unknown13 = bufferReader.readUnsignedInteger();
        int Unknown14 = bufferReader.readSignedInteger();
        boolean IsQuest = bufferReader.readBoolean();
        long QuestId = bufferReader.readUnsignedInteger();
        long QuestFlag = bufferReader.readUnsignedInteger();
        SetInfoOmOld InfoOm = readSetInfoOmOld(bufferReader);

        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new SetInfoOmUnknown55(Unknown1, Unknown2, Unknown3, Unknown4, Unknown5, Unknown6, Unknown7, Unknown8, Unknown9, Unknown10, Unknown11, Unknown12, Unknown13, Unknown14, IsQuest, QuestId, QuestName, QuestFlag, InfoOm);
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

    private static SetInfoOmWarpNewV2 readSetInfoOmWarpNewV2(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long Unknown = bufferReader.readUnsignedInteger();
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

        return new SetInfoOmWarpNewV2(Unknown, StageNo, StageNames, StartPosNo, QuestId, QuestNames, FlagNo, SpotId, SpotNames, TextType, TextQuestNo, TextNo, InfoOm);
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

    private static LayoutSetInfo readLayoutSetInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, Path filePath) {
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
            case LayoutSetInfoType.SetInfoOmCtrl -> Info = readSetInfoOmCtrl(bufferReader, lookupUtil, filePath);
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
            case LayoutSetInfoType.SetInfoOmLeverNew -> Info = readSetInfoOmLeverNew(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarpNew -> Info = readSetInfoOmWarpNew(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmUnknown30 -> Info = readSetInfoOmUnknown30(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmUnknown31 -> Info = readSetInfoOmUnknown31(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown32 -> Info = readSetInfoOmUnknown32(bufferReader);
            case LayoutSetInfoType.SetInfoOmFlag -> Info = readSetInfoOmFlag(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown34 -> Info = readSetInfoOmUnknown34(bufferReader);
            case LayoutSetInfoType.SetInfoOmOld -> Info = readSetInfoOmOld(bufferReader);
            case LayoutSetInfoType.SetInfoOmSealedTreasureBox -> Info = readSetInfoOmSealedTreasureBox(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarpNewV3 -> Info = readSetInfoOmWarpNewV3(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmUnknown45 -> Info = readSetInfoOmUnknown45(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown46 -> Info = readSetInfoOmUnknown46(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoOmUnknown47 -> Info = readSetInfoOmUnknown47(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown48 -> Info = readSetInfoOmUnknown48(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown49 -> Info = readSetInfoOmUnknown49(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown50 -> Info = readSetInfoOmUnknown50(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown51 -> Info = readSetInfoOmUnknown51(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown52 -> Info = readSetInfoOmUnknown52(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown53 -> Info = readSetInfoOmUnknown53(bufferReader);
            case LayoutSetInfoType.SetInfoOmWarpNewV2 -> Info = readSetInfoOmWarpNewV2(bufferReader, lookupUtil);
            case LayoutSetInfoType.SetInfoEnemyV2 -> Info = readSetInfoEnemyV2(bufferReader);
            case LayoutSetInfoType.SetInfoOmUnknown55 -> Info = readSetInfoOmUnknown55(bufferReader, lookupUtil);
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
        List<LayoutSetInfo> Array = bufferReader.readArray(br -> readLayoutSetInfo(br, lookupUtil, filePath));

        return new Layout(SetInfoNeedNums, Array);
    }
}
