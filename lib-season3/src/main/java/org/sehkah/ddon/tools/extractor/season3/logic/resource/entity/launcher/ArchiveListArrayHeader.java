package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.launcher;

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
