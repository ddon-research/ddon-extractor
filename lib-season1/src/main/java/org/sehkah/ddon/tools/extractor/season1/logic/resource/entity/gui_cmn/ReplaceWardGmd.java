package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.FrameworkResourcesUtil;

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
