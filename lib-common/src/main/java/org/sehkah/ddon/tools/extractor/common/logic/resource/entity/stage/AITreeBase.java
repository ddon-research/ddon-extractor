package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AITreeBase {
    private int Nest;
    //    private int AxisPartition;
    private long NumberOfNode;
//    private List<AITreeBaseNode> Node;
//    private boolean Delete;
}
