package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class CharParamEnemyTable extends TopLevelClientResource {
    private final boolean FlgEnemyFly;
    private final CharParamEnemy CharParamEnemy;
    private final float ScaleDispGui;
    private final long Unknown1;
    private final long Unknown2;
}
