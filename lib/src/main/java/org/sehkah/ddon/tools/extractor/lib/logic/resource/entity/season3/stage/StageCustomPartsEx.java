package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.StageCustomPartsFilter;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.StageCustomPartsParam;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class StageCustomPartsEx extends TopLevelClientResource {
    private final StageCustomPartsParam Param;
    private final List<StageCustomPartsExInfoEx> ArrayInfo;
    private final List<StageCustomPartsFilter> ArrayFilter;
    private final List<StageCustomPartsExColorFog> ArrayColorFog;
    private final List<StageCustomPartsExHemiSphLight> ArrayHemiSphLight;
    private final List<StageCustomPartsExInfiLight> ArrayInfiLight;
    private final List<StageCustomPartsExPattern> ArrayPattern;
}
