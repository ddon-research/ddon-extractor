package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EnemyReactResEx {
    private long OverallConditionsType;
    private float OverallConditions0;
    private float OverallConditions1;
    private boolean OverallConditionsReverse;
    private boolean OverallConditionsBitMode;
    private long WhereType;//8
    private int WhereNo;//8
    private long WhereType1;
    private int WhereNo1;
    private long WhereType2;
    private int WhereNo2;
    private long WhereType3;
    private int WhereNo3;
    private long WhereType4;
    private int WhereNo4;
    private long WhereType5;
    private int WhereNo5;
    private long WhereType6;
    private int WhereNo6;
    private long WhereType7;
    private int WhereNo7;
    private boolean WhereNoRev;
    private long PlayTypeGuard;
    private long PlayTypeNamed;
    private long PlayTypeAnger;
    private long PlayTypeNanteki;
    private long PlayTypeYojinoboriAttack;
    private boolean PlayTypeHP;
    private List<Float> PlayTypeHPParam; //2
    private boolean PlayTypeHPParamReverse;
    private long PlayTypeUseSeq;
    private long PlayTypeUseSeqWorkNo;
    private long PlayTypeSeqNo;
    private long PlayTypeSeqWorkNo;
    private List<Boolean> CountType; //12
    private boolean ResetTypeBlow;
    private long ResetTypeBlowCount;
    private boolean ResetTypeShrink;
    private long ResetTypeShrinkCount;
    private boolean ResetTypeDown;
    private long ResetTypeDownCount;
    private long ResetType;
    private float FResetParam;
    private long UResetParam;
    private boolean ResultThinkTable;
    private int ResultThinkTableNo;
    private boolean ResultThinkTableActionGet;
    private boolean ResultAction;
    private long ResultActionNo;
    private BigInteger OverallConditionsBit;
    private List<EnemyReactRes> EnemyReactResList;
}
