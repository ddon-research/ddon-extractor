package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.MyRoom;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record AnimalData(
        Vector3f Pos,
        Vector3f Angle
) implements DeserializableClientResource {
}
