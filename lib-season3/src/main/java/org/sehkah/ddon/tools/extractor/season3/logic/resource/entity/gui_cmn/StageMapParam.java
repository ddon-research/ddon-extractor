package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageMapParam {
    private long AreaNo;
    private float Size;
    private String ModelName;
    private Vector3f ConnectPos;
}
