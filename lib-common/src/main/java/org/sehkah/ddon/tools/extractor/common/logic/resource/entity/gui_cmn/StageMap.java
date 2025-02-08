package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageMap {
    private int StageNo;
    @MetaInformation
    private Translation StageName;
    private int PartsNum;
    private float OffsetY;
    private long StageFlag;
    private List<StageMapParam> ParamList;
}
