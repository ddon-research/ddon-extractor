package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;


import java.util.List;

public record CalcDamageLvAdj(
        short LvDiff,
        List<Float> LvAdj
) {
}
