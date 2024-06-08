package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.deserialization.ArrayDataType;
import org.sehkah.ddon.tools.extractor.api.deserialization.DDONPrimitiveDataType;
import org.sehkah.ddon.tools.extractor.api.deserialization.DataType;
import org.sehkah.ddon.tools.extractor.api.deserialization.ResourceHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@ResourceHeader(magicStringSize = DDONPrimitiveDataType.u32, magicNumberSize = DDONPrimitiveDataType.u32)
public class QuestMarkerInfo extends Resource {
    @DataType(size = DDONPrimitiveDataType.u32)
    public long StageNo;
    @ArrayDataType(size = DDONPrimitiveDataType.u32)
    public List<QuestMarkerInfoInfo> InfoList;
}
