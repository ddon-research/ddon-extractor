package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

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
