package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageCustomPartsExAreaParam {
    private boolean UseAllFilter;
    private int FilterNo;
    private int PatternNo;
    private long AreaHitShapeListNum;
    private List<AreaHitShape> AreaHitShapeList;

    public StageCustomPartsExAreaParam(boolean useAllFilter, int filterNo, int patternNo, List<AreaHitShape> areaHitShapeList) {
        this(useAllFilter, filterNo, patternNo, areaHitShapeList.size(), areaHitShapeList);
    }
}
