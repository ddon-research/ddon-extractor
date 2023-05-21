package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.EM;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record EmLvUpParamList(
        List<EmLvUpParam> EmLvUpParamList
) implements TopLevelClientResource {
}
