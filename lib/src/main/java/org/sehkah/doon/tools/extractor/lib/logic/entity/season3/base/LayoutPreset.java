package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record LayoutPreset(
        String Keyword,
        long CtrlType,
        long ID
) implements DeserializableClientResource {
}
