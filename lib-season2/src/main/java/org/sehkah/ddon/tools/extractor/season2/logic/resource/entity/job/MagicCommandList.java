package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MagicCommandList {
    private List<MagicCommand> Easy;
    private List<MagicCommand> Normal;
    private List<MagicCommand> Hard;
}
