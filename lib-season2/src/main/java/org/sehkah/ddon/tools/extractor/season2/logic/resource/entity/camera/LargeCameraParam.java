package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.camera;

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
public class LargeCameraParam {
    private long EmId;
    @MetaInformation
    private Translation EnemyName;
    private float Range1;
    private float Range2;
    private long Camera;
    private boolean Group;
}
