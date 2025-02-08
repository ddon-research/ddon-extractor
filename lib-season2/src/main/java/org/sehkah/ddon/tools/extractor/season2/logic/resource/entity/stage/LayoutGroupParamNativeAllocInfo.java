package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class LayoutGroupParamNativeAllocInfo {
    private long IdArrayNum;
    private long LifeAreaArrayNum;
    private long AreaHitShapeArrayNum;
    private AreaHitShapeNativeAllocInfo ShapeAllocInfo;
}
