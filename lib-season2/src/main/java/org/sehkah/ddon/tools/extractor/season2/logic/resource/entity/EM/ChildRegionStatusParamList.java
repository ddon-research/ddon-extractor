package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ChildRegionStatusParamList {
    private ChildRegionStatusParamTable ChildRegion;
    private long StatusNo;
    private int CheckPriority;
    private int WritePriority;
}
