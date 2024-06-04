package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EvaluationTable {
    private long EvalutionCategory;
    private long EvalutionCategoryMax;
    private float EvalutionCategoryDecPer;
    private float EvalutionCategoryHosei;
    private float EvalutionCategoryEizokuHosei;
}
