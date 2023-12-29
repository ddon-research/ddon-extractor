package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.job;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.job.meta.MagicChantWordType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record MagicCommandWord(
        List<Integer> MagicCommand,
        @MetaInformation
        String MagicCommandName
) {
    public MagicCommandWord(List<Integer> word) {
        this(word, MagicChantWordType.toString(word));
    }
}
