package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.pawn;

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
public class AIPawnActNoSwitchTbl extends Resource {
    private long UnknownArrayMetaData;//TODO buffer size?
    private List<AIPawnActNoSwitch> AIPawnActNoSwitchList;
}