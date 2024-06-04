package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.binary;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ClassHeader {
    private long numClasses;
    private long bufferSizeForHeader;
    private List<Long> classDataOffsets;
    private List<ClassData> classDataList;
}
