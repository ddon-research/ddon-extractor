package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.deserialization.DDONPrimitiveDataType;
import org.sehkah.ddon.tools.extractor.lib.common.deserialization.DataType;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestMarkerInfoInfo {
    @DataType(size = DDONPrimitiveDataType.vector3f)
    private Vector3f Pos;
    @DataType(size = DDONPrimitiveDataType.u32)
    private long GroupNo;
    @DataType(size = DDONPrimitiveDataType.u32)
    private long UniqueId;
}
