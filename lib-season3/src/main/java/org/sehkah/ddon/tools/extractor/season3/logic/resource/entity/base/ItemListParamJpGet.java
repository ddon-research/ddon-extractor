package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
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
public class ItemListParamJpGet extends ItemListParam {
    /**
     * The JobId will be dumped via the parent's attributes instead, so ignore here.
     */
    @JsonIgnore
    private int JobId;
    @MetaInformation
    private JobType JobName;
    @JsonIgnore
    private int Point;
    @JsonIgnore
    private int padding;

    public ItemListParamJpGet(short kindType, String kindTypeName, int jobId, int point, int padding) {
        super(kindType, kindTypeName, Map.of(
                "JobId", jobId,
                "Point", point
        ));
        JobId = jobId;
        JobName = JobType.of(jobId);
        Point = point;
        this.padding = padding;
    }
}
