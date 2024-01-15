package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@RequiredArgsConstructor
@Getter
public class SetInfoOmNav extends SetInfo {
    private final Vector3f NavOBBExtent;
    private final SetInfoOm InfoOm;
}
