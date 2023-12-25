package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.launcher;

import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;


public record ArchiveListTag(
        @MetaInformation
        long ArcPathPointer,
        String ArcPath,
        long TagId,
        long Group,
        long Type,
        long NodeNum,
        @MetaInformation
        long NodeArrayPointer,
        List<ArchiveListNode> NodeArray
) {
}
