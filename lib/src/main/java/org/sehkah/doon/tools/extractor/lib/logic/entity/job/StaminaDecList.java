package org.sehkah.doon.tools.extractor.lib.logic.entity.job;

import org.sehkah.doon.tools.extractor.lib.logic.entity.job.meta.StaminaContinuationType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.job.meta.StaminaUpdateType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.job.meta.StaminaValueType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

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
