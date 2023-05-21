package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record WarpLocationList(
        List<WarpLocation> WarpLocationList
) implements TopLevelClientResource {
}
