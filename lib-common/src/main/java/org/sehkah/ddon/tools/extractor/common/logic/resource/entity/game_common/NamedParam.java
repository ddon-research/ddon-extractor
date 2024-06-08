package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta.NamedParamType;

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
}
