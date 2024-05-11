package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.Human;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.Human.meta.WeaponOffsetConstType;

public record WeaponOffset(
        long ConstType,
        @MetaInformation
        WeaponOffsetConstType ConstTypeName,
        int JntNo,
        Vector3f Rot,
        Vector3f Ofs,
        float Fat,
        int JntNoHold,
        Vector3f RotHold,
        Vector3f OfsHold,
        float FatHold,
        int JntNoDamage,
        Vector3f RotDamage,
        Vector3f OfsDamage,
        float FatDamage,
        int JntNoSpecial,
        Vector3f RotSpecial,
        Vector3f OfsSpecial,
        float FatSpecial
) {
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
