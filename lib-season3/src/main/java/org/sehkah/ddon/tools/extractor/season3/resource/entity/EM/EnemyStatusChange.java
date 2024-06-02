package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

import java.util.List;

public record EnemyStatusChange(
        long GroupNo,
        long GroupSubNo,
        long NextGroupSubNo,
        boolean NextGroupSubOneGo,
        long SelectNo,
        long Type,
        long RepeatSetting,
        long ChangeStatus,
        List<Float> Param,
        List<Float> SystemParam,
        float SystemParamWait,
        long BitContrlCommand,
        boolean TypeReverse
) {
}
