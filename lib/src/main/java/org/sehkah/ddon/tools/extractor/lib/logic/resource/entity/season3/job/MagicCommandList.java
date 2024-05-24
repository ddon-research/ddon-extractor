package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job;

import java.util.List;

public record MagicCommandList(
        List<MagicCommand> Easy,
        List<MagicCommand> Normal,
        List<MagicCommand> Hard
) {
}
