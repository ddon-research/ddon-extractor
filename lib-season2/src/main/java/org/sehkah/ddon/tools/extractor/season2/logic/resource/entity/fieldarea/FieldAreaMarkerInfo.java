package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FieldAreaMarkerInfo extends Resource {
    private long FieldAreaId;
    @MetaInformation
    private String FieldAreaName;
    private List<MarkerInfo> MarkerInfoArray;
}
