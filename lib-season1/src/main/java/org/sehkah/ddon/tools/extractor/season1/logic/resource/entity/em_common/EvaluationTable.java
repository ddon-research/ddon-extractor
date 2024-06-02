package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common;

public record EvaluationTable(
        long EvalutionCategory,
        long EvalutionCategoryMax,
        float EvalutionCategoryDecPer,
        float EvalutionCategoryHosei,
        float EvalutionCategoryEizokuHosei
) {
}
