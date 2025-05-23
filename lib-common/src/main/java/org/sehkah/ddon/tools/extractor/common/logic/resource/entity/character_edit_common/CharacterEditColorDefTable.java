package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common;

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
public class CharacterEditColorDefTable extends Resource {
    private List<CharacterEditColorDef> CharacterEditColorDefTable;
}
