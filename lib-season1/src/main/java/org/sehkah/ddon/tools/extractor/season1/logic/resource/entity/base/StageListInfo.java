package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.StageInfoType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageListInfo {
    private long StageNo;
    @MetaInformation
    private long StageId;
    private long Type;
    @MetaInformation
    private StageInfoType TypeName;
    private int RecommendLevel;
    private long MessageId;
    @MetaInformation
    private String StageName;
    private long Version;

    public StageListInfo(long stageNo, long type, int recommendLevel, long messageId, long version) {
        this(
                stageNo, Long.parseLong(DynamicResourceLookupUtil.getMessageKey(ResourceFileLookupType.STAGE_LIST, messageId).replace("STAGE_NAME_", "")),
                type, StageInfoType.of(type),
                recommendLevel,
                messageId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.STAGE_LIST, messageId),
                version);
    }
}
