package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.meta.EnemyDmgTimerType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EmDmgTimerTbl {
    private long Type;
    @MetaInformation
    private EnemyDmgTimerType TypeName;
    private float Timer;

    public EmDmgTimerTbl(long type, float timer) {
        this(
                type, EnemyDmgTimerType.of(type),
                timer);
    }
}
