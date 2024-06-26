package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.effect_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class VfxLightInfluenceList extends Resource {
    private List<VfxLightInfluence> VfxLightInfluenceList;
}
