package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.meta.EnemyBloodStainType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EnemyBloodStain {
    private int BloodStainType;
    @MetaInformation
    private EnemyBloodStainType BloodStainTypeName;
    private float HpRateLv1;
    private float HpRateLv2;
    private float HpRateLv3;
    private int RegionNoLv1;
    private int RegionNoLv2;
    private int RegionNoLv3;

    public EnemyBloodStain(int bloodStainType, float hpRateLv1, float hpRateLv2, float hpRateLv3, int regionNoLv1, int regionNoLv2, int regionNoLv3) {
        this(
                bloodStainType, EnemyBloodStainType.of(bloodStainType),
                hpRateLv1,
                hpRateLv2,
                hpRateLv3,
                regionNoLv1,
                regionNoLv2,
                regionNoLv3
        );
    }
}
