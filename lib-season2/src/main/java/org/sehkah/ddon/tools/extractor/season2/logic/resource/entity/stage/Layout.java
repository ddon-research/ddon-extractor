package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

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
public final class Layout extends TopLevelClientResource {
    private final List<Long> SetInfoNeedNums; // exactly 22 in season 2
    private final List<LayoutSetInfo> Array;

}
