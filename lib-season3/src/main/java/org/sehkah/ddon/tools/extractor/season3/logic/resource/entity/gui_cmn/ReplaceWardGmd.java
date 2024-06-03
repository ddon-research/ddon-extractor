package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.FrameworkResourcesUtil;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ReplaceWardGmd {
    private BigInteger GUIMessageResPathId;
    @MetaInformation
    private long PathCRC;
    @MetaInformation
    private long Type;
    @MetaInformation
    private String TypeName;

    public ReplaceWardGmd(BigInteger GUIMessageResPathId) {
        this(GUIMessageResPathId,
                FrameworkResourcesUtil.convertResourceIdToPathId(GUIMessageResPathId),
                FrameworkResourcesUtil.convertResourceIdToTagId(GUIMessageResPathId),
                FrameworkResourcesUtil.getFileExtension(FrameworkResourcesUtil.convertResourceIdToTagId(GUIMessageResPathId))
        );
    }
}
