package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job;

import java.util.List;

public record MagicCommandList(
        List<MagicCommand> Easy,
        List<MagicCommand> Normal,
        List<MagicCommand> Hard
) {
}
