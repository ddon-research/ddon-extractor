package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageCustomPartsExColorFogDayNightColorFogParam {
    private float HeightStart;
    private float HeightEnd;
    private float HeightDensity;
    private Vector3f HeightColor;
    private float Start;
    private float End;
    private float Density;
    private Vector3f Color;
    private float DiffuseBlendFactor;
}
