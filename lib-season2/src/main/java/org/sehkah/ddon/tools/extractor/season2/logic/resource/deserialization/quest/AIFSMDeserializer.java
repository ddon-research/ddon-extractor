package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.quest;

import org.sehkah.ddon.tools.extractor.api.datatype.Matrix;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.binary.XfsDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary.XfsBody;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary.XfsHeader;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary.XfsObjectData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.*;

import java.nio.file.Path;
import java.util.List;

public class AIFSMDeserializer extends ClientResourceFileDeserializer<AIFSM> {
    private static FSMOrderParamIsMyQuestFlag readFSMOrderParamIsMyQuestFlag(BufferReader bufferReader) {
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long FlagNo = XfsDeserializer.readSignedInteger(bufferReader);
        long ArrayIdx = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamIsMyQuestFlag(QuestId, FlagNo, ArrayIdx);
    }

    private static FSMUnitParamSetDisableTouchAction readFSMUnitParamSetDisableTouchAction(BufferReader bufferReader) {
        boolean IsDisableTouch = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetDisableTouchAction(IsDisableTouch);
    }

    private static FSMUnitParamSetChangeThink readFSMUnitParamSetChangeThink(BufferReader bufferReader) {
        long Think = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsInvincible = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetChangeThink(Think, IsInvincible);
    }

    private static FSMUnitParamSetGoto readFSMUnitParamSetGoto(BufferReader bufferReader) {
        Vector3f TargetPos = XfsDeserializer.readVector3f(bufferReader);
        int RunType = XfsDeserializer.readUnsignedByte(bufferReader);
        float StopBorder = XfsDeserializer.readFloat(bufferReader);
        boolean IsSetDir = XfsDeserializer.readBoolean(bufferReader);
        boolean IsPathFinding = XfsDeserializer.readBoolean(bufferReader);
        Vector3f Dir = XfsDeserializer.readVector3f(bufferReader);
        float Speed = XfsDeserializer.readFloat(bufferReader);

        return new FSMUnitParamSetGoto(TargetPos, RunType, StopBorder, IsSetDir, IsPathFinding, Dir, Speed);
    }

    private static FSMUnitParamSetMotion readFSMUnitParamSetMotion(BufferReader bufferReader) {
        long BankNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long MotNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        float Hokan = XfsDeserializer.readFloat(bufferReader);
        float StartFrame = XfsDeserializer.readFloat(bufferReader);
        boolean IsSetEndFrame = XfsDeserializer.readBoolean(bufferReader);
        float EndFrame = XfsDeserializer.readFloat(bufferReader);
        float MotSpeed = XfsDeserializer.readFloat(bufferReader);
        boolean IsLoop = XfsDeserializer.readBoolean(bufferReader);
        boolean IsNullTransFix = XfsDeserializer.readBoolean(bufferReader);
        boolean IsNullTransOff = XfsDeserializer.readBoolean(bufferReader);
        boolean IsNullAngleFix = XfsDeserializer.readBoolean(bufferReader);
        boolean IsSetDir = XfsDeserializer.readBoolean(bufferReader);
        boolean IsDispItem = XfsDeserializer.readBoolean(bufferReader);
        Vector3f Dir = XfsDeserializer.readVector3f(bufferReader);
        float Speed = XfsDeserializer.readFloat(bufferReader);
        boolean IsCallVoice = XfsDeserializer.readBoolean(bufferReader);
        boolean IsUseFingerMotion = XfsDeserializer.readBoolean(bufferReader);
        float FingerHokan = XfsDeserializer.readFloat(bufferReader);
        float FingerSpeed = XfsDeserializer.readFloat(bufferReader);
        long FingerMotionNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsDisableFall = XfsDeserializer.readBoolean(bufferReader);
        int MotionSeOffBank = XfsDeserializer.readSignedInteger(bufferReader);

        return new FSMUnitParamSetMotion(BankNo, MotNo, Hokan, StartFrame, IsSetEndFrame, EndFrame, MotSpeed, IsLoop,
                IsNullTransFix, IsNullTransOff, IsNullAngleFix, IsSetDir, IsDispItem, Dir, Speed, IsCallVoice,
                IsUseFingerMotion, FingerHokan, FingerSpeed, FingerMotionNo, IsDisableFall, MotionSeOffBank);
    }

    private static FSMUnitParamSetMotionV2 readFSMUnitParamSetMotionV2(BufferReader bufferReader) {
        long BankNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long MotNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        float Hokan = XfsDeserializer.readFloat(bufferReader);
        float StartFrame = XfsDeserializer.readFloat(bufferReader);
        boolean IsSetEndFrame = XfsDeserializer.readBoolean(bufferReader);
        float EndFrame = XfsDeserializer.readFloat(bufferReader);
        float MotSpeed = XfsDeserializer.readFloat(bufferReader);
        boolean IsLoop = XfsDeserializer.readBoolean(bufferReader);
        boolean IsNullTransFix = XfsDeserializer.readBoolean(bufferReader);
        boolean IsNullTransOff = XfsDeserializer.readBoolean(bufferReader);
        boolean IsNullAngleFix = XfsDeserializer.readBoolean(bufferReader);
        boolean IsSetDir = XfsDeserializer.readBoolean(bufferReader);
        boolean IsDispItem = XfsDeserializer.readBoolean(bufferReader);
        Vector3f Dir = XfsDeserializer.readVector3f(bufferReader);
        float Speed = XfsDeserializer.readFloat(bufferReader);
        boolean IsCallVoice = XfsDeserializer.readBoolean(bufferReader);
        boolean IsUseFingerMotion = XfsDeserializer.readBoolean(bufferReader);
        float FingerHokan = XfsDeserializer.readFloat(bufferReader);
        float FingerSpeed = XfsDeserializer.readFloat(bufferReader);
        long FingerMotionNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetMotionV2(BankNo, MotNo, Hokan, StartFrame, IsSetEndFrame, EndFrame, MotSpeed, IsLoop,
                IsNullTransFix, IsNullTransOff, IsNullAngleFix, IsSetDir, IsDispItem, Dir, Speed, IsCallVoice,
                IsUseFingerMotion, FingerHokan, FingerSpeed, FingerMotionNo);
    }

