package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea;

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
    // TODO: Lookup
    private short DestinationStageNo;
    // TODO: Lookup
    private short NextStageNo;
    private List<AdjoinInfoVector3> Positions;
    private int Priority;
}
