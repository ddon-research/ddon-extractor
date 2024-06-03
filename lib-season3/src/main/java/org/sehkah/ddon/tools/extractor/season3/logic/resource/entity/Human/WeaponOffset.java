package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human.meta.WeaponOffsetConstType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class WeaponOffset {
    private long ConstType;
    @MetaInformation
    private WeaponOffsetConstType ConstTypeName;
    private int JntNo;
    private Vector3f Rot;
    private Vector3f Ofs;
    private float Fat;
    private int JntNoHold;
    private Vector3f RotHold;
    private Vector3f OfsHold;
    private float FatHold;
    private int JntNoDamage;
    private Vector3f RotDamage;
    private Vector3f OfsDamage;
    private float FatDamage;
    private int JntNoSpecial;
    private Vector3f RotSpecial;
    private Vector3f OfsSpecial;
    private float FatSpecial;

    public WeaponOffset(long constType, int jntNo, Vector3f rot, Vector3f ofs, float fat, int jntNoHold,
                        Vector3f rotHold, Vector3f ofsHold, float fatHold, int jntNoDamage, Vector3f rotDamage,
                        Vector3f ofsDamage, float fatDamage, int jntNoSpecial, Vector3f rotSpecial, Vector3f ofsSpecial,
                        float fatSpecial) {
        this(constType, WeaponOffsetConstType.of(constType),
                jntNo,
                rot,
                ofs,
                fat,
                jntNoHold,
                rotHold,
                ofsHold,
                fatHold,
                jntNoDamage,
                rotDamage,
                ofsDamage,
                fatDamage,
                jntNoSpecial,
                rotSpecial,
                ofsSpecial,
                fatSpecial);
    }
}