    private static FSMUnitParamSetAction readFSMUnitParamSetAction(BufferReader bufferReader) {
        long ActionType = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetAction(ActionType);
    }

    private static FSMBaseParamCallMessage readFSMBaseParamCallMessage(BufferReader bufferReader) {
        long MsgType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long MsgNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        float MsgDispTime = XfsDeserializer.readFloat(bufferReader);
        float MsgWaitTime = XfsDeserializer.readFloat(bufferReader);
        boolean IsUseSerial = XfsDeserializer.readBoolean(bufferReader);
        boolean IsHideMessage = XfsDeserializer.readBoolean(bufferReader);

        return new FSMBaseParamCallMessage(MsgType, QuestId, MsgNo, MsgDispTime, MsgWaitTime, IsUseSerial, IsHideMessage);
    }

    private static FSMOrderParamFlagQuest readFSMOrderParamFlagQuest(BufferReader bufferReader) {
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long FlagNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamFlagQuest(QuestId, FlagNo);
    }

    private static FSMUnitParamSetWait readFSMUnitParamSetWait(BufferReader bufferReader) {
        boolean IsSetDir = XfsDeserializer.readBoolean(bufferReader);
        Vector3f Dir = XfsDeserializer.readVector3f(bufferReader);
        float Speed = XfsDeserializer.readFloat(bufferReader);

        return new FSMUnitParamSetWait(IsSetDir, Dir, Speed);
    }

    private static FSMUnitParamSetHeadCtrl readFSMUnitParamSetHeadCtrl(BufferReader bufferReader) {
        short HeadCtrl = XfsDeserializer.readSignedShort(bufferReader);

        return new FSMUnitParamSetHeadCtrl(HeadCtrl);
    }

    private static FSMUnitParamSetGotoTarget readFSMUnitParamSetGotoTarget(BufferReader bufferReader) {
        int TargetType = XfsDeserializer.readUnsignedByte(bufferReader);
        int TargetId = XfsDeserializer.readSignedInteger(bufferReader);
        boolean IsSetBorder = XfsDeserializer.readBoolean(bufferReader);
        boolean IsPathFinding = XfsDeserializer.readBoolean(bufferReader);
        float StopBorder = XfsDeserializer.readFloat(bufferReader);
        int RunType = XfsDeserializer.readUnsignedByte(bufferReader);
        boolean IsUseWarp = XfsDeserializer.readBoolean(bufferReader);
        float WarpDist = XfsDeserializer.readFloat(bufferReader);
        boolean EnableNoFall = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetGotoTarget(TargetType, TargetId, IsSetBorder, IsPathFinding, StopBorder, RunType, IsUseWarp, WarpDist, EnableNoFall);
    }

    private static FSMUnitParamSetAttendNpc readFSMUnitParamSetAttendNpc(BufferReader bufferReader) {
        boolean IsAttend = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetAttendNpc(IsAttend);
    }

    private static FSMOrderParamQuestInfo readFSMOrderParamQuestInfo(BufferReader bufferReader) {
        long QuestType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamQuestInfo(QuestType, QuestId);
    }

    private static FSMUnitParamSetDispMiniMap readFSMUnitParamSetDispMiniMap(BufferReader bufferReader) {
        boolean IsDispMiniMap = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetDispMiniMap(IsDispMiniMap);
    }

    private static FSMUnitParamSetNeck readFSMUnitParamSetNeck(BufferReader bufferReader) {
        boolean IsSetNeck = XfsDeserializer.readBoolean(bufferReader);
        long TargetType = XfsDeserializer.readUnsignedInteger(bufferReader);
        Vector3f TargetPos = XfsDeserializer.readVector3f(bufferReader);
        long TargetGroup = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TargetSetId = XfsDeserializer.readUnsignedInteger(bufferReader);
        int TargetJointId = XfsDeserializer.readSignedInteger(bufferReader);
        boolean DisableSequence = XfsDeserializer.readBoolean(bufferReader);
        boolean IsAutoOffCtrl = XfsDeserializer.readBoolean(bufferReader);
        float SpeedRate = XfsDeserializer.readFloat(bufferReader);

        return new FSMUnitParamSetNeck(IsSetNeck, TargetType, TargetPos, TargetGroup, TargetSetId, TargetJointId, DisableSequence, IsAutoOffCtrl, SpeedRate);
    }

    private static FSMUnitParamSetWaypoint readFSMUnitParamSetWaypoint(BufferReader bufferReader) {
        long Type = XfsDeserializer.readUnsignedInteger(bufferReader);
        int GotoPointNo = XfsDeserializer.readSignedInteger(bufferReader);

        return new FSMUnitParamSetWaypoint(Type, GotoPointNo);
    }

    private static FSMBaseParamCallMessageFortDefCommon readFSMBaseParamCallMessageFortDefCommon(BufferReader bufferReader) {
        FSMBaseParamCallMessage callMessage = readFSMBaseParamCallMessage(bufferReader);
        long Type = XfsDeserializer.readUnsignedInteger(bufferReader);
        int GotoPointNo = XfsDeserializer.readSignedInteger(bufferReader);

        return new FSMBaseParamCallMessageFortDefCommon(callMessage, Type, GotoPointNo);
    }

