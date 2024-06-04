package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea;

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
public class AdjoinInfo {
    private short DestinationStageNo;
    private short NextStageNo;
    private List<AdjoinInfoVector3> Positions;
    private int Priority;
}
