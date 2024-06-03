package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.NamedParamType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NamedParam {
    private long ID;
    @MetaInformation
    private String Name;
    private long Type;
    @MetaInformation
    private NamedParamType TypeName;
    private long HpRate;
    private int Experience;
    private int AttackBasePhys;
    private int AttackWepPhys;
    private int DefenceBasePhys;
    private int DefenceWepPhys;
    private int AttackBaseMagic;
    private int AttackWepMagic;
    private int DefenceBaseMagic;
    private int DefenceWepMagic;
    private int Power;
    private int GuardDefenceBase;
    private int GuardDefenceWep;
    private int ShrinkEnduranceMain;
    private int BlowEnduranceMain;
    private int DownEnduranceMain;
    private int ShakeEnduranceMain;
    private int HpSub;
    private int ShrinkEnduranceSub;
    private int BlowEnduranceSub;
    private int OcdEndurance;
    private int AilmentDamage;

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
