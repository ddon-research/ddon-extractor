package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaInfo {
    private final long AreaId;
    private final int PosX;
    private final int PosY;

    public AreaInfo(long areaId, int posX, int posY) {
        this.AreaId = areaId;
        this.PosX = posX;
        this.PosY = posY;
    }
}
