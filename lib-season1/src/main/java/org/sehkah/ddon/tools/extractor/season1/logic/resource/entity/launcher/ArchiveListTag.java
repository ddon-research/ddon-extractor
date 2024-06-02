package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.launcher;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

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
