package org.sehkah.ddon.tools.extractor.season3.resource.entity.em_common;

public record EvaluationTable(
        long EvalutionCategory,
        long EvalutionCategoryMax,
        float EvalutionCategoryDecPer,
        float EvalutionCategoryHosei,
        float EvalutionCategoryEizokuHosei
) {
}
