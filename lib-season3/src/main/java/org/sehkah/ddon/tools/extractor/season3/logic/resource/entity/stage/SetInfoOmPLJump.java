package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

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
public class SetInfoOmPLJump extends SetInfo {
    private float Length;
    private float JumpLength;
    private float Span;
    private float FireTime;
    private SetInfoOmOld InfoOm;
}
