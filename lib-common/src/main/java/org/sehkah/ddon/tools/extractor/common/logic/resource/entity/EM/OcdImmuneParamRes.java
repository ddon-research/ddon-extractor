package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class OcdImmuneParamRes {
    private long OcdUID;
    private float ImmuneRate;
    private long ImmuneNum;
}
