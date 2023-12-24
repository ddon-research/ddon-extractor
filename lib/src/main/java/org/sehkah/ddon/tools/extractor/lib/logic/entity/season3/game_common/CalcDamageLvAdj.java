package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;


import java.util.List;

public record CalcDamageLvAdj(
        short LvDiff,
        List<Float> LvAdj
) {
}
