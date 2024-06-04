package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.ui.history;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestHistoryData {
    private long QuestId;
    private int ImageId;
    private int SortId;
}
