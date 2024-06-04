package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.om;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class OmKeyItem {
    private int ItemIndex;
    private long Color;
}
