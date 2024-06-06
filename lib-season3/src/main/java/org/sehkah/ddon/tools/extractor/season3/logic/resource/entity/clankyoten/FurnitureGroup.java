package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ResourceMetadataLookupUtilSeason3;

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
                gmdIdx, ResourceMetadataLookupUtilSeason3.getMessage(ResourceFileLookupType.FURNITURE_GROUP_NAME, gmdIdx),
                sortNo);
    }
}
