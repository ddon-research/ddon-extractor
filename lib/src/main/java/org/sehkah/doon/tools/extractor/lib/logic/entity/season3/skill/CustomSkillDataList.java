package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.skill;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record CustomSkillDataList(
        List<CustomSkillData> CustomSkillDataList
) implements TopLevelClientResource {
}
