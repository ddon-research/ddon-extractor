package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.AIPawnActionGroupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.AIPawnEnemySpStatusType;

import java.util.List;
import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIPawnEmNode {
    private long EmStatusNo;
    private List<Long> WeakAttrFlag;
    @MetaInformation
    private Set<AIPawnActionGroupType> WeakAttrFlagType;
    private List<Long> DisableAttrFlag;
    @MetaInformation
    private Set<AIPawnActionGroupType> DisableAttrFlagType;
    private List<Long> TargetPosFlag;
    private int ActiveCoreRegionNo;
    private int AddPrio;
    private List<Long> AIPawnEmParamFlag;
    private boolean FlgDefaultAttr;
    private boolean AttackNoInterval;
    private int Layer;
    private int ActiveMaskEffectRegionNo;
    private int EmSpStatus;
    @MetaInformation
    private AIPawnEnemySpStatusType EmSpStatusType;

    public AIPawnEmNode(long EmStatusNo,
                        List<Long> WeakAttrFlag,
                        List<Long> DisableAttrFlag,
                        List<Long> TargetPosFlag,
                        int ActiveCoreRegionNo,
                        int AddPrio,
                        List<Long> AIPawnEmParamFlag,
                        boolean FlgDefaultAttr,
                        boolean AttackNoInterval,
                        int Layer,
                        int ActiveMaskEffectRegionNo,
                        int EmSpStatus) {
        this(
                EmStatusNo,
                WeakAttrFlag, BitUtil.extractBitSetUnsignedIntegerFlag(AIPawnActionGroupType::of, WeakAttrFlag),
                DisableAttrFlag, BitUtil.extractBitSetUnsignedIntegerFlag(AIPawnActionGroupType::of, DisableAttrFlag),
                TargetPosFlag,
                ActiveCoreRegionNo,
                AddPrio,
                AIPawnEmParamFlag,
                FlgDefaultAttr,
                AttackNoInterval,
                Layer,
                ActiveMaskEffectRegionNo,
                EmSpStatus, AIPawnEnemySpStatusType.of(EmSpStatus)
        );
    }
}
