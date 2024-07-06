package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector4f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmUnknown31 extends SetInfo {
    // TODO: Probably the little lava rock eruptions protruding from the ground specifically for Evil Dragon's Roost
    //  inactive/black state
    private Vector4f Unknown;
    private SetInfoOmOld InfoOm;
}
