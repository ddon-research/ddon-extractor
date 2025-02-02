package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector4f;

/**
 * Geyser which shoots the player up in the air, which then allows the player to slowly glide down.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmGeyser extends SetInfo {
    private Vector4f Unknown; // Probably activation zone or blowing ray volume
    private SetInfoOmOld InfoOm;
}
