package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta.AIPawnActionGroupType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta.AIPawnEnemySpStatusType;

import java.util.List;
import java.util.Set;

public record AIPawnEmNode(
        long EmStatusNo,
        List<Long> WeakAttrFlag,
        @MetaInformation
        Set<AIPawnActionGroupType> WeakAttrFlagType,
        List<Long> DisableAttrFlag,
        @MetaInformation
        Set<AIPawnActionGroupType> DisableAttrFlagType,
        List<Long> TargetPosFlag,
        int ActiveCoreRegionNo,
        int AddPrio,
        List<Long> AIPawnEmParamFlag,
        boolean FlgDefaultAttr,
        boolean AttackNoInterval,
        int Layer,
        int ActiveMaskEffectRegionNo,
        int EmSpStatus,
        @MetaInformation
        AIPawnEnemySpStatusType EmSpStatusType

) {
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
