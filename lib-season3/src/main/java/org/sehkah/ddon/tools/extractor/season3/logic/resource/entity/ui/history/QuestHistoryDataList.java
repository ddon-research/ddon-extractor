package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.history;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestHistoryDataList extends Resource {
    private List<QuestHistoryData> QuestHistoryDataList;
}
