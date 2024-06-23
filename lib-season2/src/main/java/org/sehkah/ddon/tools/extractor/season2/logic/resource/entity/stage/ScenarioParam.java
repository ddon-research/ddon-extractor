package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.ScenarioBootType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.ScenarioCheckType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.ScenarioStatusType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.ScenarioTaskType;

import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ScenarioParam {
    private long TaskType;
    @MetaInformation
    private ScenarioTaskType TaskTypeName;
    private long BootType;
    @MetaInformation
    private ScenarioBootType BootTypeName;
    private long Status;
    @MetaInformation
    private Set<ScenarioStatusType> StatusType;
    private long DetectAttr;
    private long CheckType;
    @MetaInformation
    private ScenarioCheckType CheckTypeName;
    private long Priority;
}
