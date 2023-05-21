package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIDogmaOrb;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record GUIDogmaOrbRes(
        long ElementId,
        long ParamType,
        long ParamId,
        long ParamValue,
        long RequireOrb,
        long IconNo
) implements DeserializableClientResource {
}
