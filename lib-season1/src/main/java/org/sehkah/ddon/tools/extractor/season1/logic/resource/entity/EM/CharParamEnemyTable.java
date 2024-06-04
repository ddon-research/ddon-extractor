package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CharParamEnemyTable extends TopLevelClientResource {
    private boolean FlgEnemyFly;
    private CharParamEnemy CharParamEnemy;
    private float ScaleDispGui;
}
