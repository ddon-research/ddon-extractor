package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.meta.StaminaContinuationType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.meta.StaminaUpdateType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.meta.StaminaValueType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StaminaDecList {
    private List<StaminaDecParam> StaminaDecList;
    private long StaminaType;
    private long ValueType;
    @MetaInformation
    private StaminaValueType ValueTypeName;
    private long ContinuationType;
    @MetaInformation
    private StaminaContinuationType ContinuationTypeName;
    private long UpdateType;
    @MetaInformation
    private StaminaUpdateType UpdateTypeName;

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
