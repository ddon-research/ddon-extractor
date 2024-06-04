package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaInfo {
    private long AreaId;
    private int PosX;
    private int PosY;
}
