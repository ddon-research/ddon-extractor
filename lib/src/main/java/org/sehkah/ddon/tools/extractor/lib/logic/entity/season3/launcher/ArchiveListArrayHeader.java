package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.launcher;

import java.util.List;


public record ArchiveListArrayHeader(
        long Version,
        long MagicNo,
        long ConvHash,
        int TagNum,
        int TargetTagNo,
        List<ArchiveListTag> Tag
) {
}
