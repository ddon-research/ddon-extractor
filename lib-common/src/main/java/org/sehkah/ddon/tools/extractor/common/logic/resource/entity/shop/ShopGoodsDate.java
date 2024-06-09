package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.shop;

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
