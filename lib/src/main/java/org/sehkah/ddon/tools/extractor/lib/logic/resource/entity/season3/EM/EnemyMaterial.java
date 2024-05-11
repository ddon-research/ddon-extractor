package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM;

public record EnemyMaterial(
        long Idx,
        long MaterialType,
        int MaterialNo,
        long MaterialWeakPointNo,
        long MaterialAnimationType,
        boolean DieIsNoCall
) {
}
