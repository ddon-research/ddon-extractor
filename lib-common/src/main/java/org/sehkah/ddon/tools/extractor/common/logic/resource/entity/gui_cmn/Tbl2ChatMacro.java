package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Tbl2ChatMacro {
    private String Macro;
    private long CmdId;
    private long HelpMsgId;
}
