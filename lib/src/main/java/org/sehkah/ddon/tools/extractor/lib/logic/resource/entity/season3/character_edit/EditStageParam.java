package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.character_edit;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class EditStageParam extends TopLevelClientResource {
    private final List<EditStageParamInfo> ArrayInfo;
    private final List<EditStageParamList> ArrayList;

}