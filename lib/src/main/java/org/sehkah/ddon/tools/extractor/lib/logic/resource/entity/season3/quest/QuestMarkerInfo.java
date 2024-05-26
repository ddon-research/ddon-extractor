package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.deserialization.ArrayDataType;
import org.sehkah.ddon.tools.extractor.lib.common.deserialization.DDONPrimitiveDataType;
import org.sehkah.ddon.tools.extractor.lib.common.deserialization.DataType;
import org.sehkah.ddon.tools.extractor.lib.common.deserialization.ResourceHeader;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@ResourceHeader(magicStringSize = DDONPrimitiveDataType.u32, magicNumberSize = DDONPrimitiveDataType.u32)
public class QuestMarkerInfo extends TopLevelClientResource {
    @DataType(size = DDONPrimitiveDataType.u32)
    public long StageNo;
    @ArrayDataType(size = DDONPrimitiveDataType.u32)
    public List<QuestMarkerInfoInfo> InfoList;
}
