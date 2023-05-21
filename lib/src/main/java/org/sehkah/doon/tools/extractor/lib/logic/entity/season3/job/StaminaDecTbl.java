package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.job;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record StaminaDecTbl(
        List<StaminaDecList> StaminaDecTbl
) implements TopLevelClientResource {
}
