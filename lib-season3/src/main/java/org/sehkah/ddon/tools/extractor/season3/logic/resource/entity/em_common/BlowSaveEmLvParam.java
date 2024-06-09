package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.em_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class BlowSaveEmLvParam {
    private long KeyLv;
    private float SaveRate;
}
