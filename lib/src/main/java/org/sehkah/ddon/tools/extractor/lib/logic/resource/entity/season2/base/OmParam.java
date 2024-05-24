package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.meta.OmBlinkType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.meta.OmLotSetType;

import java.math.BigInteger;
import java.util.List;

public record OmParam(
        int OmID,
        BigInteger ResPathModel,
        BigInteger ResPathObjCollision,
        BigInteger ResPathMotionList,
        BigInteger ResPathSoundMotionSe,
        long UnitDTIID,
        long UseComponent,
        long OmSetType,
        @MetaInformation
        OmLotSetType OmSetTypeName,
        BigInteger ResPathEffectProvider,
        BigInteger ResPathSoundRequest,
        long ReqSeFlag,
        int FxIndex0,
        int SeIndex0,
        int FxIndex1,
        int SeIndex1,
        int FxIndex2,
        int SeIndex2,
        int FxIndex3,
        int SeIndex3,
        BigInteger ResPathSwingModel,
        BigInteger ResPathSoftBody,
        BigInteger ResPathRigidBody,
        BigInteger ResPathBrRigidBody,
        BigInteger ResPathBrModel,
        BigInteger ResPathBrSoftBody,
        BigInteger ResPathCaught,
        BigInteger ResPathZone,
        BigInteger ResPathOmZone,
        BigInteger ResPathJointInfo,
        long DetailBehavior, // TODO: This is a flag, find enum
        long MapIcon,
        float KillLength,
        boolean UseNightColor,
        Vector3f NightColor,
        float RigidTime,
        float RigidForce,
        float RigidOfsY,
        float RigidVelocity,
        float ThrowVelocity,
        float ThrowVectorY,
        float RigidWorldOfsY,
        Vector3f TargetOfs,
        boolean Nav,
        Vector3f NavOBBPos,
        Vector3f NavOBBExtent,
        boolean Atk,
        long ShotGroup,
        int WepType,
        long ArcTagID,
        int TargetJntNo,
        float OffSeLength,
        int JointNum,
        Vector3f KeyOfs,
        long ColliOffFrame,
        long BlinkType,
        @MetaInformation
        OmBlinkType BlinkTypeName,
        List<BigInteger> ResPathCollision, //[4]
        long Version
) {
    public OmParam(int omID, BigInteger resPathModel, BigInteger resPathObjCollision, BigInteger resPathMotionList, BigInteger resPathSoundMotionSe, long unitDTIID, long useComponent, long omSetType, BigInteger resPathEffectProvider, BigInteger resPathSoundRequest, long reqSeFlag, int fxIndex0, int seIndex0, int fxIndex1, int seIndex1, int fxIndex2, int seIndex2, int fxIndex3, int seIndex3, BigInteger resPathSwingModel, BigInteger resPathSoftBody, BigInteger resPathRigidBody, BigInteger resPathBrRigidBody, BigInteger resPathBrModel, BigInteger resPathBrSoftBody, BigInteger resPathCaught, BigInteger resPathZone, BigInteger resPathOmZone, BigInteger resPathJointInfo, long detailBehavior, long mapIcon, float killLength, boolean useNightColor, Vector3f nightColor, float rigidTime, float rigidForce, float rigidOfsY, float rigidVelocity, float throwVelocity, float throwVectorY, float rigidWorldOfsY, Vector3f targetOfs, boolean nav, Vector3f navOBBPos, Vector3f navOBBExtent, boolean atk, long shotGroup, int wepType, long arcTagID, int targetJntNo, float offSeLength, int jointNum, Vector3f keyOfs, long colliOffFrame, long blinkType, List<BigInteger> resPathCollision, long version) {
        this(omID, resPathModel, resPathObjCollision, resPathMotionList, resPathSoundMotionSe, unitDTIID, useComponent,
                omSetType, OmLotSetType.of(omSetType),
                resPathEffectProvider, resPathSoundRequest, reqSeFlag, fxIndex0, seIndex0, fxIndex1, seIndex1, fxIndex2, seIndex2, fxIndex3, seIndex3, resPathSwingModel, resPathSoftBody, resPathRigidBody, resPathBrRigidBody, resPathBrModel, resPathBrSoftBody, resPathCaught, resPathZone, resPathOmZone, resPathJointInfo, detailBehavior, mapIcon, killLength, useNightColor, nightColor, rigidTime, rigidForce, rigidOfsY, rigidVelocity, throwVelocity, throwVectorY, rigidWorldOfsY, targetOfs, nav, navOBBPos, navOBBExtent, atk, shotGroup, wepType, arcTagID, targetJntNo, offSeLength, jointNum, keyOfs, colliOffFrame,
                blinkType, OmBlinkType.of(blinkType),
                resPathCollision, version);
    }
}
