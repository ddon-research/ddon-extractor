package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn;

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
public class StageMap {
    // TODO: Lookup
    private int StageNo;
    private int PartsNum;
    private float OffsetY;
    private long StageFlag;
    private List<StageMapParam> ParamList;
}
