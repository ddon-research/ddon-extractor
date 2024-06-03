package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.pawn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class AIPawnActNoSwitchTbl extends TopLevelClientResource {
    private final long UnknownArrayMetaData;
    private final List<AIPawnActNoSwitch> AIPawnActNoSwitchList;
}
