package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job;

import java.util.List;

public record MagicCommandList(
        List<MagicCommand> Easy,
        List<MagicCommand> Normal,
        List<MagicCommand> Hard
) {
}
