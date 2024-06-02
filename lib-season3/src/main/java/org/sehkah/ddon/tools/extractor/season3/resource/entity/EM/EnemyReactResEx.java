package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

import java.math.BigInteger;
import java.util.List;

public record EnemyReactResEx(
        long OverallConditionsType,
        float OverallConditions0,
        float OverallConditions1,
        boolean OverallConditionsReverse,
        boolean OverallConditionsBitMode,
        long WhereType,//8
        int WhereNo,//8
        long WhereType1,
        int WhereNo1,
        long WhereType2,
        int WhereNo2,
        long WhereType3,
        int WhereNo3,
        long WhereType4,
        int WhereNo4,
        long WhereType5,
        int WhereNo5,
        long WhereType6,
        int WhereNo6,
        long WhereType7,
        int WhereNo7,
        boolean WhereNoRev,
        long PlayTypeGuard,
        long PlayTypeNamed,
        long PlayTypeAnger,
        long PlayTypeNanteki,
        long PlayTypeYojinoboriAttack,
        boolean PlayTypeHP,
        List<Float> PlayTypeHPParam, //2
        boolean PlayTypeHPParamReverse,
        long PlayTypeUseSeq,
        long PlayTypeUseSeqWorkNo,
        long PlayTypeSeqNo,
        long PlayTypeSeqWorkNo,
        List<Boolean> CountType, //12
        boolean ResetTypeBlow,
        long ResetTypeBlowCount,
        boolean ResetTypeShrink,
        long ResetTypeShrinkCount,
        boolean ResetTypeDown,
        long ResetTypeDownCount,
        long ResetType,
        float FResetParam,
        long UResetParam,
        boolean ResultThinkTable,
        int ResultThinkTableNo,
        boolean ResultThinkTableActionGet,
        boolean ResultAction,
        long ResultActionNo,
        BigInteger OverallConditionsBit,
        List<EnemyReactRes> EnemyReactResList
) {
}
