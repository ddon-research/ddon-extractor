package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.logic.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;

public record ReplaceWardGmd(
        BigInteger GUIMessageResPathId,
        @MetaInformation
        long PathCRC,
        @MetaInformation
        long Type,
        @MetaInformation
        String TypeName
) {
    public ReplaceWardGmd(BigInteger GUIMessageResPathId) {
        this(GUIMessageResPathId,
                FrameworkResourcesUtil.convertResourceIdToPathId(GUIMessageResPathId),
                FrameworkResourcesUtil.convertResourceIdToTagId(GUIMessageResPathId),
                FrameworkResourcesUtil.getFileExtension(FrameworkResourcesUtil.convertResourceIdToTagId(GUIMessageResPathId))
        );
    }
}
