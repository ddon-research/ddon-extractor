package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.sg300000;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ShopGoodsDate {
    private int Year;
    private int Month;
    private int Day;
}
