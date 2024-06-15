package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class JobInfo {
    private int Lv;
    private BigInteger Exp;
    private long Atk;
    private long Def;
    private long MAtk;
    private long MDef;
    private long Strength;
    private long DownPower;
    private long ShakePower;
    private long StanPower;
    private long Constitution;
    private long Guts;
    private BigInteger JobPoint;
    private int FireResist;
    private int IceResist;
    private int ThunderResist;
    private int HolyResist;
    private int DarkResist;
    private int SpreadResist;
    private int FreezeResist;
    private int ShockResist;
    private int AbsorbResist;
    private int DarkElmResist;
    private int PoisonResist;
    private int SlowResist;
    private int SleepResist;
    private int StunResist;
    private int WetResist;
    private int OilResist;
    private int SealResist;
    private int CurseResist;
    private int SoftResist;
    private int StoneResist;
    private int GoldResist;
    private int FireReduceResist;
    private int IceReduceResist;
    private int ThunderReduceResist;
    private int HolyReduceResist;
    private int DarkReduceResist;
    private int AtkDownResist;
    private int DefDownResist;
    private int MAtkDownResist;
    private int MDefDownResist;
    private int ErosionResist;
    private int ItemSealResist;
}
