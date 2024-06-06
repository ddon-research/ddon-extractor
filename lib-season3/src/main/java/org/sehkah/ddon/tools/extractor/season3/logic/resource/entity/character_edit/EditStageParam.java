package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.character_edit;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EditStageParam extends TopLevelClientResource {
    private List<EditStageParamInfo> ArrayInfo;
    private List<EditStageParamList> ArrayList;
}
