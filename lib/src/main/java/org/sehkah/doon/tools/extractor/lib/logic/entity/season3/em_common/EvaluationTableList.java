package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.em_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record EvaluationTableList(
        List<EvaluationTable> EvaluationTableList
) implements TopLevelClientResource {
}
