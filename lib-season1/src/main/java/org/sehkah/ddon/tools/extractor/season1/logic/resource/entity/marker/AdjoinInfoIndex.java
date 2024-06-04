package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.marker;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AdjoinInfoIndex {
    private int Index;
}
