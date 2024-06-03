package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.LandAreaInfoGameMode;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class LandAreaInfo {
    private long LandId;
    @MetaInformation
    private String LandName;
    private boolean IsDispNews;
    private int GameMode;
    @MetaInformation
    private LandAreaInfoGameMode GameModeName;
    private List<Long> AreaIds;

    public LandAreaInfo(long landId, boolean isDispNews, int gameMode, List<Long> areaIds) {
        this(
                landId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.LAND_NAME, landId - 1),
                isDispNews,
                gameMode, LandAreaInfoGameMode.of(gameMode),
                areaIds);
    }
}
