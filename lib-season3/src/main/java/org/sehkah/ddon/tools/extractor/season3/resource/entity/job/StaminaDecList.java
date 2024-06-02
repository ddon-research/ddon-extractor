package org.sehkah.ddon.tools.extractor.season3.resource.entity.job;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.job.meta.StaminaContinuationType;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.job.meta.StaminaUpdateType;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.job.meta.StaminaValueType;

import java.util.List;

public record StaminaDecList(
        List<StaminaDecParam> StaminaDecList,
        long StaminaType,
        long ValueType,
        @MetaInformation
        StaminaValueType ValueTypeName,
        long ContinuationType,
        @MetaInformation
        StaminaContinuationType ContinuationTypeName,
        long UpdateType,
        @MetaInformation
        StaminaUpdateType UpdateTypeName
) {
    public StaminaDecList(List<StaminaDecParam> staminaDecList, long staminaType, long valueType, long continuationType, long updateType) {
        this(
                staminaDecList,
                staminaType,
                valueType, StaminaValueType.of(valueType),
                continuationType, StaminaContinuationType.of(continuationType),
                updateType, StaminaUpdateType.of(updateType)
        );
    }
}
