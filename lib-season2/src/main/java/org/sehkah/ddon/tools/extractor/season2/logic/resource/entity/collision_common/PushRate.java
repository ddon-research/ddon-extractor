package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.collision_common;

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
public class PushRate {
    private List<Float> Rate;
}
