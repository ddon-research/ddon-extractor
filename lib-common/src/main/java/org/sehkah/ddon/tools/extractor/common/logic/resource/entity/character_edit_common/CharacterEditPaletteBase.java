package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CharacterEditPaletteBase {
    private long IconNo;
    private long ReleaseVersion;
    private long Flag;
}
