package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.em_common;

public record EvaluationTable(
        long EvalutionCategory,
        long EvalutionCategoryMax,
        float EvalutionCategoryDecPer,
        float EvalutionCategoryHosei,
        float EvalutionCategoryEizokuHosei
) {
}
