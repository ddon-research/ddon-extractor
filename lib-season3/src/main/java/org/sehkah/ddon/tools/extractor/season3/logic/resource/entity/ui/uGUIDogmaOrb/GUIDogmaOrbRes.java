package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIDogmaOrb;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GUIDogmaOrbRes {
    private long ElementId;
    private long ParamType;
    private long ParamId;
    private long ParamValue;
    private long RequireOrb;
    private long IconNo;
}
