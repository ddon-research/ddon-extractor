package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.meta.StageInfoType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record StageListInfo(
        long StageNo,
        long Type,
        @MetaInformation
        StageInfoType TypeName,
        int RecommendLevel,
        long MessageId,
        long Version
) implements DeserializableClientResource {
    public StageListInfo(long stageNo, long type, int recommendLevel, long messageId, long version) {
        this(
                stageNo,
                type, StageInfoType.of(type),
                recommendLevel,
                messageId,
                version);
    }
}
