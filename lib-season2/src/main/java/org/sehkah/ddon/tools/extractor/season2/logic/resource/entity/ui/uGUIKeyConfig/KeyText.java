package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIKeyConfig;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class KeyText {
    private long KeyCustom;
    private long DetailMsgId;
    private long SortNo;
    private long GroupMsgId;
}