    private static FSMUnitParamSetGotoInitPos readFSMUnitParamSetGotoInitPos(BufferReader bufferReader) {
        Vector3f TargetPos = XfsDeserializer.readVector3f(bufferReader);
        int RunType = XfsDeserializer.readUnsignedByte(bufferReader);
        float StopBorder = XfsDeserializer.readFloat(bufferReader);
        boolean IsSetDir = XfsDeserializer.readBoolean(bufferReader);
        boolean IsPathFinding = XfsDeserializer.readBoolean(bufferReader);
        Vector3f Dir = XfsDeserializer.readVector3f(bufferReader);
        float Speed = XfsDeserializer.readFloat(bufferReader);

        return new FSMUnitParamSetGotoInitPos(TargetPos, RunType, StopBorder, IsSetDir, IsPathFinding, Dir, Speed);
    }


    private static FSMBaseParamCallMessageFortDefBattleStart readFSMBaseParamCallMessageFortDefBattleStart(BufferReader bufferReader) {
        FSMBaseParamCallMessage callMessage = readFSMBaseParamCallMessage(bufferReader);
        long Type = XfsDeserializer.readUnsignedInteger(bufferReader);
        int GotoPointNo = XfsDeserializer.readSignedInteger(bufferReader);

        return new FSMBaseParamCallMessageFortDefBattleStart(callMessage, Type, GotoPointNo);
    }

    private static FSMUnitParamSetAttendComp readFSMUnitParamSetAttendComp(BufferReader bufferReader) {
        long Max = XfsDeserializer.readUnsignedInteger(bufferReader);
        float InitRate = XfsDeserializer.readFloat(bufferReader);
        long OverLv = XfsDeserializer.readUnsignedInteger(bufferReader);
        long UnderLv = XfsDeserializer.readUnsignedInteger(bufferReader);
        long PointHigh = XfsDeserializer.readUnsignedInteger(bufferReader);
        long PointMiddle = XfsDeserializer.readUnsignedInteger(bufferReader);
        long PointLow = XfsDeserializer.readUnsignedInteger(bufferReader);
        float DamageInterval = XfsDeserializer.readFloat(bufferReader);

        return new FSMUnitParamSetAttendComp(Max, InitRate, OverLv, UnderLv, PointHigh, PointMiddle, PointLow, DamageInterval);
    }

    private static FSMBaseParamCallNpcMessage readFSMBaseParamCallNpcMessage(BufferReader bufferReader) {
        long Type = XfsDeserializer.readUnsignedInteger(bufferReader);
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long MsgNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMBaseParamCallNpcMessage(Type, QuestId, MsgNo);
    }

    private static FSMOrderParamCallAnnounce readFSMOrderParamCallAnnounce(BufferReader bufferReader) {
        long Type = XfsDeserializer.readUnsignedInteger(bufferReader);
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long MsgNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamCallAnnounce(Type, QuestId, MsgNo);
    }

    private static FSMUnitParamSetFSMFreeFlagOn readFSMUnitParamSetFSMFreeFlagOn(BufferReader bufferReader) {
        long FlagNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetFSMFreeFlagOn(FlagNo);
    }

    private static FSMUnitParamSetFSMFreeFlagOff readFSMUnitParamSetFSMFreeFlagOff(BufferReader bufferReader) {
        long FlagNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetFSMFreeFlagOff(FlagNo);
    }

    private static FSMOrderParamFlagCommon readFSMOrderParamFlagCommon(BufferReader bufferReader) {
        int FlagNo = XfsDeserializer.readSignedInteger(bufferReader);

        return new FSMOrderParamFlagCommon(FlagNo);
    }

    private static FSMUnitParamAddAttendPoint readFSMUnitParamAddAttendPoint(BufferReader bufferReader) {
        int Point = XfsDeserializer.readSignedInteger(bufferReader);

        return new FSMUnitParamAddAttendPoint(Point);
    }

    private static FSMRandomChoice readFSMRandomChoice(BufferReader bufferReader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        boolean IsEnable = XfsDeserializer.readBoolean(bufferReader);
        long Index = XfsDeserializer.readUnsignedInteger(bufferReader);
        long Weight = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMRandomChoice(IsEnable, Index, Weight);
    }

    private static FSMBaseParamRandomChoice readFSMBaseParamRandomChoice(BufferReader bufferReader) {
        List<FSMRandomChoice> RandomChoiceList = XfsDeserializer.readMtArray(bufferReader, AIFSMDeserializer::readFSMRandomChoice);

        return new FSMBaseParamRandomChoice(RandomChoiceList);
    }

    private static FSMBaseParamSelectedChoiceTalk readFSMBaseParamSelectedChoiceTalk(BufferReader bufferReader) {
        long Index = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMBaseParamSelectedChoiceTalk(Index);
    }

    private static FSMOrderParamCheckAttendGauge readFSMOrderParamCheckAttendGauge(BufferReader bufferReader) {
        long Max = XfsDeserializer.readUnsignedInteger(bufferReader);
        long Min = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamCheckAttendGauge(Max, Min);
    }

    private static FSMOrderParamCheckLayoutFlag readFSMOrderParamCheckLayoutFlag(BufferReader bufferReader) {
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long LayoutFlagNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamCheckLayoutFlag(QuestId, LayoutFlagNo);
    }

    private static FSMUnitParamSetAdjustScrHit readFSMUnitParamSetAdjustScrHit(BufferReader bufferReader) {
        boolean IsStop = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetAdjustScrHit(IsStop);
    }

    private static FSMUnitParamSetEyeClose readFSMUnitParamSetEyeClose(BufferReader bufferReader) {
        boolean EyeClose = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetEyeClose(EyeClose);
    }

    private static FSMUnitParamSetEffect readFSMUnitParamSetEffect(BufferReader bufferReader) {

        long EfcId = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean HaveItem = XfsDeserializer.readBoolean(bufferReader);
        int Act = XfsDeserializer.readUnsignedShort(bufferReader);
        int Type = XfsDeserializer.readUnsignedShort(bufferReader);
        long OmId = XfsDeserializer.readUnsignedInteger(bufferReader);
        int Index = XfsDeserializer.readUnsignedShort(bufferReader);
        int Element = XfsDeserializer.readUnsignedShort(bufferReader);

        return new FSMUnitParamSetEffect(EfcId, HaveItem, Act, Type, OmId, Index, Element);
    }

