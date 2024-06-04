package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.meta.ArchiveQuality;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ResourceInfo {
    private String Path;
    @MetaInformation
    private long PathCRC;
    @MetaInformation
    private BigInteger ResourceId;
    private long Type;
    @MetaInformation
    private String TypeName;
    @MetaInformation
    private String TypeExtension;
    private long DataSize;
    private long OriginalSize;
    private long Quality;
    @MetaInformation
    private ArchiveQuality QualityName;
    private long Offset;

    public ResourceInfo(String path, long type, long dataSize, long orgSize, long quality, long offset) {
        this(
                path, FrameworkResourcesUtil.convertResourcePathToPathId(path), FrameworkResourcesUtil.convertToResourceId(type, path),
                type, FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(type), FrameworkResourcesUtil.getFileExtension(type),
                dataSize,
                orgSize,
                quality, ArchiveQuality.of(quality),
                offset);
    }
}
