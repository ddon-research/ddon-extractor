package org.sehkah.doon.tools.extractor.lib.logic.entity.em_common;

public record EvaluationTable(
        long EvalutionCategory,
        long EvalutionCategoryMax,
        float EvalutionCategoryDecPer,
        float EvalutionCategoryHosei,
        float EvalutionCategoryEizokuHosei
) {
}