    private static FSMOrderParamSetOpenDoor readFSMOrderParamSetOpenDoor(BufferReader bufferReader) {
        long GroupNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long SetNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsQuestSet = XfsDeserializer.readBoolean(bufferReader);
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamSetOpenDoor(GroupNo, SetNo, IsQuestSet, QuestId);
    }

    private static FSMOrderParamAreaHit readFSMOrderParamAreaHit(BufferReader bufferReader) {
        long Act = XfsDeserializer.readUnsignedInteger(bufferReader);
        long TaskType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long SceNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamAreaHit(Act, TaskType, SceNo);
    }

    private static FSMOrderParamCallEventNpcId readFSMOrderParamCallEventNpcId(BufferReader bufferReader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        long NpcId = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamCallEventNpcId(NpcId);
    }

    private static FSMOrderParamCallEvent readFSMOrderParamCallEvent(BufferReader bufferReader) {
        int StageNo = XfsDeserializer.readSignedInteger(bufferReader);
        int EventNo = XfsDeserializer.readSignedInteger(bufferReader);
        List<FSMOrderParamCallEventNpcId> NpcArray = XfsDeserializer.readMtArray(bufferReader, AIFSMDeserializer::readFSMOrderParamCallEventNpcId);

        return new FSMOrderParamCallEvent(StageNo, EventNo, NpcArray);
    }

    private static FSMOrderParamJumpPos readFSMOrderParamJumpPos(BufferReader bufferReader) {
        long JumpType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long JumpStagePosNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        Vector3f Pos = XfsDeserializer.readVector3f(bufferReader);
        float FadeOutTime = XfsDeserializer.readUnsignedInteger(bufferReader);
        float FadeInTime = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamJumpPos(JumpType, JumpStagePosNo, Pos, FadeOutTime, FadeInTime);
    }

    private static FSMOrderParamCamera readFSMOrderParamCamera(BufferReader bufferReader) {
        int ActType = XfsDeserializer.readUnsignedByte(bufferReader);
        int CamRes = XfsDeserializer.readUnsignedByte(bufferReader);
        int CamId1 = XfsDeserializer.readSignedInteger(bufferReader);
        int CamId2 = XfsDeserializer.readSignedInteger(bufferReader);
        int CameraEnemyActType = XfsDeserializer.readUnsignedByte(bufferReader);
        boolean CantActPl = XfsDeserializer.readBoolean(bufferReader);
        int CamId3 = XfsDeserializer.readSignedInteger(bufferReader);

        return new FSMOrderParamCamera(ActType, CamRes, CamId1, CamId2, CameraEnemyActType, CantActPl, CamId3);
    }

    private static FSMOrderParamBGMRequest readFSMOrderParamBGMRequest(BufferReader bufferReader) {
        long BgmRequestEditType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long BgmRequestType = XfsDeserializer.readUnsignedInteger(bufferReader);
        long BgmRequestNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamBGMRequest(BgmRequestEditType, BgmRequestType, BgmRequestNo);
    }

    private static FSMOrderParamSetLocationName readFSMOrderParamSetLocationName(BufferReader bufferReader) {
        long StageNo = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamSetLocationName(StageNo);
    }

    private static FSMOrderParamSetCallSe readFSMOrderParamSetCallSe(BufferReader bufferReader) {
        long SeId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long Target = XfsDeserializer.readUnsignedInteger(bufferReader);
        int Group = XfsDeserializer.readSignedInteger(bufferReader);
        int Id = XfsDeserializer.readSignedInteger(bufferReader);
        int JointNo = XfsDeserializer.readSignedInteger(bufferReader);
        long DelayFrame = XfsDeserializer.readUnsignedInteger(bufferReader);
        Vector3f Pos = XfsDeserializer.readVector3f(bufferReader);

        return new FSMOrderParamSetCallSe(SeId, Target, Group, Id, JointNo, DelayFrame, Pos);
    }

    private static FSMUnitParamSetDispWeapon readFSMUnitParamSetDispWeapon(BufferReader bufferReader) {
        boolean IsDispWepMain = XfsDeserializer.readBoolean(bufferReader);
        boolean IsDispWepSub = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetDispWeapon(IsDispWepMain, IsDispWepSub);
    }

    private static FSMUnitParamSetEyeBall readFSMUnitParamSetEyeBall(BufferReader bufferReader) {
        Vector3f TargetAngle = XfsDeserializer.readVector3f(bufferReader);
        long HokanFrame = XfsDeserializer.readUnsignedInteger(bufferReader);
        long DelayFrame = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetEyeBall(TargetAngle, HokanFrame, DelayFrame);
    }

    private static FSMUnitParamSetMotionGoto readFSMUnitParamSetMotionGoto(BufferReader bufferReader) {
        FSMUnitParamSetMotion fsmUnitParamSetMotion = readFSMUnitParamSetMotion(bufferReader);

//        boolean IsDisableFall = XfsDeserializer.readBoolean(bufferReader);
//        int MotionSeOffBank = XfsDeserializer.readSignedInteger(bufferReader);
        Vector3f TargetPos = XfsDeserializer.readVector3f(bufferReader);
        float StopBorder = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsSetVelocity = XfsDeserializer.readBoolean(bufferReader);
        float VelocityScalar = XfsDeserializer.readFloat(bufferReader);
        float AccelerationScalar = XfsDeserializer.readFloat(bufferReader);
        boolean IsHover = XfsDeserializer.readBoolean(bufferReader);
        boolean IsPosHokan = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetMotionGoto(fsmUnitParamSetMotion, /*IsDisableFall, MotionSeOffBank,*/ TargetPos, StopBorder, IsSetVelocity, VelocityScalar, AccelerationScalar, IsHover, IsPosHokan);
    }

