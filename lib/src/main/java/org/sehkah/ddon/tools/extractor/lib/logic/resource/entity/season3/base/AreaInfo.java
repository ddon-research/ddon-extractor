package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaInfo extends org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.AreaInfo {
    private final int PosX;
    private final long PosY;

    public AreaInfo(long areaId, int posX, long posY) {
        super(areaId);
        this.PosX = posX;
        this.PosY = posY;
    }
}
