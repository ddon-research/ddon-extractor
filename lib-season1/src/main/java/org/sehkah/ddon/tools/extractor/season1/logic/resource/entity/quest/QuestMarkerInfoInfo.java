package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.deserialization.DDONPrimitiveDataType;
import org.sehkah.ddon.tools.extractor.api.deserialization.DataType;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestMarkerInfoInfo {
    @DataType(size = DDONPrimitiveDataType.vector3f)
    public Vector3f Pos;
    @DataType(size = DDONPrimitiveDataType.u32)
    public long GroupNo;
    @DataType(size = DDONPrimitiveDataType.u32)
    public long UniqueId;
}
