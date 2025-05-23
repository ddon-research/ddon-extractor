package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.marker;

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
    private int DestinationStageNo;
    // TODO: Lookup
    private int NextStageNo;
    private List<JumpPosition> Positions;
}
