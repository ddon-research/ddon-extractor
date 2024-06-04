package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmLadder extends SetInfo {
    private long Height;
    private SetInfoOm InfoOm;
}