    private static FSMOrderParamSetDispUnit readFSMOrderParamSetDispUnit(BufferReader bufferReader) {
        long Act = XfsDeserializer.readUnsignedInteger(bufferReader);
        long Target = XfsDeserializer.readUnsignedInteger(bufferReader);
        long GroupNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        long SetId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long QuestId = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean IsStopMove = XfsDeserializer.readBoolean(bufferReader);

        return new FSMOrderParamSetDispUnit(Act, Target, GroupNo, SetId, QuestId, IsStopMove);
    }

    private static FSMOrderParamSetFade readFSMOrderParamSetFade(BufferReader bufferReader) {
        long FadeType = XfsDeserializer.readUnsignedInteger(bufferReader);
        float FadeTime = XfsDeserializer.readFloat(bufferReader);

        return new FSMOrderParamSetFade(FadeType, FadeTime);
    }

    private static FSMOrderParamSetLayout readFSMOrderParamSetLayout(BufferReader bufferReader) {
        int ActType = XfsDeserializer.readUnsignedShort(bufferReader);
        int StageNo = XfsDeserializer.readUnsignedShort(bufferReader);
        int FlagNo = XfsDeserializer.readUnsignedShort(bufferReader);

        return new FSMOrderParamSetLayout(ActType, StageNo, FlagNo);
    }

    private static FSMOrderParamBGMStop readFSMOrderParamBGMStop(BufferReader bufferReader) {
        return new FSMOrderParamBGMStop();
    }

    private static FSMRelate readFSMRelate(BufferReader bufferReader) {
        String FSMName = XfsDeserializer.readNullTerminatedString(bufferReader);
        int FSMType = XfsDeserializer.readUnsignedByte(bufferReader);

        return new FSMRelate(FSMName, FSMType);
    }

    private static FSMOrderParamSetEnemySetEmInfo readFSMOrderParamSetEnemySetEmInfo(BufferReader bufferReader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        long EnemyId = XfsDeserializer.readUnsignedInteger(bufferReader);
        Matrix Mat = XfsDeserializer.readMatrix(bufferReader);
        FSMRelate FsmPath = readFSMRelate(bufferReader);
        long GroupId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long SetId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long ErosionLv = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamSetEnemySetEmInfo(EnemyId, Mat, FsmPath, GroupId, SetId, ErosionLv);
    }

    private static FSMOrderParamSetEnemy readFSMOrderParamSetEnemy(BufferReader bufferReader) {
        List<FSMOrderParamSetEnemySetEmInfo> SetEnemyInfo = XfsDeserializer.readMtArray(bufferReader, AIFSMDeserializer::readFSMOrderParamSetEnemySetEmInfo);
        long GroupId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long LayoutId = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMOrderParamSetEnemy(SetEnemyInfo, GroupId, LayoutId);
    }

    private static FSMUnitParamSetEmDie readFSMUnitParamSetEmDie(BufferReader bufferReader) {
        long Act = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetEmDie(Act);
    }

    private static FSMUnitParamSetHaveThing readFSMUnitParamSetHaveThing(BufferReader bufferReader) {
        long HaveThing = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetHaveThing(HaveThing);
    }

    private static FSMOrderParamSetEffect readFSMOrderParamSetEffect(BufferReader bufferReader) {
        int EfcId = XfsDeserializer.readUnsignedShort(bufferReader);
        int Target = XfsDeserializer.readUnsignedShort(bufferReader);
        int Group = XfsDeserializer.readSignedInteger(bufferReader);
        int Id = XfsDeserializer.readSignedInteger(bufferReader);
        boolean HaveItem = XfsDeserializer.readBoolean(bufferReader);
        int Act = XfsDeserializer.readUnsignedShort(bufferReader);
        int Type = XfsDeserializer.readUnsignedShort(bufferReader);
        long OmId = XfsDeserializer.readSignedInteger(bufferReader);
        int Index = XfsDeserializer.readUnsignedShort(bufferReader);
        int Element = XfsDeserializer.readUnsignedShort(bufferReader);
        Vector3f Pos = XfsDeserializer.readVector3f(bufferReader);
        Vector3f Ang = XfsDeserializer.readVector3f(bufferReader);
        Vector3f Scl = XfsDeserializer.readVector3f(bufferReader);

        return new FSMOrderParamSetEffect(EfcId, Target, Group, Id, HaveItem, Act, Type, OmId, Index, Element, Pos, Ang, Scl);
    }

    private static FSMOrderParamSetVib readFSMOrderParamSetVib(BufferReader bufferReader) {
        long Vib = XfsDeserializer.readUnsignedInteger(bufferReader);
        long Num = XfsDeserializer.readUnsignedInteger(bufferReader);
        float WaitSec = XfsDeserializer.readFloat(bufferReader);

        return new FSMOrderParamSetVib(Vib, Num, WaitSec);
    }

    private static FSMUnitParamSetParts readFSMUnitParamSetParts(BufferReader bufferReader) {
        long Type = XfsDeserializer.readUnsignedInteger(bufferReader);
        long Parts = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetParts(Type, Parts);
    }

    private static FSMUnitParamSetVibUnit readFSMUnitParamSetVibUnit(BufferReader bufferReader) {
        long Vib = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetVibUnit(Vib);
    }

    private static FSMUnitParamSetCallSe readFSMUnitParamSetCallSe(BufferReader bufferReader) {
        long SeId = XfsDeserializer.readUnsignedInteger(bufferReader);
        int JointNo = XfsDeserializer.readSignedInteger(bufferReader);
        long DelayFrame = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetCallSe(SeId, JointNo, DelayFrame);
    }

    private static FSMUnitParamSetEmMontage readFSMUnitParamSetEmMontage(BufferReader bufferReader) {
        long Type = XfsDeserializer.readUnsignedInteger(bufferReader);
        long Montage = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean DisableMotSeq = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetEmMontage(Type, Montage, DisableMotSeq);
    }

