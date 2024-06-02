package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

public record EnemyMaterial(
        long Idx,
        long MaterialType,
        int MaterialNo,
        long MaterialWeakPointNo,
        long MaterialAnimationType,
        boolean DieIsNoCall
) {
}
