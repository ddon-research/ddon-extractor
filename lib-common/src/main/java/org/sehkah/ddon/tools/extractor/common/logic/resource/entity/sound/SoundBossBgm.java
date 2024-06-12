package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
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
    private long BgmNo;
    private ResourceInfoS SrqrId;
}
