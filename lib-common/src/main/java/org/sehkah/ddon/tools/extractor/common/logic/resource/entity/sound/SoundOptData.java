package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.meta.SoundRequestCategory;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SoundOptData {
    private long Category;
    @MetaInformation
    private SoundRequestCategory CategoryName;
    private long Item;
    private List<Integer> Channel; // 6

    public SoundOptData(long category, long item, List<Integer> channel) {
        this(
                category, SoundRequestCategory.of(category),
                item,
                channel
        );
    }
}