    private static FSMUnitParamSetHakuryuStoneLevel readFSMUnitParamSetHakuryuStoneLevel(BufferReader bufferReader) {
        long StoneLevel = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new FSMUnitParamSetHakuryuStoneLevel(StoneLevel);
    }

    private static FSMUnitParamSetIK readFSMUnitParamSetIK(BufferReader bufferReader) {
        boolean Active = XfsDeserializer.readBoolean(bufferReader);

        return new FSMUnitParamSetIK(Active);
    }

    private static FSMUnitParamSetEnemyHP readFSMUnitParamSetEnemyHP(BufferReader bufferReader) {
        float HPParcentage = XfsDeserializer.readFloat(bufferReader);

        return new FSMUnitParamSetEnemyHP(HPParcentage);
    }

    private static AICopiableParameter readAICopiableParameter(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader, String containerName) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        return switch (containerName) {
            // Season 2 event exclusive
            case "SetDispWeapon" -> readFSMUnitParamSetDispWeapon(bufferReader);
            case "SetEyeBall" -> readFSMUnitParamSetEyeBall(bufferReader);
            case "SetMotionGoto" -> readFSMUnitParamSetMotionGoto(bufferReader);
            case "SetLayout" -> readFSMOrderParamSetLayout(bufferReader);
            case "SetFade" -> readFSMOrderParamSetFade(bufferReader);
            case "SetDispUnit" -> readFSMOrderParamSetDispUnit(bufferReader);
            case "EventFlagOn" -> readFSMOrderParamFlagCommon(bufferReader);
            case "SetEnemy" -> readFSMOrderParamSetEnemy(bufferReader);
            case "SetEmDie" -> readFSMUnitParamSetEmDie(bufferReader);
            case "SetHaveThing" -> readFSMUnitParamSetHaveThing(bufferReader);
            case "SetEffectVersatile" -> readFSMOrderParamSetEffect(bufferReader);
            case "SetVib" -> readFSMOrderParamSetVib(bufferReader);
            case "SetParts" -> readFSMUnitParamSetParts(bufferReader);
            case "SetVibUnit" -> readFSMUnitParamSetVibUnit(bufferReader);
            case "SetCallSeUnit" -> readFSMUnitParamSetCallSe(bufferReader);
            case "SetEmMontage" -> readFSMUnitParamSetEmMontage(bufferReader);
            case "SetHakuryuStoneLevel" -> readFSMUnitParamSetHakuryuStoneLevel(bufferReader);
            case "SetIK" -> readFSMUnitParamSetIK(bufferReader);
            case "SetEnemyHP" -> readFSMUnitParamSetEnemyHP(bufferReader);
            case "StartEvt", "EndEvt" -> null;

            // Season 2 stage exclusive
            case "SetAreaHit" -> readFSMOrderParamAreaHit(bufferReader);
            case "CallFsmEvent" -> readFSMOrderParamCallEvent(bufferReader);
            case "JumpPos" -> readFSMOrderParamJumpPos(bufferReader);
            case "Camera", "Camera_camev" -> readFSMOrderParamCamera(bufferReader);
            case "SetLocaName" -> readFSMOrderParamSetLocationName(bufferReader);
            case "StageBGMRequest", "BGMRequest", "BGMRequest_camev" -> readFSMOrderParamBGMRequest(bufferReader);
            case "BGMStop", "BGMStop_camev" -> readFSMOrderParamBGMStop(bufferReader);

            case "SetCallStreamSe", "SetCallSe" -> readFSMOrderParamSetCallSe(bufferReader);

            // Season 2 quest
            case "MainQstFlagOn" -> readFSMOrderParamFlagQuest(bufferReader);
            case "checkMyQuestFlag" -> readFSMOrderParamIsMyQuestFlag(bufferReader);
            case "SetQuestInfo" -> readFSMOrderParamQuestInfo(bufferReader);

            case "SetDisableTouchAction" -> readFSMUnitParamSetDisableTouchAction(bufferReader);
            case "SetChangeThink" -> readFSMUnitParamSetChangeThink(bufferReader);
            case "SetGoto" -> readFSMUnitParamSetGoto(bufferReader);
            case "SetGotoTarget" -> readFSMUnitParamSetGotoTarget(bufferReader);
            case "SetMotion" -> {
                // TODO: Avoid hack and instead find a more generic way? If there are other classes with such issues..
                //  for season 2 this is the only class with this issue
                if (xfsHeader.getClassHeaderIndex().get(xfsObjectData.getClassIndex()).getPropNum() == 22) {
                    yield readFSMUnitParamSetMotion(bufferReader);
                } else {
                    yield readFSMUnitParamSetMotionV2(bufferReader);
                }
            }
            case "SetAction" -> readFSMUnitParamSetAction(bufferReader);
            case "SetWait" -> readFSMUnitParamSetWait(bufferReader);
            case "SetHeadCtrl" -> readFSMUnitParamSetHeadCtrl(bufferReader);
            case "SetAttend" -> readFSMUnitParamSetAttendNpc(bufferReader);
            case "SetDispMiniMap" -> readFSMUnitParamSetDispMiniMap(bufferReader);
            case "SetNeck" -> readFSMUnitParamSetNeck(bufferReader);
            case "SetWaypoint(Quest)" -> readFSMUnitParamSetWaypoint(bufferReader);

            case "CallMessage" -> readFSMBaseParamCallMessage(bufferReader);
            case "CallMessageFortDef_Common" -> readFSMBaseParamCallMessageFortDefCommon(bufferReader);
            case "CallMessageFortDef_BattleStart" -> readFSMBaseParamCallMessageFortDefBattleStart(bufferReader);

            // Used in quest folder since season 3 but already present in season 2
            case "callAnnounce" -> readFSMOrderParamCallAnnounce(bufferReader);
            case "SetEffect" -> readFSMUnitParamSetEffect(bufferReader);
            case "SetOpenDoor" -> readFSMOrderParamSetOpenDoor(bufferReader);

            case "SetAdjScr" -> readFSMUnitParamSetAdjustScrHit(bufferReader);
            case "setFSMFreeFlagOn" -> readFSMUnitParamSetFSMFreeFlagOn(bufferReader);
            case "setFSMFreeFlagOff" -> readFSMUnitParamSetFSMFreeFlagOff(bufferReader);
            case "SetEyeClose" -> readFSMUnitParamSetEyeClose(bufferReader);

            case "CallNpcMessage" -> readFSMBaseParamCallNpcMessage(bufferReader);

            // Season 3 exclusive
            case "CheckAttendGauge" -> readFSMOrderParamCheckAttendGauge(bufferReader);
            case "checkLayoutFlag" -> readFSMOrderParamCheckLayoutFlag(bufferReader);

            case "SetGotoInitPos" -> readFSMUnitParamSetGotoInitPos(bufferReader);
            case "SetAttendComp" -> readFSMUnitParamSetAttendComp(bufferReader);
            case "AddAttendPoint" -> readFSMUnitParamAddAttendPoint(bufferReader);

            case "RandomChoice" -> readFSMBaseParamRandomChoice(bufferReader);
            case "SelectedChoiceTalk" -> readFSMBaseParamSelectedChoiceTalk(bufferReader);

            case "Finish" -> null;
            default -> throw new TechnicalException("Unexpected value: " + containerName);
        };
    }

    private static AIFSMNodeProcess readAIFSMNodeProcess(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        String ContainerName = XfsDeserializer.readNullTerminatedString(bufferReader);
        String CategoryName = XfsDeserializer.readNullTerminatedString(bufferReader);
        AICopiableParameter Parameter = XfsDeserializer.readXfsProperty(bufferReader, br -> readAICopiableParameter(bufferReader, lookupUtil, xfsHeader, ContainerName));

        return new AIFSMNodeProcess(ContainerName, CategoryName, Parameter);
    }

    private static AIFSMLink readAIFSMLink(BufferReader bufferReader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        String Name = XfsDeserializer.readJapaneseNullTerminatedString(bufferReader);
        long DestinationNodeId = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean ExistCondition = XfsDeserializer.readBoolean(bufferReader);
        long ConditionId = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new AIFSMLink(Name, DestinationNodeId, ExistCondition, ConditionId);
    }

    private static AIFSMNodeUIPos readAIFSMNodeUIPos(BufferReader bufferReader) {
        int UIPosX = bufferReader.readUnsignedShort();
        int UIPosY = bufferReader.readUnsignedShort();

        return new AIFSMNodeUIPos(UIPosX, UIPosY);
    }

    private static AIFSMNode readAIFSMNode(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        String Name = XfsDeserializer.readJapaneseNullTerminatedString(bufferReader);
        long Id = XfsDeserializer.readUnsignedInteger(bufferReader);
        long UniqueId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long OwnerId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long SubClusterId = XfsDeserializer.readUnsignedInteger(bufferReader);
        AIFSMCluster SubCluster = null;
        if (SubClusterId != 65534) {
            bufferReader.setPosition(bufferReader.getPosition() - 4);
            SubCluster = readAIFSMCluster(bufferReader, lookupUtil, xfsHeader);
        }
        long LinkListNum = bufferReader.readUnsignedInteger();
        List<AIFSMLink> LinkList = bufferReader.readFixedLengthArray(LinkListNum, AIFSMDeserializer::readAIFSMLink);
        long ProcessListNum = bufferReader.readUnsignedInteger();
        List<AIFSMNodeProcess> ProcessList = bufferReader.readFixedLengthArray(ProcessListNum, br -> readAIFSMNodeProcess(br, lookupUtil, xfsHeader));
        AIFSMNodeUIPos UIPos = XfsDeserializer.readXfsProperty(bufferReader, AIFSMDeserializer::readAIFSMNodeUIPos);
        int ColorType = XfsDeserializer.readUnsignedByte(bufferReader);
        long Setting = XfsDeserializer.readUnsignedInteger(bufferReader);
        long UserAttribute = XfsDeserializer.readUnsignedInteger(bufferReader);
        boolean ExistConditionTrainsitionFromAll = XfsDeserializer.readBoolean(bufferReader);
        long ConditionTrainsitionFromAllId = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new AIFSMNode(Name, Id, UniqueId, OwnerId, SubCluster, LinkListNum, LinkList, ProcessListNum, ProcessList, UIPos, ColorType, Setting, UserAttribute, ExistConditionTrainsitionFromAll, ConditionTrainsitionFromAllId);
    }

    private static AIFSMCluster readAIFSMCluster(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        long Id = XfsDeserializer.readUnsignedInteger(bufferReader);
        long OwnerNodeUniqueId = XfsDeserializer.readUnsignedInteger(bufferReader);
        long InitialStateId = XfsDeserializer.readUnsignedInteger(bufferReader);
        List<AIFSMNode> NodeList = bufferReader.readArray(br -> readAIFSMNode(br, lookupUtil, xfsHeader));

        return new AIFSMCluster(Id, OwnerNodeUniqueId, InitialStateId, NodeList);
    }

    private static AIDEnum readAIDEnum(BufferReader bufferReader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        long Id = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new AIDEnum(Id);
    }

    private static AIEnumProp readAIEnumProp(BufferReader bufferReader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        String Name = XfsDeserializer.readNullTerminatedString(bufferReader);
        String EnumName = XfsDeserializer.readNullTerminatedString(bufferReader);

        return new AIEnumProp(Name, EnumName);
    }

    private static AIConditionTreeOperationNode readAIConditionTreeOperationNode(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        long ChildListNum = bufferReader.readUnsignedInteger();
        List<AIConditionTreeNode> ChildList = bufferReader.readFixedLengthArray(ChildListNum, br -> readAIConditionTreeNode(br, lookupUtil, xfsHeader));

        long Operator = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new AIConditionTreeOperationNode(ChildList, Operator);
    }

    private static AIConditionTreeVariableNodeVariableInfo readAIConditionTreeVariableNodeVariableInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        String PropertyName = XfsDeserializer.readNullTerminatedString(bufferReader);
        String OwnerName = XfsDeserializer.readNullTerminatedString(bufferReader);
        boolean IsSingletonOwner = XfsDeserializer.readBoolean(bufferReader);

        return new AIConditionTreeVariableNodeVariableInfo(PropertyName, OwnerName, IsSingletonOwner);
    }

    private static AIConditionTreeVariableNode readAIConditionTreeVariableNode(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        long ChildListNum = bufferReader.readUnsignedInteger();
        List<AIConditionTreeNode> ChildList = bufferReader.readFixedLengthArray(ChildListNum, br -> readAIConditionTreeNode(br, lookupUtil, xfsHeader));

        AIConditionTreeVariableNodeVariableInfo Variable = XfsDeserializer.readXfsProperty(bufferReader, br -> readAIConditionTreeVariableNodeVariableInfo(bufferReader, lookupUtil, xfsHeader));
        boolean IsBitNo = XfsDeserializer.readBoolean(bufferReader);
        boolean IsArray = XfsDeserializer.readBoolean(bufferReader);
        boolean IsDynamicIndex = XfsDeserializer.readBoolean(bufferReader);
        long Index = XfsDeserializer.readUnsignedInteger(bufferReader);
        AIConditionTreeVariableNodeVariableInfo IndexVariable = XfsDeserializer.readXfsProperty(bufferReader, br -> readAIConditionTreeVariableNodeVariableInfo(bufferReader, lookupUtil, xfsHeader));
        boolean UseEnumIndex = XfsDeserializer.readBoolean(bufferReader);
        AIEnumProp IndexEnum = XfsDeserializer.readXfsProperty(bufferReader, br -> readAIEnumProp(bufferReader));

        return new AIConditionTreeVariableNode(ChildList, Variable, IsBitNo, IsArray, IsDynamicIndex, Index, IndexVariable, UseEnumIndex, IndexEnum);
    }

    private static AIConditionTreeConstF32Node readAIConditionTreeConstF32Node(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        long ChildListNum = bufferReader.readUnsignedInteger();
        List<AIConditionTreeNode> ChildList = bufferReader.readFixedLengthArray(ChildListNum, br -> readAIConditionTreeNode(br, lookupUtil, xfsHeader));

        float Value = XfsDeserializer.readFloat(bufferReader);

        return new AIConditionTreeConstF32Node(ChildList, Value);
    }

    private static AIConditionTreeNode readAIConditionTreeNode(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);
        if (xfsObjectData.getClassIndex() == 65534) {
            bufferReader.setPosition(bufferReader.getPosition() - 4);
            return null;
        }
        return switch (xfsHeader.getClassHeaderIndex().get(xfsObjectData.getClassIndex()).getResourceName()) {
            case "rAIConditionTree::OperationNode" ->
                    readAIConditionTreeOperationNode(bufferReader, lookupUtil, xfsHeader);
            case "rAIConditionTree::VariableNode" ->
                    readAIConditionTreeVariableNode(bufferReader, lookupUtil, xfsHeader);
            case "rAIConditionTree::ConstF32Node" ->
                    readAIConditionTreeConstF32Node(bufferReader, lookupUtil, xfsHeader);
            default ->
                    throw new IllegalStateException("Unexpected value: " + xfsHeader.getClassHeaderIndex().get(xfsObjectData.getClassIndex()).getResourceName());
        };
    }

    private static AIConditionTreeTreeInfo readAIConditionTreeTreeInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        AIDEnum Name = XfsDeserializer.readXfsProperty(bufferReader, br -> readAIDEnum(bufferReader));
        AIConditionTreeNode RootNode = XfsDeserializer.readXfsProperty(bufferReader, br -> readAIConditionTreeNode(bufferReader, lookupUtil, xfsHeader));

        return new AIConditionTreeTreeInfo(Name, RootNode);
    }

    private static AIConditionTree readAIConditionTree(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        List<AIConditionTreeTreeInfo> TreeList = bufferReader.readArray(br -> readAIConditionTreeTreeInfo(br, lookupUtil, xfsHeader));

        return new AIConditionTree(TreeList);
    }

    @Override
    protected AIFSM parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        // Account for hacky workaround to make a unique resourceVersion by reading in both the deserializer and class resourceVersion initially
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        XfsHeader xfsHeader = XfsDeserializer.readHeader(bufferReader);

        XfsDeserializer.readResource(bufferReader);
        String OwnerObjectName = XfsDeserializer.readJapaneseNullTerminatedString(bufferReader);
        AIFSMCluster RootCluster = XfsDeserializer.readXfsProperty(bufferReader, br -> readAIFSMCluster(br, lookupUtil, xfsHeader));

        XfsBody xfsBody = XfsDeserializer.readXfsProperty(bufferReader, br -> XfsDeserializer.readResource(bufferReader));
        AIConditionTree ConditionTree = null;
        if (xfsBody.getObjectData().getClassIndex() == 65534) {
            bufferReader.setPosition(bufferReader.getPosition() - 12);
        } else {
            ConditionTree = readAIConditionTree(bufferReader, lookupUtil, xfsHeader);
        }

        long FSMAttribute = XfsDeserializer.readUnsignedInteger(bufferReader);
        long LastEditType = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new AIFSM(
                OwnerObjectName,
                RootCluster,
                ConditionTree,
                FSMAttribute,
                LastEditType
        );
    }
}
