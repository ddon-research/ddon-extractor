package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

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
    @MetaInformation
    private Translation AreaName;
    private long SpotId;
    @MetaInformation
    private Translation SpotName;
    private int StageNo;
    @MetaInformation
    private Translation StageName;
    private long PosNo;
    private int MapPosX;
    private int MapPosY;
    private int IconType;
    private int Unknown1;
    private int Unknown2;
}
