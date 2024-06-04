package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class BakeJoint {
    private boolean Bake;
    private int RefJnt;
}
