package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.Map;

@Slf4j
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListParamApGet extends ItemListParam {
    @JsonIgnore
    private int AreaId;
    @MetaInformation
    private Translation AreaName;
    @JsonIgnore
    private int Point;
    @JsonIgnore
    private int padding;

    public ItemListParamApGet(short kindType, String kindTypeName, int areaId, Translation areaName, int point, int padding) {
        super(kindType, kindTypeName, Map.of(
                "AreaId", areaId,
                "Point", point
        ));
        AreaId = areaId;
        AreaName = areaName;
        Point = point;
        this.padding = padding;
    }
}
