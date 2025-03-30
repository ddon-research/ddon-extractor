package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.enhanced_param;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipParamKind;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EnhancedData {
    private long DTIID;
    private int ParamId;
    @MetaInformation
    private ItemListEquipParamKind ParamName;
    private int ParamValue;
}
