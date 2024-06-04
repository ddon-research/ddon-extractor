package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StaminaDecTbl extends TopLevelClientResource {
    private List<StaminaDecList> StaminaDecTbl;
}
