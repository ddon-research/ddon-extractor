package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class WarpLocation {
    private long Id;
    private long SortNo;
    private long AreaId;
    private long SpotId;
    private int StageNo;
    private long PosNo;
    private int MapPosX;
    private int MapPosY;
    private int IconType;
    private long Padding;
}
