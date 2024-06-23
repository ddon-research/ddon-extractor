package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.om;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.OmBlinkType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.OmLotSetType;

import java.math.BigInteger;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class OmParamPart extends Resource {
    private int OmID;
    private BigInteger ResPathModel;
    private BigInteger ResPathObjCollision;
    private BigInteger ResPathMotionList;
    private BigInteger ResPathSoundMotionSe;
    private long UnitDTIID;
    private long UseComponent;
    private long Unknown1;
    private long OmSetType;
    @MetaInformation
    private OmLotSetType OmSetTypeName;
    private BigInteger ResPathEffectProvider;
    private BigInteger ResPathSoundRequest;
    private long ReqSeFlag;
    private int FxIndex0;
    private int SeIndex0;
    private int FxIndex1;
    private int SeIndex1;
    private int FxIndex2;
    private int SeIndex2;
    private int FxIndex3;
    private int SeIndex3;
    private BigInteger ResPathSwingModel;
    private BigInteger ResPathSoftBody;
    private BigInteger ResPathRigidBody;
    private BigInteger ResPathBrRigidBody;
    private BigInteger ResPathBrModel;
    private BigInteger ResPathBrSoftBody;
    private BigInteger ResPathCaught;
    private BigInteger ResPathZone;
    private BigInteger ResPathOmZone;
    private BigInteger ResPathJointInfo;
    private BigInteger ResPathUnknown2;
    private boolean Unknown3;
    private long DetailBehavior; // TODO: This is a flag; find enum
    private long MapIcon;
    private float KillLength;
    private boolean Unknown4;
    private long Unknown5;
    private boolean UseNightColor;
    private Vector3f NightColor;
    private float RigidTime;
    private float RigidForce;
    private float RigidOfsY;
    private float RigidVelocity;
    private float ThrowVelocity;
    private float ThrowVectorY;
    private float RigidWorldOfsY;
    private Vector3f TargetOfs;
    private boolean Nav;
    private Vector3f NavOBBPos;
    private Vector3f NavOBBExtent;
    private boolean Atk;
    private long ShotGroup;
    private int WepType;
    private long ArcTagID;
    private int TargetJntNo;
    private int JointNum;
    private Vector3f KeyOfs;
    private long ColliOffFrame;
    private long BlinkType;
    @MetaInformation
    private OmBlinkType BlinkTypeName;
    private List<BigInteger> ResPathCollision; //[4]
    private boolean Unknown6;
    private long Version;
    private long Unknown7;
    private long Unknown8;
    private long Unknown9;
    private long Unknown10;
    private long Unknown11;
    private long Unknown12;
    private long Unknown13;
    private long Unknown14;

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
