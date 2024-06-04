package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

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
}
