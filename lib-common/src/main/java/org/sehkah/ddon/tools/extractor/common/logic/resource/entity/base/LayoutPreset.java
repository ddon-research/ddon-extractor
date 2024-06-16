package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class LayoutPreset {
    @MetaInformation
    private int PresetKind;
    private String Keyword;
    private long CtrlType;
    private long EnemyId;
    @MetaInformation
    private Translation EnemyName;
}
