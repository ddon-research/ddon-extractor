package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class LayoutGroupParamList extends Resource {
    private List<Long> GroupList;
    private long GroupParamBuffSize;
    private LayoutGroupParamNativeAllocInfo AllocInfo;
    private List<GroupParam> GroupParamBuff;
    @MetaInformation
    private int StageNo;
    @MetaInformation
    private Translation StageName;
    @MetaInformation
    private int AreaId;
    @MetaInformation
    private Translation AreaName;
}
