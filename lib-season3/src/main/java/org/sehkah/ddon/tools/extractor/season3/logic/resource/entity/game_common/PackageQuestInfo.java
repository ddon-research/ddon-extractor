package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

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
public class PackageQuestInfo {
    private long PackageNo;
    private long ContentInfoIdx;
    private long GatherNpcId;
    @MetaInformation
    private Translation GatherNpcName;
    private long GatherStartPos;
    private long ContentNameIdx;
}
