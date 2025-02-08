package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AdjoinInfo {
    private short DestinationStageNo;
    @MetaInformation
    private Translation DestinationStageName;
    private short NextStageNo;
    @MetaInformation
    private Translation NextStageName;
    private List<AdjoinInfoVector3> Positions;
    private int Priority;
}
