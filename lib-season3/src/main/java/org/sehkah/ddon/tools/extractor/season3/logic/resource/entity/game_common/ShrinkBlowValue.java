package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.ObjCollisionBlowShrinkLevel;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.ObjCollisionShrinkBlowType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ShrinkBlowValue {
    private long DamageType;
    @MetaInformation
    private ObjCollisionShrinkBlowType DamageTypeName;
    private long Lv;
    @MetaInformation
    private ObjCollisionBlowShrinkLevel LvType;
    private float SpeedXZ;
    private float AccelerateXZ;
    private float SpeedY;
    private float GravityY;

    public ShrinkBlowValue(long damageType, long lv, float speedXZ, float accelerateXZ, float speedY, float gravityY) {
        this(
                damageType, ObjCollisionShrinkBlowType.of(damageType),
                lv, ObjCollisionBlowShrinkLevel.of(lv),
                speedXZ,
                accelerateXZ,
                speedY,
                gravityY
        );
    }
}
