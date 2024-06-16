package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.meta.EnemyCategoryType;

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
    @MetaInformation
    private Translation EnemyName;
    private long EmCategory;
    @MetaInformation
    private Set<EnemyCategoryType> EnemyCategoryNames;
}
