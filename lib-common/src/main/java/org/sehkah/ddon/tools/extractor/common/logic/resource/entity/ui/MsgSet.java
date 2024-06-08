package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui;

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
public class MsgSet extends Resource {
    private long NativeMsgGroupArrayNum;
    private long NativeMsgDataArrayNum;
    private List<MsgGroup> NativeMsgGroupArray;
}
