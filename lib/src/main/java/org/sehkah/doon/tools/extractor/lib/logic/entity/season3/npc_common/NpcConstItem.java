package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

public record NpcConstItem(
        long MTag,
        long Offset
) implements TopLevelClientResource {
}
