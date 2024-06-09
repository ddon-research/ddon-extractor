package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.job;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.job.meta.MagicChantWordType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MagicCommandWord {
    private List<Integer> MagicCommand;
    @MetaInformation
    private String MagicCommandName;

    public MagicCommandWord(List<Integer> word) {
        this(word, MagicChantWordType.toString(word));
    }
}
