package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.effect_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class VfxLightInfluence {
    private float LightIntensity;
    private float Custom1;
    private float Custom2;
    private float Custom3;
    private float Custom4;
    private float Custom6;
    private float Env1;
    private float Env2;
}
