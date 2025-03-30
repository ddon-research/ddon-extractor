package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GroupParamLoadCondition {
    private long LoadCondition;
    private boolean LotFlag;
    private boolean LayoutFlag;
    private boolean RandomOnly;
    private boolean Stage;
    private boolean Version;
    private boolean Omit;
}
