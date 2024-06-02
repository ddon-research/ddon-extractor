package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta.NamedParamType;

public record NamedParam(
        long ID,
        @MetaInformation
        String Name,
        long Type,
        @MetaInformation
        NamedParamType TypeName,
        long HpRate,
        int Experience,
        int AttackBasePhys,
        int AttackWepPhys,
        int DefenceBasePhys,
        int DefenceWepPhys,
        int AttackBaseMagic,
        int AttackWepMagic,
        int DefenceBaseMagic,
        int DefenceWepMagic,
        int Power,
        int GuardDefenceBase,
        int GuardDefenceWep,
        int ShrinkEnduranceMain,
        int BlowEnduranceMain,
        int DownEnduranceMain,
        int ShakeEnduranceMain,
        int HpSub,
        int ShrinkEnduranceSub,
        int BlowEnduranceSub,
        int OcdEndurance,
        int AilmentDamage
) {
    public NamedParam(long ID, long type, long hpRate, int experience, int attackBasePhys, int attackWepPhys, int defenceBasePhys, int defenceWepPhys, int attackBaseMagic, int attackWepMagic, int defenceBaseMagic, int defenceWepMagic, int power, int guardDefenceBase, int guardDefenceWep, int shrinkEnduranceMain, int blowEnduranceMain, int downEnduranceMain, int shakeEnduranceMain, int hpSub, int shrinkEnduranceSub, int blowEnduranceSub, int ocdEndurance, int ailmentDamage) {
        this(
                ID, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.NAMED_PARAM, "namedparam_" + ID),
                type, NamedParamType.of(type),
                hpRate,
                experience,
                attackBasePhys,
                attackWepPhys,
                defenceBasePhys,
                defenceWepPhys,
                attackBaseMagic,
                attackWepMagic,
                defenceBaseMagic,
                defenceWepMagic,
                power,
                guardDefenceBase,
                guardDefenceWep,
                shrinkEnduranceMain,
                blowEnduranceMain,
                downEnduranceMain,
                shakeEnduranceMain,
                hpSub,
                shrinkEnduranceSub,
                blowEnduranceSub,
                ocdEndurance,
                ailmentDamage);
    }
}
