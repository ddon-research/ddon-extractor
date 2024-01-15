package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class SetInfoOmOneWay extends SetInfo {
    private final List<Vector3f> WarpPos; //4
    private final SetInfoOmEx InfoOmEx;
}
