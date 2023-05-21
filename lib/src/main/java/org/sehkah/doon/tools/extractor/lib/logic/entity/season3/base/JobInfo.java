package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

import java.math.BigInteger;

public record JobInfo(
        int Lv,
        BigInteger Exp,
        long Atk,
        long Def,
        long MAtk,
        long MDef,
        long Strength,
        long DownPower,
        long ShakePower,
        long StanPower,
        long Constitution,
        long Guts,
        BigInteger JobPoint,
        int FireResist,
        int IceResist,
        int ThunderResist,
        int HolyResist,
        int DarkResist,
        int SpreadResist,
        int FreezeResist,
        int ShockResist,
        int AbsorbResist,
        int DarkElmResist,
        int PoisonResist,
        int SlowResist,
        int SleepResist,
        int StunResist,
        int WetResist,
        int OilResist,
        int SealResist,
        int CurseResist,
        int SoftResist,
        int StoneResist,
        int GoldResist,
        int FireReduceResist,
        int IceReduceResist,
        int ThunderReduceResist,
        int HolyReduceResist,
        int DarkReduceResist,
        int AtkDownResist,
        int DefDownResist,
        int MAtkDownResist,
        int MDefDownResist,
        int ErosionResist,
        int ItemSealResist
) implements DeserializableClientResource {
}
