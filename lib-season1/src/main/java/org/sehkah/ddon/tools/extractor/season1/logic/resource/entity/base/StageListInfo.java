package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.StageInfoType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageListInfo {
    private long StageNo;
    @MetaInformation
    private long StageId;
    private long Type;
    @MetaInformation
    private StageInfoType TypeName;
    private int RecommendLevel;
    private long MessageId;
    @MetaInformation
    private Translation StageName;
    private long Version;
}
