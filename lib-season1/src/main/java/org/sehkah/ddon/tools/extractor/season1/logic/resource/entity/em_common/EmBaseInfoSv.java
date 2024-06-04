package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.meta.EnemyCategoryType;

import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EmBaseInfoSv {
    @MetaInformation
    private int EnemyNo;
    private long EnemyID;
    private long EmCategory;
    @MetaInformation
    private Set<EnemyCategoryType> EnemyCategoryNames;

    public EmBaseInfoSv(int EnemyNo, long enemyID, long emCategory) {
        this(
                EnemyNo,
                enemyID,
                emCategory, BitUtil.extractBitSetUnsignedIntegerFlag(EnemyCategoryType::of, emCategory)
        );
    }
}
