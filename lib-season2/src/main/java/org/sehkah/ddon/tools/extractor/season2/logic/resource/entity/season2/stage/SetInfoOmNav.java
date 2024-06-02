package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmNav extends SetInfo {
    private final Vector3f NavOBBExtent;
    private final SetInfoOm InfoOm;
}
