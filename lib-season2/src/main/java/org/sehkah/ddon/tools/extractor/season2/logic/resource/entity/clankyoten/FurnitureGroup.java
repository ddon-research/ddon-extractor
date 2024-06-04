package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.DynamicResourceLookupUtil;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FurnitureGroup {
    private long ID;
    private long CameraNo;
    private long GmdIdx;
    @MetaInformation
    private String FurnitureGroupName;
    private int SortNo;

    public FurnitureGroup(long ID, long cameraNo, long gmdIdx, int sortNo) {
        this(ID,
                cameraNo,
                gmdIdx, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.FURNITURE_GROUP_NAME, gmdIdx),
                sortNo);
    }
}
