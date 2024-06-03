package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FurnitureDataList extends TopLevelClientResource {
    private List<FurnitureData> FurnitureDataList;
}
