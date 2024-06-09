package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta.OmBlinkType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta.OmLotSetType;

import java.math.BigInteger;
import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class OmParam {
    private int OmID;
    private BigInteger ResPathModel;
    private BigInteger ResPathObjCollision;
    private BigInteger ResPathMotionList;
    private BigInteger ResPathSoundMotionSe;
    private long UnitDTIID;
    private long UseComponent;
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
    private long DetailBehavior; // TODO: This is a flag, find enum
    private long MapIcon;
    private float KillLength;
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
    private float OffSeLength;
    private int JointNum;
    private Vector3f KeyOfs;
    private long ColliOffFrame;
    private long BlinkType;
    @MetaInformation
    private OmBlinkType BlinkTypeName;
    private List<BigInteger> ResPathCollision; //[4]
    private long Version;

    public OmParam(int omID, BigInteger resPathModel, BigInteger resPathObjCollision, BigInteger resPathMotionList, BigInteger resPathSoundMotionSe, long unitDTIID, long useComponent, long omSetType, BigInteger resPathEffectProvider, BigInteger resPathSoundRequest, long reqSeFlag, int fxIndex0, int seIndex0, int fxIndex1, int seIndex1, int fxIndex2, int seIndex2, int fxIndex3, int seIndex3, BigInteger resPathSwingModel, BigInteger resPathSoftBody, BigInteger resPathRigidBody, BigInteger resPathBrRigidBody, BigInteger resPathBrModel, BigInteger resPathBrSoftBody, BigInteger resPathCaught, BigInteger resPathZone, BigInteger resPathOmZone, BigInteger resPathJointInfo, long detailBehavior, long mapIcon, float killLength, boolean useNightColor, Vector3f nightColor, float rigidTime, float rigidForce, float rigidOfsY, float rigidVelocity, float throwVelocity, float throwVectorY, float rigidWorldOfsY, Vector3f targetOfs, boolean nav, Vector3f navOBBPos, Vector3f navOBBExtent, boolean atk, long shotGroup, int wepType, long arcTagID, int targetJntNo, float offSeLength, int jointNum, Vector3f keyOfs, long colliOffFrame, long blinkType, List<BigInteger> resPathCollision, long version) {
        this(omID, resPathModel, resPathObjCollision, resPathMotionList, resPathSoundMotionSe, unitDTIID, useComponent,
                omSetType, OmLotSetType.of(omSetType),
                resPathEffectProvider, resPathSoundRequest, reqSeFlag, fxIndex0, seIndex0, fxIndex1, seIndex1, fxIndex2, seIndex2, fxIndex3, seIndex3, resPathSwingModel, resPathSoftBody, resPathRigidBody, resPathBrRigidBody, resPathBrModel, resPathBrSoftBody, resPathCaught, resPathZone, resPathOmZone, resPathJointInfo, detailBehavior, mapIcon, killLength, useNightColor, nightColor, rigidTime, rigidForce, rigidOfsY, rigidVelocity, throwVelocity, throwVectorY, rigidWorldOfsY, targetOfs, nav, navOBBPos, navOBBExtent, atk, shotGroup, wepType, arcTagID, targetJntNo, offSeLength, jointNum, keyOfs, colliOffFrame,
                blinkType, OmBlinkType.of(blinkType),
                resPathCollision, version);
    }
}
