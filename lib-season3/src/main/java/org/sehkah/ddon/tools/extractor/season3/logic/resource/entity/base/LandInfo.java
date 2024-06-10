package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.LandAreaInfoGameMode;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class LandInfo {
    private long LandId;
    @MetaInformation
    private Translation LandName;
    private boolean IsDispNews;
    private int GameMode;
    @MetaInformation
    private LandAreaInfoGameMode GameModeName;
    private List<LandAreaInfo> AreaArray;
}
