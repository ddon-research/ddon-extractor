package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListElementType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.JobType;

import java.util.Map;

@Slf4j
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListParamBbElementUp extends ItemListParam {
    @JsonIgnore
    private int JobId;
    @MetaInformation
    private JobType JobName;
    @JsonIgnore
    private int ElementType;
    @MetaInformation
    private ItemListElementType ElementTypeName;
    @JsonIgnore
    private int padding1;
    @JsonIgnore
    private int padding2;

    public ItemListParamBbElementUp(short kindType, String kindTypeName, int jobId, int elementType, int padding1, int padding2) {
        super(kindType, kindTypeName, Map.of(
                "JobId", jobId,
                "ElementType", elementType
        ));
        JobId = jobId;
        JobName = JobType.of(jobId);
        ElementType = elementType;
        ElementTypeName = ItemListElementType.of(elementType - 1L);
        this.padding1 = padding1;
        this.padding2 = padding2;
    }
}
