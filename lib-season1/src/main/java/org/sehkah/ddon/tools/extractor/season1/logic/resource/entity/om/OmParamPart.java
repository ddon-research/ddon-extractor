package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.om;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.OmBlinkType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.OmLotSetType;

import java.math.BigInteger;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonPropertyOrder(alphabetic = true)
public final class OmParamPart extends TopLevelClientResource {
    private final int OmID;
    private final BigInteger ResPathModel;
    private final BigInteger ResPathObjCollision;
    private final BigInteger ResPathMotionList;
    private final BigInteger ResPathSoundMotionSe;
    private final long UnitDTIID;
    private final long UseComponent;
    private final long Unknown1;
    private final long OmSetType;
    @MetaInformation
    private final OmLotSetType OmSetTypeName;
    private final BigInteger ResPathEffectProvider;
    private final BigInteger ResPathSoundRequest;
    private final long ReqSeFlag;
    private final int FxIndex0;
    private final int SeIndex0;
    private final int FxIndex1;
    private final int SeIndex1;
    private final int FxIndex2;
    private final int SeIndex2;
    private final int FxIndex3;
    private final int SeIndex3;
    private final BigInteger ResPathSwingModel;
    private final BigInteger ResPathSoftBody;
    private final BigInteger ResPathRigidBody;
    private final BigInteger ResPathBrRigidBody;
    private final BigInteger ResPathBrModel;
    private final BigInteger ResPathBrSoftBody;
    private final BigInteger ResPathCaught;
    private final BigInteger ResPathZone;
    private final BigInteger ResPathOmZone;
    private final BigInteger ResPathJointInfo;
    private final BigInteger ResPathUnknown2;
    private final boolean Unknown3;
    private final long DetailBehavior; // TODO: This is a flag; find enum
    private final long MapIcon;
    private final float KillLength;
    private final boolean Unknown4;
    private final long Unknown5;
    private final boolean UseNightColor;
    private final Vector3f NightColor;
    private final float RigidTime;
    private final float RigidForce;
    private final float RigidOfsY;
    private final float RigidVelocity;
    private final float ThrowVelocity;
    private final float ThrowVectorY;
    private final float RigidWorldOfsY;
    private final Vector3f TargetOfs;
    private final boolean Nav;
    private final Vector3f NavOBBPos;
    private final Vector3f NavOBBExtent;
    private final boolean Atk;
    private final long ShotGroup;
    private final int WepType;
    private final long ArcTagID;
    private final int TargetJntNo;
    private final int JointNum;
    private final Vector3f KeyOfs;
    private final long ColliOffFrame;
    private final long BlinkType;
    @MetaInformation
    private final OmBlinkType BlinkTypeName;
    private final List<BigInteger> ResPathCollision; //[4]
    private final boolean Unknown6;
    private final long Version;
    private final long Unknown7;
    private final long Unknown8;
    private final long Unknown9;
    private final long Unknown10;
    private final long Unknown11;
    private final long Unknown12;
    private final long Unknown13;
    private final long Unknown14;

    public OmParamPart(int omID, BigInteger resPathModel, BigInteger resPathObjCollision, BigInteger resPathMotionList, BigInteger resPathSoundMotionSe, long unitDTIID, long useComponent, long unknown1, long omSetType, BigInteger resPathEffectProvider, BigInteger resPathSoundRequest, long reqSeFlag, int fxIndex0, int seIndex0, int fxIndex1, int seIndex1, int fxIndex2, int seIndex2, int fxIndex3, int seIndex3, BigInteger resPathSwingModel, BigInteger resPathSoftBody, BigInteger resPathRigidBody, BigInteger resPathBrRigidBody, BigInteger resPathBrModel, BigInteger resPathBrSoftBody, BigInteger resPathCaught, BigInteger resPathZone, BigInteger resPathOmZone, BigInteger resPathJointInfo, BigInteger resPathUnknown2, boolean unknown3, long detailBehavior, long mapIcon, float killLength, boolean unknown4, long unknown5, boolean useNightColor, Vector3f nightColor, float rigidTime, float rigidForce, float rigidOfsY, float rigidVelocity, float throwVelocity, float throwVectorY, float rigidWorldOfsY, Vector3f targetOfs, boolean nav, Vector3f navOBBPos, Vector3f navOBBExtent, boolean atk, long shotGroup, int wepType, long arcTagID, int targetJntNo, int jointNum, Vector3f keyOfs, long colliOffFrame, long blinkType, List<BigInteger> resPathCollision, boolean unknown6, long version, long unknown7, long unknown8, long unknown9, long unknown10, long unknown11, long unknown12, long unknown13, long unknown14) {
        OmID = omID;
        ResPathModel = resPathModel;
        ResPathObjCollision = resPathObjCollision;
        ResPathMotionList = resPathMotionList;
        ResPathSoundMotionSe = resPathSoundMotionSe;
        UnitDTIID = unitDTIID;
        UseComponent = useComponent;
        Unknown1 = unknown1;
        OmSetType = omSetType;
        OmSetTypeName = OmLotSetType.of(omSetType);
        ResPathEffectProvider = resPathEffectProvider;
        ResPathSoundRequest = resPathSoundRequest;
        ReqSeFlag = reqSeFlag;
        FxIndex0 = fxIndex0;
        SeIndex0 = seIndex0;
        FxIndex1 = fxIndex1;
        SeIndex1 = seIndex1;
        FxIndex2 = fxIndex2;
        SeIndex2 = seIndex2;
        FxIndex3 = fxIndex3;
        SeIndex3 = seIndex3;
        ResPathSwingModel = resPathSwingModel;
        ResPathSoftBody = resPathSoftBody;
        ResPathRigidBody = resPathRigidBody;
        ResPathBrRigidBody = resPathBrRigidBody;
        ResPathBrModel = resPathBrModel;
        ResPathBrSoftBody = resPathBrSoftBody;
        ResPathCaught = resPathCaught;
        ResPathZone = resPathZone;
        ResPathOmZone = resPathOmZone;
        ResPathJointInfo = resPathJointInfo;
        ResPathUnknown2 = resPathUnknown2;
        Unknown3 = unknown3;
        DetailBehavior = detailBehavior;
        MapIcon = mapIcon;
        KillLength = killLength;
        Unknown4 = unknown4;
        Unknown5 = unknown5;
        UseNightColor = useNightColor;
        NightColor = nightColor;
        RigidTime = rigidTime;
        RigidForce = rigidForce;
        RigidOfsY = rigidOfsY;
        RigidVelocity = rigidVelocity;
        ThrowVelocity = throwVelocity;
        ThrowVectorY = throwVectorY;
        RigidWorldOfsY = rigidWorldOfsY;
        TargetOfs = targetOfs;
        Nav = nav;
        NavOBBPos = navOBBPos;
        NavOBBExtent = navOBBExtent;
        Atk = atk;
        ShotGroup = shotGroup;
        WepType = wepType;
        ArcTagID = arcTagID;
        TargetJntNo = targetJntNo;
        JointNum = jointNum;
        KeyOfs = keyOfs;
        ColliOffFrame = colliOffFrame;
        BlinkType = blinkType;
        BlinkTypeName = OmBlinkType.of(BlinkType);
        ResPathCollision = resPathCollision;
        Unknown6 = unknown6;
        Version = version;
        Unknown7 = unknown7;
        Unknown8 = unknown8;
        Unknown9 = unknown9;
        Unknown10 = unknown10;
        Unknown11 = unknown11;
        Unknown12 = unknown12;
        Unknown13 = unknown13;
        Unknown14 = unknown14;
    }
}
