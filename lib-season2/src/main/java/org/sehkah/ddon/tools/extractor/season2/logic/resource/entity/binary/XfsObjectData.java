package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class XfsObjectData {
    private int classIndex;
    private int objIndex;
    private long bufferSize;
}
