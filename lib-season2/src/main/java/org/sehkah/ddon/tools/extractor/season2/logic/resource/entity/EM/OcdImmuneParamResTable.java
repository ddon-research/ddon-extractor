package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

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
public class OcdImmuneParamResTable extends TopLevelClientResource {
    private List<OcdImmuneParamRes> OcdImmuneParamResTable;
}
