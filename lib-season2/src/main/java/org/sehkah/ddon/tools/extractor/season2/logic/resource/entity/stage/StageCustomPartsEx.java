package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageCustomPartsEx extends TopLevelClientResource {
    private StageCustomPartsParam Param;
    private List<StageCustomPartsExInfoEx> ArrayInfo;
    private List<StageCustomPartsFilter> ArrayFilter;
    private List<StageCustomPartsExColorFog> ArrayColorFog;
    private List<StageCustomPartsExHemiSphLight> ArrayHemiSphLight;
    private List<StageCustomPartsExInfiLight> ArrayInfiLight;
    private List<StageCustomPartsExPattern> ArrayPattern;
}
