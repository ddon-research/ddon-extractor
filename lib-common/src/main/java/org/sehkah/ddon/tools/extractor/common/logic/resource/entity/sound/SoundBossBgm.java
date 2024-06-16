package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ResourceInfoS;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SoundBossBgm {
    private long EnemyId;
    @MetaInformation
    private Translation EnemyName;
    private long BgmNo;
    private ResourceInfoS SrqrId;
}
