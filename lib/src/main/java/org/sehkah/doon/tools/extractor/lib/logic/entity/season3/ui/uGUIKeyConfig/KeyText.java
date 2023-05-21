package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIKeyConfig;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record KeyText(
        long KeyCustom,
        long DetailMsgId,
        long SortNo,
        long GroupMsgId
) implements DeserializableClientResource {
}
