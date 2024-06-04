package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ChildRegionStatusParam {
    private long No;
    private List<Long> ParentNo; //2
    private List<Float> AttackTolerance; //4
    private List<Float> MagicTolerance; //7
    private float ShrinkAdj;
    private float BlowAdj;
    private float DownAdj;
    private float OcdAdj;
    private List<Float> ShakeAdjPhys; //4
    private List<Float> ShakeAdjMagic; //7
    private float ShakeAdjShake;
    private float HitStopAdj;
    private float HitSlowAdj;
    private List<Float> ShrinkDamageRatePhys;//4
    private List<Float> ShrinkDamageRateMagic;//7
    private List<Float> BlowDamageRatePhys;//4
    private List<Float> BlowDamageRateMagic;//7
    private List<Float> DownDamageRatePhys;//4
    private List<Float> DownDamageRateMagic;//7
    private long HitStopDefenceAttr;
    private long Surface;
    private boolean IsClimbBonus;
    private boolean IsDownWeakRegion;
    private long CorePointType;
    private int CorePointID;
    private int CoreJointNo;
    private Vector3f CoreJointOffset;
    private int CoreEpvIndex;
    private int CoreEpvElementNo;
    private List<Long> AttackReactionType; //4
    private List<Boolean> IsElementWeakRegion; //6;
}
