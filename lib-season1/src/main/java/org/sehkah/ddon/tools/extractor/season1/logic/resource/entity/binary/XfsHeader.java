package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.binary;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.Map;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class XfsHeader {
    private int resourceVersion;
    private long objectDataNum;
    private int classIndex;
    private int objIndex;
    private ClassHeader classHeader;
    private Map<Integer, ClassData> classHeaderIndex;
}
