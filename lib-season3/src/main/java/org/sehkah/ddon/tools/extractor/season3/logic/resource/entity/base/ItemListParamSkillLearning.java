package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
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
public class ItemListParamSkillLearning extends ItemListParam {
    @JsonIgnore
    private int JobId;
    @MetaInformation
    private JobType JobName;
    @JsonIgnore
    private int SkillNo;
    @MetaInformation
    private Translation SkillName;
    @JsonIgnore
    private int padding;

    public ItemListParamSkillLearning(short kindType, String kindTypeName, int jobId, int skillNo, Translation skillName, int padding) {
        super(kindType, kindTypeName, Map.of(
                "JobId", jobId,
                "SkillNo", skillNo
        ));
        JobId = jobId;
        JobName = JobType.of(jobId);
        SkillNo = skillNo;
        SkillName = skillName;
        this.padding = padding;
    }
}
