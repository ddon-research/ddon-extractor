package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record Tbl2ChatMacro(
        String Macro,
        long CmdId,
        long HelpMsgId
) implements DeserializableClientResource {
}
