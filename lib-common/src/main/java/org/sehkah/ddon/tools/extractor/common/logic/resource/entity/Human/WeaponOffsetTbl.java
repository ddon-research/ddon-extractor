package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Human;

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
public class WeaponOffsetTbl extends Resource {
    private List<WeaponOffset> WeaponOffsetTbl;
}
